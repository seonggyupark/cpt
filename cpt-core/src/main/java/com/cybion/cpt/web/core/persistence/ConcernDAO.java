package com.cybion.cpt.web.core.persistence;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cybion.cpt.web.core.model.Concern;


public class ConcernDAO extends HibernateDaoSupport{
	
	private Logger logger = Logger.getLogger(this.getClass());

	
	protected void insertInteresse(Concern i) {
		try {
			this.getHibernateTemplate().save(i);
			this.getSession().close();
			logger.info("SESSIONE CHIUSA");
		}catch(Exception e) {logger.error("PERSISTENCE EXCEPTION", e);}
	}
	
	protected List<Concern> retrieveAllInteressi(){
		List<Concern> resultList = null;
		try {
			resultList = (List<Concern>)this.getHibernateTemplate().loadAll(Concern.class);
			this.getSession().close();
			logger.info("SESSIONE CHIUSA");
		}catch(Exception e){logger.error("PERSISTENCE EXCEPTION", e);}
		return resultList;
	}

	protected Concern getInteresse(int idInteresse) {
		Concern i = null;
		try {
			i = (Concern) this.getSession().get(Concern.class, idInteresse);
		  	this.getSession().close();
			logger.info("SESSIONE CHIUSA");
		}
		catch(Exception e){logger.error("PERSISTENCE EXCEPTION", e);}
		return i;
	}

}
