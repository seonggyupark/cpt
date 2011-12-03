package cybion.cpt_web.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import cybion.cpt_web.model.Fonte;
import cybion.cpt_web.model.Statistics;
import cybion.cpt_web.persistence.PersistenceBroker;

public class ViewFontiAction implements CybionAction{
	
	
	private PersistenceBroker broker;
	
	private Logger logger = Logger.getLogger(this.getClass());


	/**
	 * Prende la lista delle fonti dal DB e la passa al controller
	 */
	public boolean doWork(HttpServletRequest request) {
		boolean result = false;
		try {
			List<Fonte> listaFonti = broker.getAllFonti();
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
