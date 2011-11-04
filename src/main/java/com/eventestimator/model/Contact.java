package com.eventestimator.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Copyright 2008 by Constant Contact Inc.,
 * Boston, MA 02451, USA
 * Phone: (781) 472-8100
 * Fax: (781) 472-8101
 * Created on: 	 11/4/11
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

@XmlRootElement
public class Contact {
    private String status;
    private String emailAddress;
    private String emailType;
    private String name;
    private String optInSource;
    private String addr1;
    private String city;
    private String stateCode;
    private String postalCode;

    @XmlElement(name = "Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @XmlElement(name = "EmailAddress")
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @XmlElement(name = "EmailType")
    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    @XmlElement(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "OptInSource")
    public String getOptInSource() {
        return optInSource;
    }

    public void setOptInSource(String optInSource) {
        this.optInSource = optInSource;
    }

    @XmlElement(name = "Addr1")
    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    @XmlElement(name = "City")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlElement(name = "StateCode")
    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    @XmlElement(name = "PostalCode")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (addr1 != null ? !addr1.equals(contact.addr1) : contact.addr1 != null) return false;
        if (city != null ? !city.equals(contact.city) : contact.city != null) return false;
        if (emailAddress != null ? !emailAddress.equals(contact.emailAddress) : contact.emailAddress != null)
            return false;
        if (emailType != null ? !emailType.equals(contact.emailType) : contact.emailType != null) return false;
        if (name != null ? !name.equals(contact.name) : contact.name != null) return false;
        if (optInSource != null ? !optInSource.equals(contact.optInSource) : contact.optInSource != null) return false;
        if (postalCode != null ? !postalCode.equals(contact.postalCode) : contact.postalCode != null) return false;
        if (stateCode != null ? !stateCode.equals(contact.stateCode) : contact.stateCode != null) return false;
        if (status != null ? !status.equals(contact.status) : contact.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
        result = 31 * result + (emailType != null ? emailType.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (optInSource != null ? optInSource.hashCode() : 0);
        result = 31 * result + (addr1 != null ? addr1.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (stateCode != null ? stateCode.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        return result;
    }
}
