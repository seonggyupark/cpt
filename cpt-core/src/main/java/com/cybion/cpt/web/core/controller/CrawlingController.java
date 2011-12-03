package com.cybion.cpt.web.core.controller;

import it.chi.webpipe.crawler.executor.CrawlingException;
import it.uniroma3.website.model.extensional.Page;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;

import com.cybion.cpt.web.core.controller.action.CybionAction;


public class CrawlingController extends AbstractController implements Controller{
	
	
	private CybionAction action;
	
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		String result = "viewNavXML";
		String message = null;
		try {
			if(action.doWork(request))	{
				message = getMessage((List<Page>) request.getAttribute("pageList"));
				result = "success";
			}
		}
			catch(CrawlingException ce){
				message = ce.toString();
				result ="error";
			}
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
	
	private String getMessage(List<Page> pageList){
		int pageCount;
		if (pageList == null)
			pageCount = 0;
		else 
			pageCount = pageList.size();
		
		return "Sono state scaricate "+pageCount+" pagine: <br/>";
	}
}