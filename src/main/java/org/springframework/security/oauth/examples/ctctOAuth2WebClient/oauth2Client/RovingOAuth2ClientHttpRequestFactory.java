/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.security.oauth.examples.ctctOAuth2WebClient.oauth2Client;

import java.io.IOException;
import java.lang.IllegalArgumentException;
import java.net.URI;
import java.util.Map;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.consumer.OAuth2AccessDeniedException;
import org.springframework.security.oauth2.consumer.OAuth2AccessTokenRequiredException;
import org.springframework.security.oauth2.consumer.OAuth2ClientHttpRequestFactory;
import org.springframework.security.oauth2.consumer.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.consumer.OAuth2SecurityContext;
import org.springframework.security.oauth2.consumer.OAuth2SecurityContextHolder;


/**
 *
 * @author gcheng
 */
public class RovingOAuth2ClientHttpRequestFactory extends OAuth2ClientHttpRequestFactory {
    private ClientHttpRequestFactory delegate = new SimpleClientHttpRequestFactory() ;
    private OAuth2ProtectedResourceDetails resource;
    private static final String TOKEN_TYPE = "Bearer";
    
    public RovingOAuth2ClientHttpRequestFactory(ClientHttpRequestFactory delegate, 
                                                OAuth2ProtectedResourceDetails resource1) throws IllegalArgumentException
    {
        super(delegate, resource1);
        this.resource = resource1;
    }
    
    
    /**
     * 
     * @param uri
     * @param httpMethod
     * @return
     * @throws java.io.IOException
     */
    @Override
    public ClientHttpRequest createRequest(URI uri, HttpMethod httpMethod) throws IOException {
    OAuth2SecurityContext context = OAuth2SecurityContextHolder.getContext();
    if (context == null) {
      throw new IllegalStateException("No OAuth 2 security context has been established. Unable to access resource '" 
               + this.resource.getId() + "'.");
    }

    Map<String,OAuth2AccessToken> accessTokens = context.getAccessTokens();
    OAuth2AccessToken accessToken = accessTokens == null ? null : accessTokens.get(this.resource.getId());
    if (accessToken == null) {
      throw new OAuth2AccessTokenRequiredException("No OAuth 2 security context has been established. Unable to access resource '" + this.resource.getId() + "'.", resource);
    }

    String tokenType = accessToken.getTokenType();
    if (tokenType == null || "".equals(tokenType)) {
      tokenType = TOKEN_TYPE; //we'll assume basic bearer token type if none is specified.
    }
    if (TOKEN_TYPE.equalsIgnoreCase(tokenType)) {
      OAuth2ProtectedResourceDetails.BearerTokenMethod bearerTokenMethod = resource.getBearerTokenMethod();
      if (OAuth2ProtectedResourceDetails.BearerTokenMethod.query.equals(bearerTokenMethod)) {
        uri = appendQueryParameter(uri, accessToken);
      }

      ClientHttpRequest req = delegate.createRequest(uri, httpMethod);
      if (OAuth2ProtectedResourceDetails.BearerTokenMethod.header.equals(bearerTokenMethod)) {
        req.getHeaders().add("Authorization", String.format(TOKEN_TYPE + " %s", accessToken.getValue()));
      }
      return req;
    }
    else {
      throw new OAuth2AccessDeniedException("Unsupported access token type: " + tokenType);
    }
  }
    
}
