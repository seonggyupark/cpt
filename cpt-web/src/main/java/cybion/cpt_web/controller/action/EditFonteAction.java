package cybion.cpt_web.controller.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import cybion.cpt_web.model.Fonte;
import cybion.cpt_web.persistence.PersistenceBroker;

public class EditFonteAction implements CybionAction {
	
	private Logger logger = Logger.getLogger(this.getClass());
	private PersistenceBroker broker;

	public boolean doWork(HttpServletRequest request) {
		boolean result = false;
		Fonte f = null;
		try {
			f = broker.getFonte((Integer.parseInt(request.getParameter("idFonte"))));
			request.setAttribute("fonte", f);
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
