package cybion.cpt_web.controller.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import cybion.cpt_web.model.NavXML;
import cybion.cpt_web.persistence.PersistenceBroker;

public class PrelevaXMLAction implements CybionAction {
	
	
	private PersistenceBroker broker;
	private Logger logger = Logger.getLogger(this.getClass());


	public boolean doWork(HttpServletRequest request) {
		boolean result = false;
		try{
			Integer idFonte = new Integer(request.getParameter("idFonte"));
			NavXML navXML = broker.getXMLByFonte(idFonte);
			request.setAttribute("xml", navXML);
			result = true;
		}
		catch(Exception e){logger.error("ERRORE"+this.getClass().toString(),e);}
		return result;
		
	}

	public  PersistenceBroker getBroker() {
		return broker;
	}

	public void setBroker(PersistenceBroker broker) {
		this.broker = broker;
	}

}
