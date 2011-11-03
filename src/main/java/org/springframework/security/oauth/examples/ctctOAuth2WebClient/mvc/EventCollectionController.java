package org.springframework.security.oauth.examples.ctctOAuth2WebClient.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    private static final String WS_URL_PREFIX = "https://api.constantcontact.com/ws/customer/";
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse httpServletResponse) throws Exception {
        String accessToken = request.getParameter("accessToken");
        String userName = request.getParameter("userName");
        String eventUrl = WS_URL_PREFIX + userName + "events";
        String contactUrl = WS_URL_PREFIX + userName + "events";

        

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
