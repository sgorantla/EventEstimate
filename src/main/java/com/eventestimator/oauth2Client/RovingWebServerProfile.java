/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventestimator.oauth2Client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.consumer.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.consumer.OAuth2SecurityContext;
import org.springframework.security.oauth2.consumer.OAuth2SecurityContextHolder;
import org.springframework.security.oauth2.consumer.UserRedirectRequiredException;
import org.springframework.security.oauth2.consumer.webserver.WebServerProfile;
import org.springframework.security.oauth2.consumer.webserver.WebServerProfileResourceDetails;
import org.springframework.util.StringUtils;



/**
 *
 * @author gcheng
 */
public class RovingWebServerProfile extends WebServerProfile {
    
    @Override
    public OAuth2AccessToken obtainNewAccessToken(OAuth2ProtectedResourceDetails details)
            throws UserRedirectRequiredException, AccessDeniedException {
        
        WebServerProfileResourceDetails resource = (WebServerProfileResourceDetails) details;
        OAuth2SecurityContext context = OAuth2SecurityContextHolder.getContext();
        String verificationCode = null;
        if (context != null) {
            verificationCode = context.getVerificationCode();
        }

        if (context != null && context.getErrorParameters() != null) {
            return super.obtainNewAccessToken(details);
        } else if (verificationCode == null) {
            return super.obtainNewAccessToken(details);
        }

        //we've got the verification code. now we should be able to get an access token.
        List<NameValuePair> m_formData = new ArrayList<NameValuePair>();
        m_formData.add(new BasicNameValuePair("grant_type", "authorization_code"));
        m_formData.add(new BasicNameValuePair("client_id", resource.getClientId()));
        m_formData.add(new BasicNameValuePair("client_secret", resource.getClientSecret()));
        m_formData.add(new BasicNameValuePair("code", verificationCode));


        Object state = context == null ? null : context.getPreservedState();
        if (state == null) {
            //no state preserved? check for a pre-established redirect uri.
            state = resource.getPreEstablishedRedirectUri();
        }

        if (state == null) {
            //still no redirect uri? just try the one for the current context...
            state = context == null ? null : context.getUserAuthorizationRedirectUri();
        }

        m_formData.add(new BasicNameValuePair("redirect_uri", String.valueOf(state)));

        HttpServletRequest request = (HttpServletRequest) context.getDetails();
        OAuth2AccessToken o2token = null;
        try{
            o2token = exchangeToken(m_formData, resource, request);
        } catch(IOException ie){
            System.out.println("IOException in RovingWebServerProfile.obtainNewAccessToken" + ie);
        }
        return o2token;    
        
    }
    
    
    private OAuth2AccessToken exchangeToken(List<NameValuePair> form, 
                                            WebServerProfileResourceDetails resource,
                                            HttpServletRequest request) throws IOException {
        
        CookieStore m_stickyCookies = new BasicCookieStore();
        for (Cookie c : request.getCookies()) {
            BasicClientCookie cookie = new BasicClientCookie(c.getName(), c.getValue());
            cookie.setPath(c.getPath());
            cookie.setDomain(c.getDomain());
            m_stickyCookies.addCookie(cookie);
        }
        
        
        DefaultHttpClient m_client = new DefaultHttpClient();
        HttpResponse response = null;
        HttpPost httpPost = null;
        try {
            m_client.setCookieStore(m_stickyCookies);

            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(form, HTTP.UTF_8);
            httpPost = new HttpPost(resource.getAccessTokenUri());
            httpPost.setEntity(entity);
            response = m_client.execute(httpPost);
        } catch (Exception e) {
            System.out.println("Exception occured while tring to get access token :" + e);
        }
        int responseCode = response.getStatusLine().getStatusCode();
        if (responseCode == 401) {
            OAuth2Exception oe = getSerializationService().deserializeJsonError(response.getEntity().getContent());
            System.out.println("oauth2 response code for token is 401" + oe);
            //String responseBody = IOUtils.toString(response.getEntity().getContent());
            //System.out.println("401 occurred in getting access token " + responseBody);
            return null;
        }
        if (200 != responseCode) {
            System.out.println("oauth2 response code for token is not 200, instead, it is " + responseCode);
            return null;
        }
        //assertEquals("no-store", response.getHeaders().getFirst("Cache-Control"));
        for (Header hdr : response.getHeaders("Cache-Control")) {
            // header name = "Cache-Control"
            // header value = '"no-store, private, no-cache, no-store, max-age=0, must-revalidate, no-cache="Set-Cookie"'
            if (!StringUtils.hasText(hdr.getValue())
                    || !hdr.getValue().matches("\\s*no-store[,\\s]*.*")) {
                System.out.println("should specify no-store for Cache-Control header");
                return null;
            }
        }
        OAuth2AccessToken accessToken = this.getSerializationService().deserializeJsonAccessToken(response.getEntity().getContent());
        return accessToken;
    }
    
    
}
