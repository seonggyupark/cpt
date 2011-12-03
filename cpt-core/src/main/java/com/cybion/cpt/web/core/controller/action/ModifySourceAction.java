package com.cybion.cpt.web.core.controller.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.cybion.cpt.web.core.business.utility.DocumentUtils;
import com.cybion.cpt.web.core.model.Source;
import com.cybion.cpt.web.core.persistence.PersistenceBroker;


public class ModifySourceAction implements CybionAction {

	private Logger logger = Logger.getLogger(this.getClass());
	private PersistenceBroker broker;
	private DocumentUtils docUtils;

	public boolean doWork(HttpServletRequest request) {
		boolean result = false;
		Source f = null;
		try {
			f = broker.getFonte((Integer.parseInt(request.getParameter("idFonte"))));
			String oldName = f.getNome();
			String newName = request.getParameter("nome");
			f.setNome(newName); f.setLink(request.getParameter("link"));
			docUtils.createDirectories(newName);
			docUtils.copyFiles(oldName, newName);
			docUtils.deleteDirectories(oldName);
			broker.updateFonte(f);
			request.setAttribute("fonte", f);
			result = true;
		}catch(Exception e){logger.error("ERRORE "+this.getClass().toString(),e);}
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
