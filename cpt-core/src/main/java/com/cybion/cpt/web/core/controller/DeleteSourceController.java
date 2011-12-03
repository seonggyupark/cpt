package com.cybion.cpt.web.core.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;

import com.cybion.cpt.web.core.controller.action.CybionAction;
import com.cybion.cpt.web.core.model.Source;


public class DeleteSourceController extends AbstractController implements
		Controller {
	
	private Logger logger = Logger.getLogger(this.getClass());
	private CybionAction action;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		String result = "editFonte";
		try {
			if(action.doWork(arg0))
				result = "success";
		}catch(Exception e){logger.error("CONTROLLER EXCEPTION", e);}
			String message = (String) arg0.getAttribute("message");
			ModelAndView m = new ModelAndView(result);
			m.addObject("message", message);
			return m;
	}
	
	
	public CybionAction getAction() {
		return action;
	}

	public void setAction(CybionAction action) {
		this.action = action;
	}
	

}
