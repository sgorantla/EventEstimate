package com.eventestimator.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Copyright 2008 by Constant Contact Inc.,
 * Boston, MA 02451, USA
 * Phone: (781) 472-8100
 * Fax: (781) 472-8101
 * Created on: 	 11/6/11
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
@XmlRootElement(name = "Entry")
public class ContactEntry {
    private Content content;

    @XmlElement
    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @XmlRootElement
    public static class Content {
        private Contact contact;

    @XmlElement(name = "Contact")
    public Contact getContact() {
            return contact;
        }

        public void setContact(Contact contact) {
            this.contact = contact;
        }
    }
}
