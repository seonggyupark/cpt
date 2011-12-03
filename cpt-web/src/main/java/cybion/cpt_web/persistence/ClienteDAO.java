package cybion.cpt_web.persistence;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cybion.cpt_web.model.Cliente;

public class ClienteDAO extends HibernateDaoSupport {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	
	protected void insertCliente(Cliente c){
		try{
			this.getHibernateTemplate().save(c);
			this.getSession().close();
			logger.info("HIBERNATE - SESSIONE CHIUSA");
		}catch(Exception e){logger.error("PERSISTENCE EXCEPTION", e);}
	}
	
	protected List<Cliente> retrieveAllClienti(){
		List<Cliente> returnList = null;
		try {
			returnList = this.getHibernateTemplate().loadAll(Cliente.class);
			this.getSession().close();
			logger.info("HIBERNATE - SESSIONE CHIUSA");
		}
		catch(Exception e){logger.error("PERSISTENCE EXCEPTION", e);}
		return returnList;
	}
	
	protected Cliente getCliente(int idCliente){
		Cliente c = null;
		try {
			c = (Cliente) this.getSession().get(Cliente.class, idCliente);
		  	this.getSession().close();
		  	logger.info("HIBERNATE - SESSIONE CHIUSA");
		}
		catch(Exception e){logger.error("PERSISTENCE EXCEPTION", e);}
		return c;
	}
	
	protected void deleteCliente(Cliente c){
		try {
			this.getSession().delete(c);
			this.getSession().close();
		  	logger.info("HIBERNATE - SESSIONE CHIUSA");
		}catch(Exception e){logger.error("PERSISTENCE EXCEPTION", e);}
	}

}
