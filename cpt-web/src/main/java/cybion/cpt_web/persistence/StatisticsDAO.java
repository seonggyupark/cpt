package cybion.cpt_web.persistence;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cybion.cpt_web.model.Statistics;

public class StatisticsDAO extends HibernateDaoSupport{
	
	private Logger logger = Logger.getLogger(this.getClass());

	protected void updateStatistics(int idFonte, int pagineScaricate) {
		String queryString = 
			"update Statistics " +
			"set media= ((media + :pagineScaricate )/contatore), contatore=contatore+1" +
			"where id_fonte = :idFonte";
		try {
			logger.info("CARICO LA STATISTICA");
			Statistics st = getStatistica(idFonte);
			//se l'oggetto è già presente lo aggiorno
			if (st!=null){
				logger.info("INIZIO AGGIORNAMENTO STATISTICA");
				double media = st.getMedia();
				int contatore = st.getContatore();
				int newContatore = contatore+1;
				double newMedia = ((media*contatore)+pagineScaricate)/newContatore;
				/*Aggiorno i campi dell'oggetto e lo re-inserisco*/
				st.setContatore(newContatore);
				st.setIdFonte(idFonte);
				st.setLast(pagineScaricate);
				st.setMedia(newMedia);
				logger.info("FINE AGGIORNAMENTO STATISTICA");
				this.getHibernateTemplate().update(st);
				logger.info("STATISTICA SALVATA");
				this.getSession().close();
				logger.info("HIBERNATE - SESSIONE CHIUSA");
			}
			//se l'oggetto non è presente lo inserisco
			else {
				logger.info("INIZIALIZZAZIONE STATISTICA");
				st = new Statistics();
				st.setIdFonte(idFonte);
				st.setContatore(1);
				st.setMedia(pagineScaricate);
				st.setLast(pagineScaricate);
				this.getHibernateTemplate().save(st);
				logger.info("STATISTICA SALVATA");
				this.getSession().close();
				logger.info("HIBERNATE - SESSIONE CHIUSA");

			}
		}catch(Exception e){logger.error("PERSISTENCE EXCEPTION", e);}
	}
	
	private Statistics getStatistica(int idFonte){
		Statistics st = null;
		try {
			st = (Statistics) this.getSession().get(Statistics.class, idFonte);
			this.getSession().close();
			logger.info("HIBERNATE - SESSIONE CHIUSA");

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
