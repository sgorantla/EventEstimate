package com.eventestimator.mvc;

import com.eventestimator.model.Contact;
import com.sun.syndication.feed.atom.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    RestTemplate restTemplate;
    private static final String WS_URL_PREFIX = "https://api.constantcontact.com/ws/customers/";
    @RequestMapping(value="/tab.j", method= RequestMethod.GET)
    protected String handleRequestInternal(Model model ,HttpServletRequest request) throws Exception {

        String accessToken = request.getParameter("access_token");
        String userName = request.getParameter("userName");
        String eventUrl = WS_URL_PREFIX + userName + "/events?access_token="+accessToken;
        String contactUrl = WS_URL_PREFIX + userName + "/contacts?access_token="+accessToken;

        Feed contactSource = restTemplate.getForObject(contactUrl, Feed.class);
        List<Entry> contacts = contactSource.getEntries();
        List<Contact> contactObjects = new ArrayList<Contact>(contacts.size());
        for (Entry contact : contacts) {
            List<Content> contactContents = contact.getContents();
            Content contactContent = contactContents.get(0);
            String contentXML = contactContent.getValue();
            
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
            JAXBContext context = JAXBContext.newInstance(Contact.class);
            javax.xml.bind.Unmarshaller unmarshaller = context.createUnmarshaller();
            JAXBElement<Contact> contactObject = (JAXBElement<Contact>)unmarshaller.unmarshal(source, Contact.class);
            contactObjects.add(contactObject.getValue());
        }
        HttpSession session = request.getSession();
        session.setAttribute("accessToke", accessToken);
        session.setAttribute("contacts", contactObjects);
        model.addAttribute("contacts", contactObjects);
        return "contact_list";
    }
}
