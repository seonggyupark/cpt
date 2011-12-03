package cybion.cpt_web.controller.action;

import it.chi.webpipe.crawler.executor.CrawlingException;
import it.uniroma3.website.html.extensional.HTMLPage;
import it.uniroma3.website.model.extensional.Page;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import cybion.cpt_web.business.WebpipeExecutor;
import cybion.cpt_web.model.NavXML;
import cybion.cpt_web.model.Pagina;
import cybion.cpt_web.persistence.PersistenceBroker;

public class CrawlingAction implements CybionAction {
	
	private PersistenceBroker broker;
	private Logger logger = Logger.getLogger(this.getClass());

	/**
	 * Action che richiama il crawler
	 */
	public boolean doWork(HttpServletRequest request) {
		boolean result = false;
		try {
			int idFonte = Integer.parseInt(request.getParameter("idFonte"));
			NavXML xml = broker.getNavXML(idFonte);
			String crawlingXML, wrappingXML, descXML;
			crawlingXML = xml.getContentCrawling();
			wrappingXML = xml.getContentWrapping();
			descXML = xml.getDescription();
			List<Page> pageList = new LinkedList<Page>();
//			List<Relation> relationList = new LinkedList<Relation>();
			WebpipeExecutor ex = new WebpipeExecutor(crawlingXML, wrappingXML, descXML);
			logger.info("WEBPIPE EXECUTOR CREATO");
			logger.info("INIZIO CRAWLING");
			pageList = ex.fireCrawling();
			logger.info("CRAWLING TERMINATO");
			List<Pagina> paginaList = new LinkedList<Pagina>(); //lista di appoggio per stampare il messaggio
			Pagina pagina = new Pagina();
			
			/* Crea l'oggetto di tipo Pagina da salvare su DB */
			for(Page p : pageList){
				logger.info("ELABORAZIONE PAGINA"+p.getURI().toString());
				String uri = p.getURI().toString();
				//se è pdf, non viene estratto il contenuto ma solo il link
				if(isNotHtmlPage(uri)){
					pagina.setContent(uri);
					pagina.setData(new Date());
					pagina.setIdFonte(idFonte);
					pagina.setUri(uri);
					
				}
				//se non è pdf salva tutto il contenuto
				else{
				logger.info("ELABORAZIONE PAGINA"+p.getURI().toString());
				HTMLPage page = (HTMLPage)p;
				String pageContent = page.getStringByXPath("/html");
				pagina.setContent(pageContent);
				pagina.setData(new Date());
				pagina.setIdFonte(idFonte);
				pagina.setUri(p.getURI().toString());
				 }
				paginaList.add(pagina);
				//salva la pagina
				broker.savePage(pagina);
				
			}
			//aggiorna le statistiche sulle pagine scaricate per ogni fonte
			logger.info("AGGIORNAMENTO STATISTICHE");
			broker.updateStatistics(idFonte,paginaList.size());
			request.setAttribute("pageList", paginaList);
			result = true;
		}catch(CrawlingException ce){
			logger.error("ERRORE CRAWLING", ce);
			throw new CrawlingException(ce);}
		return result;
	}

	public PersistenceBroker getBroker() {
		return broker;
	}

	public void setBroker(PersistenceBroker broker) {
		this.broker = broker;
	}
	
	/*
	 * Controlla se l'URI è una pagina HTML oppure no
	 * @return true: se non è HTML
	 * @return false: se è HTML
	 */
	private boolean isNotHtmlPage(String uri){
		boolean result = false;
		if(uri.endsWith(".pdf") || uri.endsWith(".PDF") || uri.endsWith(".doc") || uri.endsWith(".DOC") || uri.endsWith(".rtf"))
			result = true;
		return result;
	}

}
