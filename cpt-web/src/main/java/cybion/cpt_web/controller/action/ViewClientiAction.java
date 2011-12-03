package cybion.cpt_web.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import cybion.cpt_web.model.Cliente;
import cybion.cpt_web.persistence.PersistenceBroker;

public class ViewClientiAction implements CybionAction{
	
	private PersistenceBroker broker;
	
	private Logger logger = Logger.getLogger(this.getClass());


	public boolean doWork(HttpServletRequest request) {
		boolean result = false;
		try {
			List<Cliente> listaClienti = broker.getAllClienti();
			request.setAttribute("listaClienti", listaClienti);
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
