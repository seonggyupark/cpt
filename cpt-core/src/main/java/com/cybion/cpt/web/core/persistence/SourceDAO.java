package com.cybion.cpt.web.core.persistence;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cybion.cpt.web.core.model.Source;


public class SourceDAO extends HibernateDaoSupport{
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	protected Source retrieveFonte(int idFonte){
		Source f = null;
		try {
			f = (Source) this.getSession().get(Source.class, idFonte);
		  	this.getSession().close();
		  	logger.info("HIBERNATE - SESSIONE CHIUSA");
		}
		catch(Exception e){logger.error("PERSISTENCE EXCEPTION", e);}
		return f;
	}
	
	protected void insertFonte(Source f) {
		try {
			this.getHibernateTemplate().save(f);
			logger.info("FONTE INSERITA");
		  	this.getSession().close();
		  	logger.info("HIBERNATE - SESSIONE CHIUSA");

		}
		catch(Exception e){logger.error("PERSISTENCE EXCEPTION", e);}
	}
	
	protected List<Source> retrieveFonti() {
		List<Source> listaFonti = new LinkedList<Source>();
		try {
			listaFonti = (List<Source>)this.getHibernateTemplate().loadAll(Source.class);
		  	this.getSession().close();
		  	logger.info("HIBERNATE - SESSIONE CHIUSA");
		}catch(Exception e) {logger.error("PERSISTENCE EXCEPTION", e);}
		return listaFonti;
	}
	
	protected void deleteFonte(Source f){
		try {
			this.getSession().delete(f);
			this.getSession().close();
			logger.info("HIBERNATE - SESSIONE CHIUSA");
		}catch(Exception e) {logger.error("PERSISTENCE EXCEPTION", e);}
	}
	
	protected void updateFonte(Source f){
		try {
			Source fonte = retrieveFonte(f.getIdFonte());
			fonte = f;
			this.getSession().update(fonte);
			this.getSession().close();
			logger.info("HIBERNATE - SESSIONE CHIUSA");
		}catch(Exception e) {logger.error("PERSISTENCE EXCEPTION", e);}
	}
}
