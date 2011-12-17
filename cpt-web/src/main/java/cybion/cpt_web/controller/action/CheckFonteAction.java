package cybion.cpt_web.controller.action;

import cybion.cpt_web.business.*;
import cybion.cpt_web.model.Pagina;
import cybion.cpt_web.persistence.PersistenceBroker;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class CheckFonteAction implements CybionAction {

  private Logger logger = Logger.getLogger(this.getClass());

  private PersistenceBroker broker;

  private final UIMAExecutor uimaExecutor = new UIMAExecutor();

  public PersistenceBroker getBroker() {
    return broker;
  }

  public void setBroker(PersistenceBroker broker) {
    this.broker = broker;
  }

  public boolean doWork(HttpServletRequest request) {
    boolean callResult = false;
    try {

      PageCrawler pageCrawler = new PageCrawler(broker); // create the page crawler

      // take source id from request
      int idFonte = getIdFonte(request);

      // download pages from the identified source
      List<Pagina> pagineScaricate = pageCrawler.crawlPages(idFonte);

      List<UIMAResult> results = new ArrayList<UIMAResult>();
      for (Pagina pagina : pagineScaricate) {
        // for each page apply UIMA annotators and build a Bando from the extracted info
        UIMAResult uimaResult = uimaExecutor.analyzeDocument(pagina.getContent());
        broker.saveBando(uimaResult.getBando()); // save bando inside the db
        results.add(uimaResult);
      }

      // compare latest results with the previous one (if exists) to filter only the differences
      ResultComparator resultsComparator = new DefaultResultComparator(broker);
      resultsComparator.filter(results, idFonte);

      request.setAttribute("results", results);
      callResult = true;
    } catch (Exception e) {
      logger.error(new StringBuilder("ERRORE : ").append(e.getLocalizedMessage()).toString(), e);
    }
    return callResult;
  }

  private int getIdFonte(HttpServletRequest request) {
    int idFonte = Integer.parseInt(request.getParameter("idFonte"));
    return idFonte;
  }

}
