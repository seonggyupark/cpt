package com.cybion.cpt.web.core.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.cybion.cpt.web.core.model.Concern;
import com.cybion.cpt.web.core.persistence.PersistenceBroker;


public class LoadConcernsAction implements CybionAction{
	
	private PersistenceBroker broker;
	private Logger logger = Logger.getLogger(this.getClass());


	public boolean doWork(HttpServletRequest request) {
		boolean result = false;
		List<Concern> interessiList = null;
		try {
			interessiList = broker.getAllInteressi();
			request.setAttribute("listaInteressi", interessiList);
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
