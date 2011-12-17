package cybion.cpt_web.business;

import it.chi.webpipe.crawler.executor.CrawlerExecutor;
import it.chi.webpipe.crawler.executor.CrawlingException;
import it.chi.webpipe.crawler.executor.CrawlingSpecification;
import it.chi.webpipe.nr.model.Relation;
import it.chi.webpipe.nr.model.impl.Serializer;
import it.chi.webpipe.pilot.repository.crawler.CrawlingSpecificationReader;
import it.chi.webpipe.pilot.repository.wrapper.WrappingSpecificationReader;
import it.chi.webpipe.wrapper.executor.WebsiteWrapperExecutor;
import it.chi.webpipe.wrapper.executor.WrappingSpecification;
import it.uniroma3.website.html.extensional.HTMLPage;
import it.uniroma3.website.model.Model;
import it.uniroma3.website.model.extensional.Page;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.*;

public class WebpipeExecutor {

//	private static final String prePath = "/tmp/Jetty_0_0_0_0_8080_cpt.web.war__cpt.web__qug9jb/webapp/WEB-INF/classes/WEB-INF";
//	private static final String prePath = "/webpipes/";

  ResourceBundle bundle = ResourceBundle.getBundle("config");
  String prePath = bundle.getString("prePath");


  private Logger logger = Logger.getLogger(this.getClass());


  private String crawlingSpec;
  private String wrappingSpec;
  private String webpipeName;

  public WebpipeExecutor() {
  }

  public WebpipeExecutor(String crawlingSpec, String wrappingSpec, String webpipeName) {
    this.crawlingSpec = crawlingSpec;
    this.wrappingSpec = wrappingSpec;
    this.webpipeName = webpipeName;
  }

  public WebpipeExecutor(String crawlingSpec, String webpipeName) {
    this.crawlingSpec = crawlingSpec;
    this.wrappingSpec = null;
    this.webpipeName = webpipeName;
  }

  public List<Page> fireCrawling() {
    // CHIAMA LA WEBPIPE CHE SCATENA IL CRAWLER
    CrawlingSpecificationReader csr = new CrawlingSpecificationReader();
    WrappingSpecificationReader wsr = new WrappingSpecificationReader();

    String crawlPath = prePath + this.webpipeName
            + "/webpipe/crawling.xml";
    String wrapPath = prePath + this.webpipeName
            + "/webpipe/wrapping.xml";

    BufferedWriter out1, out2 = null;
    try {
      out1 = new BufferedWriter(new FileWriter(crawlPath));
      out1.write(crawlingSpec);
      out1.flush();
      out1.close();
      logger.info("SCRITTURA COMPLETATA FILE CRAWLING");
      if (wrappingSpec != null) {
        out2 = new BufferedWriter(new FileWriter(wrapPath));
        out2.write(wrappingSpec);
        out2.flush();
        out2.close();
        logger.info("SCRITTURA COMPLETATA FILE WRAPPING");
        Thread.currentThread();
        Thread.sleep(2000);
      }

    } catch (Exception e1) {
      logger.error("ERRORE SCRITTURA FILES", e1);
    }


    Set<Page> pages = new HashSet<Page>();
    try {
      File crawlingFile = new File(crawlPath);
      Reader reader = new FileReader(crawlingFile);
      CrawlingSpecification cs = csr.read(reader);

      CrawlerExecutor executor = new CrawlerExecutor(cs);
      logger.info("CREAZIONE CRAWLER EXECUTOR");
      Thread.currentThread();
      Thread.sleep(2000);
      logger.info("ESECUZIONE CRAWLER IN CORSO");
      Model model = executor.execute();
      logger.info("ESECUZIONE COMPLETATA");

      if (wrappingSpec != null) {
        System.out.println("#INIZIO A LEGGERE IL WRAPPER#");
        File wrappingFile = new File(wrapPath);
        List<Relation> relations = null;
//				Reader reader2 = ResourceUtils.getResourceAsReader(wrapPath);
        Reader reader2 = new FileReader(wrappingFile.getAbsolutePath());
        WrappingSpecification ws = wsr.read(new Reader[]{reader2});
        ws.setModel(model);
        relations = new WebsiteWrapperExecutor(ws).execute();
        for (Relation r : relations) {
          Serializer serializer = new Serializer();
          String xml = serializer.toXML(r);
        }
      }
      pages = model.getSupport().getPages();
      for (Page p : pages) {
        HTMLPage page = (HTMLPage) p;
        String text = page.getStringByXPath("/html");
        logger.info("PAGINA ID: " + page.getId());
        logger.info("PAGINA URL: " + page.getURI().toString());
      }
    } catch (CrawlingException ce) {
      logger.error("ERRORE CRAWLING", ce);
      throw new CrawlingException(ce);
    } catch (Exception e) {
      logger.error("ERRORE GENERICO", e);
    }

    List<Page> pageList = new ArrayList<Page>(pages);

    return pageList;

  }

  public String getWrappingSpec() {
    return wrappingSpec;
  }

  public void setWrappingSpec(String wrappingSpec) {
    this.wrappingSpec = wrappingSpec;
  }

  public String getCrawlingSpec() {
    return crawlingSpec;
  }

  public void setCrawlingSpec(String crawlingSpec) {
    this.crawlingSpec = crawlingSpec;
  }

  public String getWebpipeName() {
    return webpipeName;
  }

  public void setWebpipeName(String webpipeName) {
    this.webpipeName = webpipeName;
  }

}