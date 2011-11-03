package org.springframework.security.oauth.examples.ctctOAuth2WebClient.mvc;

import org.springframework.security.oauth.examples.ctctOAuth2WebClient.ClientFlowService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ryan Heaton
 */
public class ClientFlowController extends AbstractController {

  private ClientFlowService clientFlowService;
  
  
  protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
	  return new ModelAndView("clientflow", "appId", 
            getClientFlowService().getAppId( request.getParameter("env")));
  }

  public ClientFlowService getClientFlowService() {
    return clientFlowService;
  }

  public void setClientFlowService(ClientFlowService clientFlowService) {
    this.clientFlowService = clientFlowService;
  }
}