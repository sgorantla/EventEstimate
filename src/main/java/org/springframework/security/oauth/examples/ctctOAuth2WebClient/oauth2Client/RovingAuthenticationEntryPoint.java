/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.security.oauth.examples.ctctOAuth2WebClient.oauth2Client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

/**
 *
 * @author gcheng
 */
public class RovingAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {
 
    @Override
    public void commence(HttpServletRequest request, 
                        HttpServletResponse response, 
                        AuthenticationException authException)
            throws IOException, ServletException {
        
        HttpSession session = request.getSession();
        String key = AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY;
        session.setAttribute(key, authException);
        super.commence(request, response, authException);
    }
}
