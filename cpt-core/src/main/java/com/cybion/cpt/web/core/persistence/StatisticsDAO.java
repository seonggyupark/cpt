package com.cybion.cpt.web.core.persistence;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cybion.cpt.web.core.model.Statistics;


public class StatisticsDAO extends HibernateDaoSupport{
	
	private Logger logger = Logger.getLogger(this.getClass());

	protected void updateStatistics(int idFonte, int pagineScaricate) {
		String queryString = 
			"update Statistics " +
			"set media= ((media + :pagineScaricate )/contatore), contatore=contatore+1" +
			"where id_fonte = :idFonte";
		try {
			logger.info("load statistic");
			Statistics st = getStatistica(idFonte);
			//if already there then update it
			if (st!=null){
				logger.info("start updating statistics");
				double media = st.getMedia();
				int contatore = st.getContatore();
				int newContatore = contatore+1;
				double newMedia = ((media*contatore)+pagineScaricate)/newContatore;
				/*Aggiorno i campi dell'oggetto e lo re-inserisco*/
				st.setContatore(newContatore);
				st.setIdFonte(idFonte);
				st.setLast(pagineScaricate);
				st.setMedia(newMedia);
				logger.info("update ended");
				this.getHibernateTemplate().update(st);
				logger.info("statistic saved");
				this.getSession().close();
				logger.info("HIBERNATE - session closed");
			}
			//se l'oggetto non è presente lo inserisco
			else {
				logger.info("intializing statistic");
				st = new Statistics();
				st.setIdFonte(idFonte);
				st.setContatore(1);
				st.setMedia(pagineScaricate);
				st.setLast(pagineScaricate);
				this.getHibernateTemplate().save(st);
				logger.info("statistic saved");
				this.getSession().close();
				logger.info("HIBERNATE - session closed");

			}
		}catch(Exception e){logger.error("PERSISTENCE EXCEPTION", e);}
	}
	
	private Statistics getStatistica(int idFonte){
		Statistics st = null;
		try {
			st = (Statistics) this.getSession().get(Statistics.class, idFonte);
			this.getSession().close();
			logger.info("HIBERNATE - session closed");

		}catch(Exception e){e.printStackTrace();}
		return st;
	}
	
	protected List<Statistics> getAllStatistics() {
		List<Statistics> result = null;
		try {
			result = this.getHibernateTemplate().loadAll(Statistics.class);
			this.getSession().close();
			logger.info("HIBERNATE - SESSIONE CHIUSA");
		}catch(Exception e){logger.error("PERSISTENCE EXCEPTION", e);}
		return result;
	}
}
