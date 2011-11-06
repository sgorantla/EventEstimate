package com.eventestimator.mvc;

import com.eventestimator.model.Contact;
import com.eventestimator.model.ContactEntry;
import com.sun.syndication.feed.atom.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.sax.SAXSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2008 by Constant Contact Inc.,
 * Boston, MA 02451, USA
 * Phone: (781) 472-8100
 * Fax: (781) 472-8101
 * Created on: 	 11/3/11
 *
 * @author sgorantla
 *         All rights reserved.
 *         <p/>
 *         This software is the confidential and proprietary information
 *         of Constant Contact, Inc. created for Constant Contact, Inc.
 *         You shall not disclose such Confidential Information and shall use
 *         it only in accordance with the terms of the license agreement
 *         you entered into with Constant Contact, Inc.
 */

@Controller
@RequestMapping(value = "contacts")
public class ContactCollectionController {
    private static final String WS_DOMAIN = "https://api.constantcontact.com";

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String WS_URL_PREFIX = "https://api.constantcontact.com/ws/customers/";
    @RequestMapping(value="/tab.j", method= RequestMethod.GET)
    protected String handleRequestInternal(Model model ,HttpServletRequest request) throws Exception {

        String accessToken = request.getParameter("access_token");
        String userName = request.getParameter("userName");
        String eventUrl = WS_URL_PREFIX + userName + "/events?access_token="+accessToken;
        String contactUrl = WS_URL_PREFIX + userName + "/contacts?access_token="+accessToken;

        HttpSession session = request.getSession();
        session.setAttribute("accessToken", accessToken);
        session.setAttribute("userName", userName);
        return "contact_list";
    }

    @RequestMapping(value="/json.j", method= RequestMethod.GET)
    protected ResponseEntity<Object> getContacts(Model model ,HttpServletRequest request) throws Exception {

        HttpSession session = request.getSession();
        String userName = (String)session.getAttribute("userName");
        String accessToken = (String)session.getAttribute("accessToken");
        String contactUrl = WS_URL_PREFIX + userName + "/contacts?access_token="+accessToken;
        Feed contactSource = restTemplate.getForObject(contactUrl, Feed.class);
        List<Entry> contacts = contactSource.getEntries();
        List<Contact> contactObjects = new ArrayList<Contact>(contacts.size());
        for (Entry contact : contacts) {

            Link link = (Link)contact.getOtherLinks().get(0);

            String linkHref = link.getHref();
            String contentXML = restTemplate.getForObject(WS_DOMAIN + linkHref + "?access_token=" + accessToken, String.class);
//            List<Content> contactContents = contactEntry.getBody().getContents();
//            List<Content> contactContents = contactEntry.getContents();
//
//            Content contactContent = contactContents.get(0);
//            String contentXML = contactContent.getValue();

            final SAXParserFactory sax = SAXParserFactory.newInstance();
            sax.setNamespaceAware(false);
            final XMLReader reader;
            try {
                reader = sax.newSAXParser().getXMLReader();
            } catch (SAXException e) {
                throw new RuntimeException(e);
            }
            InputSource is = new InputSource(new StringReader(contentXML));
            SAXSource source = new SAXSource(reader, is);
            JAXBContext context = JAXBContext.newInstance(ContactEntry.class);
            javax.xml.bind.Unmarshaller unmarshaller = context.createUnmarshaller();
            JAXBElement<ContactEntry> contactEntry = (JAXBElement<ContactEntry>)unmarshaller.unmarshal(source, ContactEntry.class);
            Contact contactObject = contactEntry.getValue().getContent().getContact();
            contactObjects.add(contactObject);
        }
         ResponseEntity<Object> response = new ResponseEntity<Object>(contactObjects, HttpStatus.OK);
        return  response;

    }

}
