package com.cybion.cpt.web.core.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.cybion.cpt.web.core.controller.action.CybionAction;


public class LoginController extends SimpleFormController implements Controller{
	
	private CybionAction action;
	

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
			
		
		String result = "index";
		try{
		
		//if(action.doWork(request))
			result = "indexAdmin";
		}
		catch(Throwable t){}
		
		return new ModelAndView(result);
}
	
	public CybionAction getAction() {
		return action;
	}
	public void setAction(CybionAction action) {
		this.action = action;
	}
}
