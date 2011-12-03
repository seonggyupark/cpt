package cybion.cpt_web.persistence;



import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cybion.cpt_web.model.Operatore;

public class OperatoreDAO extends HibernateDaoSupport{
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	protected Operatore retrieveOperatore(String username, String password) {
		Operatore operatore = null;
		final String SQL_SELECT = "from operatori op " +
		"where op.username='"+username+"' and op.password='"+password+"'";
		try{
			operatore = (Operatore) this.getHibernateTemplate().find(SQL_SELECT).get(0);
			this.getSession().close();
			logger.info("HIBERNATE - SESSIONE CHIUSA");
		}
		
		catch(Exception e){logger.error("PERSISTENCE EXCEPTION", e);}
		return operatore;
		
	}
	

}
