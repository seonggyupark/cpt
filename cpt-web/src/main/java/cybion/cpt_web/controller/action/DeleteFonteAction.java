package cybion.cpt_web.controller.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import cybion.cpt_web.business.utility.DocumentUtils;
import cybion.cpt_web.model.Fonte;
import cybion.cpt_web.persistence.PersistenceBroker;

public class DeleteFonteAction implements CybionAction {

	private Logger logger = Logger.getLogger(this.getClass());
	private PersistenceBroker broker;
	private DocumentUtils docUtils;

	public boolean doWork(HttpServletRequest request) {
		boolean result = false;
		try {
			int idFonte = Integer.parseInt(request.getParameter("idFonte"));
			Fonte f = broker.getFonte(idFonte);
			docUtils.deleteDirectories(f.getNome());
			broker.deleteFonte(idFonte);
			request.setAttribute("message", "fonte "+f.getNome()+" eliminata");
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

	public DocumentUtils getDocUtils() {
		return docUtils;
	}

	public void setDocUtils(DocumentUtils docUtils) {
		this.docUtils = docUtils;
	}

}
