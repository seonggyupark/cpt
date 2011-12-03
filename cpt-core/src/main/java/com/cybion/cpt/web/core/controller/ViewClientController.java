package com.cybion.cpt.web.core.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;

import com.cybion.cpt.web.core.controller.action.CybionAction;
import com.cybion.cpt.web.core.model.Client;
import com.cybion.cpt.web.core.model.Source;


public class ViewClientController extends AbstractController implements
		Controller {
	
	private CybionAction action;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		String result = "indexAdmin";
		try {
			if(action.doWork(arg0))
				result = "viewClienti";
		}catch(Exception e){e.printStackTrace();}
		
		/*Aggiungo la lista di clienti alla pagina*/
		List<Client> listaClienti = (List<Client>)arg0.getAttribute("listaClienti");
		ModelAndView m = new ModelAndView(result);
		m.addObject("listaClienti", listaClienti);
		return m;
	}

	public CybionAction getAction() {
		return action;
	}

	public void setAction(CybionAction action) {
		this.action = action;
	}
	
	
	

}
