package com.cybion.cpt.web.core.persistence;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cybion.cpt.web.core.model.Client;
import com.cybion.cpt.web.core.model.Source;


public class ClientDAO extends HibernateDaoSupport {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	
	protected void insertCliente(Client c){
		try{
			this.getHibernateTemplate().save(c);
			this.getSession().close();
			logger.info("HIBERNATE - SESSIONE CHIUSA");
		}catch(Exception e){logger.error("PERSISTENCE EXCEPTION", e);}
	}
	
	protected List<Client> retrieveAllClienti(){
		List<Client> returnList = null;
		try {
			returnList = this.getHibernateTemplate().loadAll(Client.class);
			this.getSession().close();
			logger.info("HIBERNATE - SESSIONE CHIUSA");
		}
		catch(Exception e){logger.error("PERSISTENCE EXCEPTION", e);}
		return returnList;
	}
	
	protected Client getCliente(int idCliente){
		Client c = null;
		try {
			c = (Client) this.getSession().get(Client.class, idCliente);
		  	this.getSession().close();
		  	logger.info("HIBERNATE - SESSIONE CHIUSA");
		}
		catch(Exception e){logger.error("PERSISTENCE EXCEPTION", e);}
		return c;
	}
	
	protected void deleteCliente(Client c){
		try {
			this.getSession().delete(c);
			this.getSession().close();
		  	logger.info("HIBERNATE - SESSIONE CHIUSA");
		}catch(Exception e){logger.error("PERSISTENCE EXCEPTION", e);}
	}

}
