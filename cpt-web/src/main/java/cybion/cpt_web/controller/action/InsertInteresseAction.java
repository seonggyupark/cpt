package cybion.cpt_web.controller.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import cybion.cpt_web.model.Interesse;
import cybion.cpt_web.persistence.PersistenceBroker;

public class InsertInteresseAction implements CybionAction {
	
	private PersistenceBroker broker;
	private Logger logger = Logger.getLogger(this.getClass());


	public boolean doWork(HttpServletRequest request) {
		boolean result = false;
		
		try {
			String nome = request.getParameter("interesse");
			Interesse i = new Interesse();
			i.setNome(nome);
			broker.saveInteresse(i);
			request.setAttribute("nomeInteresse", nome);
			result = true;
		}
		catch(Exception e){logger.error("ERRORE"+this.getClass().toString(),e);}
		return result;
	}

	public PersistenceBroker getBroker() {
		return broker;
	}

	public void setBroker(PersistenceBroker broker) {
		this.broker = broker;
	}
	
	

}
