package com.cybion.cpt.web.core.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;

import com.cybion.cpt.web.core.controller.action.CybionAction;


public class InsertConcernController extends AbstractController implements
		Controller {
	
	private CybionAction action;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
			String result = "insertInteresse";
		try {
				if(action.doWork(arg0))
					result="success";
		}catch(Exception e){e.printStackTrace();}
		String s = (String)arg0.getAttribute("nomeInteresse");
		ModelAndView m = new ModelAndView(result);
		m.addObject("message", "Hai inserito un nuovo interesse: "+s);
		return m;
	}

	public CybionAction getAction() {
		return action;
	}

	public void setAction(CybionAction action) {
		this.action = action;
	}
	
	
	

}
