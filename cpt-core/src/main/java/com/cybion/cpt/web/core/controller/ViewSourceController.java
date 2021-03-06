package com.cybion.cpt.web.core.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;

import com.cybion.cpt.web.core.controller.action.CybionAction;
import com.cybion.cpt.web.core.model.Source;
import com.cybion.cpt.web.core.model.Statistics;


public class ViewSourceController extends AbstractController implements Controller{
	
	private CybionAction action;

	/**
	 * Prende la lista delle fonti dalla persistenza e ritorna la vista
	 */
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			
		String result = "indexAdmin";
		try {
			if(action.doWork(request))
				result = "viewFonti";
		}catch(Exception e){e.printStackTrace();}
		
		/*Aggiungo la lista delle fonti alla pagina*/
		List<Source> listaFonti = (List<Source>)request.getAttribute("listaFonti");
		List<Statistics> listaStatistiche = (List<Statistics>) request.getAttribute("listaStatistiche");
		ModelAndView m = new ModelAndView(result);
		m.addObject("listaFonti", listaFonti);
		m.addObject("listaStatistiche", listaStatistiche);
		return m;
	}

	public CybionAction getAction() {
		return action;
	}

	public void setAction(CybionAction action) {
		this.action = action;
	}
	
	

}
