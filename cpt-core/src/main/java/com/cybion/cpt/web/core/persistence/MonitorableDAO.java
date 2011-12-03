package com.cybion.cpt.web.core.persistence;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cybion.cpt.web.core.model.Monitorable;



public class MonitorableDAO extends HibernateDaoSupport {
	
	private Logger logger = Logger.getLogger(this.getClass());

	
	protected void insertMonitorable(Monitorable monitorable) {
		try {
			getHibernateTemplate().save(monitorable);
			this.getSession().close();
		  	logger.info("session closed");

		} catch(Exception e){logger.error("PERSISTENCE EXCEPTION", e);}
	}


}
