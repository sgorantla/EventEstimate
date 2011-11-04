package com.eventestimator.mvc;

import com.eventestimator.ClientFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "clientflow")
public class ClientFlowController extends AbstractController {

  @Autowired
  private ClientFlowService clientFlowService;
  
  @RequestMapping(value="/tab", method= RequestMethod.GET)
  protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
	  return new ModelAndView("clientflow", "appId", 
            clientFlowService.getAppId( "prod"));
  }

}