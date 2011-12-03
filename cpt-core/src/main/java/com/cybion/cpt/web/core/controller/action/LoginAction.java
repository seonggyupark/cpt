package com.cybion.cpt.web.core.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cybion.cpt.web.core.model.User;
import com.cybion.cpt.web.core.persistence.PersistenceBroker;



/* Classe che si occupa di controllare il login dell'utente
 * Fa uso di un oggetto helper che tramite dei validatori
 * si occupa di controllare i valori inseriti dall'utente
 */

public class LoginAction implements CybionAction {
	
	private static PersistenceBroker broker;
	private Logger logger = Logger.getLogger(this.getClass());


	public boolean doWork(HttpServletRequest request) {
		boolean result = false;
		User op = null;
		String username, password;
		try {
			username = request.getParameter("username");
			password = request.getParameter("password");
			
			/*controllo tramite lo strato di persistenza*/
			op = broker.checkOperatore(username, password);
			}
		catch(Exception e){logger.error("ERRORE"+this.getClass().toString(),e);}
		
		/* Inserisco l'oggetto operatore nella sessione */
		HttpSession session = request.getSession(false);
		if(session != null)
			session.invalidate();
		if(op!=null)
		{
			session.setAttribute("operatore", op);
			result = true;
		}
		return result;
	}

	public PersistenceBroker getBroker() {
		return broker;
	}

	public void setBroker(PersistenceBroker broker) {
		this.broker = broker;
	}
	
	
}