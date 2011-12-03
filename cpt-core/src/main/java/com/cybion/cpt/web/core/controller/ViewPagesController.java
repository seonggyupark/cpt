package com.cybion.cpt.web.core.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;

import com.cybion.cpt.web.core.controller.action.CybionAction;
import com.cybion.cpt.web.core.model.CrawledPage;
import com.cybion.cpt.web.core.model.Source;


public class ViewPagesController extends AbstractController implements Controller{
	
	private CybionAction action;
	
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		String result = "indexAdmin";
		try {
			if(action.doWork(arg0))
				result = "viewPages";
		}catch(Exception e){e.printStackTrace();}
		
		ModelAndView m = new ModelAndView(result);
		List<CrawledPage> listaPagine = (List<CrawledPage>)arg0.getAttribute("listaPagine");
		m.addObject("listaPagine", listaPagine);
		return m;
	}
	
	public CybionAction getAction() {
		return action;
	}


	public void setAction(CybionAction action) {
		this.action = action;
	}


	

}
