package cybion.cpt_web.persistence;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cybion.cpt_web.model.Fonte;

public class FonteDAO extends HibernateDaoSupport {

  private Logger logger = Logger.getLogger(this.getClass());

  protected Fonte retrieveFonte(int idFonte) {
    Fonte f = null;
    try {
      f = (Fonte) this.getSession().get(Fonte.class, idFonte);
      this.getSession().close();
      logger.info("HIBERNATE - SESSIONE CHIUSA");
    } catch (Exception e) {
      logger.error("PERSISTENCE EXCEPTION", e);
    }
    return f;
  }

  protected void insertFonte(Fonte f) {
    try {
      this.getHibernateTemplate().save(f);
      logger.info("FONTE INSERITA");
      this.getSession().close();
      logger.info("HIBERNATE - SESSIONE CHIUSA");

    } catch (Exception e) {
      logger.error("PERSISTENCE EXCEPTION", e);
    }
  }

  @SuppressWarnings("unchecked")
  protected List<Fonte> retrieveFonti() {
    List<Fonte> listaFonti = new LinkedList<Fonte>();
    try {
      listaFonti = this.getHibernateTemplate().loadAll(Fonte.class);
      this.getSession().close();
      logger.info("HIBERNATE - SESSIONE CHIUSA");
    } catch (Exception e) {
      logger.error("PERSISTENCE EXCEPTION", e);
    }
    return listaFonti;
  }

  protected void deleteFonte(Fonte f) {
    try {
      this.getHibernateTemplate().delete(f);
      this.getSession().delete(f);
      this.getSession().close();
      logger.info("HIBERNATE - SESSIONE CHIUSA");
    } catch (Exception e) {
      logger.error("PERSISTENCE EXCEPTION", e);
    }
  }

  protected void updateFonte(Fonte f) {
    try {
      Fonte fonte = retrieveFonte(f.getIdFonte());
      fonte = f;
      this.getSession().update(fonte);
      this.getSession().close();
      logger.info("HIBERNATE - SESSIONE CHIUSA");
    } catch (Exception e) {
      logger.error("PERSISTENCE EXCEPTION", e);
    }
  }
}
