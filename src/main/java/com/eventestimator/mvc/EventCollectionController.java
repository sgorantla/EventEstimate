package com.eventestimator.mvc;

import com.eventestimator.model.Contact;
import com.sun.syndication.feed.atom.Content;
import com.sun.syndication.feed.atom.Entry;
import com.sun.syndication.feed.atom.Feed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@RequestMapping(value = "events")
public class EventCollectionController {
    @Autowired
    RestTemplate restTemplate;
    private static final String WS_URL_PREFIX = "https://api.constantcontact.com/ws/customers/";
    @RequestMapping(value="/tab", method= RequestMethod.GET)
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse httpServletResponse) throws Exception {

        String accessToken = request.getParameter("access_token");
        String userName = request.getParameter("userName");
        String eventUrl = WS_URL_PREFIX + userName + "/events?access_token="+accessToken;
        String contactUrl = WS_URL_PREFIX + userName + "/contacts?access_token="+accessToken;

        Feed contactSource = restTemplate.getForObject(contactUrl, Feed.class);
        List<Entry> contacts = contactSource.getEntries();
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
            InputSource is = new InputSource(contentXML);
            SAXSource source = new SAXSource(reader, is);
            JAXBContext context = JAXBContext.newInstance();
            javax.xml.bind.Unmarshaller unmarshaller = context.createUnmarshaller();

            JAXBElement<Contact> contactObject = (JAXBElement<Contact>)unmarshaller.unmarshal(source);
            System.out.println("!!!!" + contactObject.getValue().getEmailAddress());
        }
        return new ModelAndView("cf_redir_page");
    }
}
