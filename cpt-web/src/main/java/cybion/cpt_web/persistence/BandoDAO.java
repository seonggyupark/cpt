package cybion.cpt_web.persistence;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cybion.cpt_web.model.Bando;


public class BandoDAO extends HibernateDaoSupport {
	
	private Logger logger = Logger.getLogger(this.getClass());

	
	protected void insertBando(Bando b) {
		try {
			getHibernateTemplate().save(b);
			this.getSession().close();
		  	logger.info("SESSIONE CHIUSA");

		} catch(Exception e){logger.error("PERSISTENCE EXCEPTION", e);}
	}
	

}
