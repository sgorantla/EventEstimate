package com.eventestimator.mvc;

import com.eventestimator.model.Contact;
import com.eventestimator.model.Event;
import com.sun.syndication.feed.atom.Content;
import com.sun.syndication.feed.atom.Entry;
import com.sun.syndication.feed.atom.Feed;
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
import java.util.Calendar;
import java.util.Date;
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
public class EventController {
    @Autowired
    RestTemplate restTemplate;
    private static final String WS_URL_PREFIX = "https://api.constantcontact.com/ws/customers/";
    @RequestMapping(value="/create", method= RequestMethod.GET)
    protected String handleRequestInternal(Model model ,HttpServletRequest request) throws Exception {

        String accessToken = request.getParameter("access_token");
        String userName = request.getParameter("userName");
        String eventUrl = WS_URL_PREFIX + userName + "/events?access_token="+accessToken;
        Event event = new Event();
        event.setDescription("Example event");
        event.setName("Sri  " + new Date().toString());
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.DATE, 2);
        event.setStartDate(startDate.getTime());
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.DATE, 2);
        event.setEndDate(endDate.getTime());
        event.setEventType("EventType");
        Entry entry = new Entry();
        List<Event> events = new ArrayList<Event>(1);
        events.add(event);
        entry.setContents(events);
        Entry eventResult = restTemplate.postForObject(eventUrl, entry, Entry.class);
        return "contact_list";
    }
}
