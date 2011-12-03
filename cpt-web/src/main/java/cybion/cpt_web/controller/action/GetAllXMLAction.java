package cybion.cpt_web.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import cybion.cpt_web.model.NavXML;
import cybion.cpt_web.persistence.PersistenceBroker;

public class GetAllXMLAction implements CybionAction{
	
	private static PersistenceBroker broker;
	private Logger logger = Logger.getLogger(this.getClass());


	public boolean doWork(HttpServletRequest request) {
		boolean result = false;
		try {
			List <NavXML> listaXML = broker.getAllXML();
			request.setAttribute("listaXML", listaXML);
			result = true;
		}catch(Exception e){logger.error("ERRORE"+this.getClass().toString(),e);}
		return result;
	}

	
	public PersistenceBroker getBroker() {
		return broker;
	}

	public void setBroker(PersistenceBroker broker) {
		GetAllXMLAction.broker = broker;
	}
}
;