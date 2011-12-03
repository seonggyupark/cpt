package com.cybion.cpt.web.core.controller.action;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.cybion.cpt.web.core.model.CrawledPage;
import com.cybion.cpt.web.core.model.Source;
import com.cybion.cpt.web.core.persistence.PersistenceBroker;


public class ViewPagesAction implements CybionAction {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	private PersistenceBroker broker;

	public boolean doWork(HttpServletRequest request) {
		boolean result = false;
		List<CrawledPage> listaPagine = new LinkedList<CrawledPage>();
		Source f = null;
		try {
			int idFonte = Integer.parseInt(request.getParameter("idFonte"));
			listaPagine = broker.getPages(idFonte);
			f = broker.getFonte(idFonte);
			request.setAttribute("listaPagine", listaPagine);
			result = true;
		}catch(Exception e){logger.error("ERRORE"+this.getClass().toString(),e);}
		return result;
	}
	
	public PersistenceBroker getBroker() {
		return broker;
	}

	public void setBroker(PersistenceBroker broker) {
		this.broker = broker;
	}

}
