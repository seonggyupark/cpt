package com.cybion.cpt.web.core.persistence;



import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cybion.cpt.web.core.model.User;


public class UserDAO extends HibernateDaoSupport{
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	protected User retrieveOperatore(String username, String password) {
		User operatore = null;
		final String SQL_SELECT = "from operatori op " +
		"where op.username='"+username+"' and op.password='"+password+"'";
		try{
			operatore = (User) this.getHibernateTemplate().find(SQL_SELECT).get(0);
			this.getSession().close();
			logger.info("HIBERNATE - SESSIONE CHIUSA");
		}
		
		catch(Exception e){logger.error("PERSISTENCE EXCEPTION", e);}
		return operatore;
		
	}
	

}
