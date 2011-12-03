package com.cybion.cpt.web.core.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.cybion.cpt.web.core.model.Source;
import com.cybion.cpt.web.core.model.Statistics;
import com.cybion.cpt.web.core.persistence.PersistenceBroker;


public class ViewSourcesAction implements CybionAction{
	
	
	private PersistenceBroker broker;
	
	private Logger logger = Logger.getLogger(this.getClass());


	/**
	 * Prende la lista delle fonti dal DB e la passa al controller
	 */
	public boolean doWork(HttpServletRequest request) {
		boolean result = false;
		try {
			List<Source> listaFonti = broker.getAllFonti();
			List<Statistics> listaStatistiche = broker.getAllStatistics();
			request.setAttribute("listaFonti", listaFonti);
			request.setAttribute("listaStatistiche", listaStatistiche);
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
