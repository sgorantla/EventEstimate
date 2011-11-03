package org.springframework.security.oauth.examples.ctctOAuth2WebClient.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth.examples.ctctOAuth2WebClient.SparklrException;
import org.springframework.security.oauth.examples.ctctOAuth2WebClient.SparklrService;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.consumer.*;
import org.springframework.security.oauth2.consumer.token.OAuth2ClientTokenServices;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.LogFactory;

/**
 * @author Ryan Heaton
 */
public class SparklrServiceImpl implements SparklrService {

    private Properties urls;
    private String sparklrPhotoURLPattern;
    private Map<String, OAuth2RestTemplate> oauth2RestTemplates;
    private OAuth2ClientTokenServices tokenServices;
    
    protected static Log logger = LogFactory.getLog(SparklrServiceImpl.class);

    public List<String> getPhotoIds(String resourceId) throws SparklrException {
        
        try {
            InputStream photosXML = new ByteArrayInputStream(getRestTemplate(resourceId).getForObject(URI.create((String) getUrls().get(resourceId)), byte[].class));

            
            final List<String> listIds = new ArrayList<String>();
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            parserFactory.setValidating(false);
            parserFactory.setXIncludeAware(false);
            parserFactory.setNamespaceAware(false);
            SAXParser parser = parserFactory.newSAXParser();
            
            
            parser.parse(photosXML, new DefaultHandler() {

                private boolean isId = false;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if ("id".equals(qName)) {
                        isId = true;
                    }
                }

                @Override
                public void characters(char ch[], int start, int length)
                        throws SAXException {
                    if (isId) {
                        String id = new String(ch, start, length);
                        System.out.println("id : " + id);
                        listIds.add(id);
                        isId = false;
                    }
                }
            });
            return listIds;
        } catch (InvalidTokenException badToken) {
            //we've got a bad token, probably because it's expired.
            OAuth2ProtectedResourceDetails resource = getRestTemplate(resourceId).getResource();
            OAuth2SecurityContext context = OAuth2SecurityContextHolder.getContext();
            if (context != null) {
                // this one is kind of a hack for this application
                // the problem is that the sparklr photos page doesn't remove the 'code=' request parameter.
                ((OAuth2SecurityContextImpl) context).setVerificationCode(null);
            }
            //clear any stored access tokens...
            getTokenServices().removeToken(SecurityContextHolder.getContext().getAuthentication(), resource);
            //go get a new access token...
            throw new OAuth2AccessTokenRequiredException(resource);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        } catch (SAXException e) {
            throw new IllegalStateException(e);
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException(e);
        } catch (Exception ex) {
            logger.error("\n\n----------------- error !!!!!! -----\n\n" + ex);
            System.err.println("\n\n----------------- error !!!!!! -----\n\n" + ex);
            throw new RuntimeException(ex);
        }
    }

    public InputStream loadSparklrPhoto(String resourceId, String id) throws SparklrException {
        return new ByteArrayInputStream(
                getRestTemplate(resourceId)
                .getForObject(URI.create(String.format(getSparklrPhotoURLPattern(), id)), byte[].class));
    }

    public String getSparklrPhotoURLPattern() {

        return sparklrPhotoURLPattern;
    }

    public void setSparklrPhotoURLPattern(String sparklrPhotoURLPattern) {
        this.sparklrPhotoURLPattern = sparklrPhotoURLPattern;
    }

    

    public OAuth2RestTemplate getRestTemplate(String resourceId) {
        return oauth2RestTemplates.get(resourceId);
    }

    public void setOauth2RestTemplates(Map<String, OAuth2RestTemplate> sparklrRestTemplate) {
        this.oauth2RestTemplates = sparklrRestTemplate;
    }

    public OAuth2ClientTokenServices getTokenServices() {
        return tokenServices;
    }

    public void setTokenServices(OAuth2ClientTokenServices tokenServices) {
        this.tokenServices = tokenServices;
    }

    public Properties getUrls() {
        return urls;
    }

    public void setUrls(Properties urls) {
        this.urls = urls;
    }


}
