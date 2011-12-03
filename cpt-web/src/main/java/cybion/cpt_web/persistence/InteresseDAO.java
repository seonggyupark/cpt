package cybion.cpt_web.persistence;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cybion.cpt_web.model.Interesse;

public class InteresseDAO extends HibernateDaoSupport{
	
	private Logger logger = Logger.getLogger(this.getClass());

	
	protected void insertInteresse(Interesse i) {
		try {
			this.getHibernateTemplate().save(i);
			this.getSession().close();
			logger.info("SESSIONE CHIUSA");
		}catch(Exception e) {logger.error("PERSISTENCE EXCEPTION", e);}
	}
	
	protected List<Interesse> retrieveAllInteressi(){
		List<Interesse> resultList = null;
		try {
			resultList = this.getHibernateTemplate().loadAll(Interesse.class);
			this.getSession().close();
			logger.info("SESSIONE CHIUSA");
		}catch(Exception e){logger.error("PERSISTENCE EXCEPTION", e);}
		return resultList;
	}

	protected Interesse getInteresse(int idInteresse) {
		Interesse i = null;
		try {
			i = (Interesse) this.getSession().get(Interesse.class, idInteresse);
		  	this.getSession().close();
			logger.info("SESSIONE CHIUSA");
		}
		catch(Exception e){logger.error("PERSISTENCE EXCEPTION", e);}
		return i;
	}

}
