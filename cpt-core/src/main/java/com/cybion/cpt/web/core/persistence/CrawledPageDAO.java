package com.cybion.cpt.web.core.persistence;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cybion.cpt.web.core.model.CrawledPage;


public class CrawledPageDAO extends HibernateDaoSupport{
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	/* Salva una pagina su DB */
	protected void savePagina(CrawledPage p){
		try {
			getHibernateTemplate().save(p);
			this.getSession().close();
			logger.info("HIBERNATE - SESSIONE CHIUSA");

		}catch(Exception e) {logger.error("PERSISTENCE EXCEPTION", e);}
	}
	
	protected List<CrawledPage> retrievePages(int idFonte){
		List<CrawledPage> result = null;
		try {
			String queryString = "from Pagina where idFonte = :idFonte order by :data DESC";
			Query query = this.getSession().createQuery(queryString);  
			query.setInteger("idFonte", idFonte);
			query.setString("data", "data");
			result = query.list();
			this.getSession().close();
			logger.info("HIBERNATE - SESSIONE CHIUSA");
		}catch(Exception e){logger.error("PERSISTENCE EXCEPTION", e);}
		return result;
	}

}
