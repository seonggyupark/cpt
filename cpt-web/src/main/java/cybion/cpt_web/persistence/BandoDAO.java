package cybion.cpt_web.persistence;

import cybion.cpt_web.model.Bando;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class BandoDAO extends HibernateDaoSupport {

    private Logger logger = Logger.getLogger(BandoDAO.class);


    protected void insertBando(Bando b) {
        try {
            getHibernateTemplate().save(b);
            this.getSession().close();
            logger.info("SESSIONE CHIUSA");

        } catch (Exception e) {
            logger.error("PERSISTENCE EXCEPTION", e);
        }
    }


}
