package com.cybion.cpt.web.core.business;

import org.apache.log4j.Logger;
import org.jdom.Document;

import com.cybion.cpt.web.core.business.utility.CrawlingSpecificationAdapter;
import com.cybion.cpt.web.core.business.utility.WrappingSpecificationAdapter;


public class XMLAdapterExecutor {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	private Document document;
	private CrawlingSpecificationAdapter crawlingAdapter;
	private WrappingSpecificationAdapter wrappingAdapter;
	private String fonteDescription;
	
	public XMLAdapterExecutor(){
	}
	
	/*
	 * Chiama l'adapter e restituisce il Document del crawling
	 */
	public Document runCrawlingAdapter(){
		Document result = null;
		try {
			crawlingAdapter.setPluginCrawlingSpecificationDocument(document);
			result = crawlingAdapter.getAdaptedDoc();
		}catch(Exception e){logger.error("ERRORE GENERAZIONE CRAWLING ADATTATO",e);}
		return result;
	}
	
	/*
	 * Chiama l'adapter e restituisce il Document del wrapping
	 */
	
	public Document runWrappingAdapter() {
		Document result = null;
		try {
			wrappingAdapter.setPluginWrappingSpecificationDocument(document);
			wrappingAdapter.setFonteDescription(fonteDescription);
			result = wrappingAdapter.getAdaptedDoc();
		}catch(Exception e){logger.error("ERRORE GENERAZIONE WRAPPING ADATTATO",e);}
		return result;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public CrawlingSpecificationAdapter getCrawlingAdapter() {
		return crawlingAdapter;
	}

	public void setCrawlingAdapter(CrawlingSpecificationAdapter crawlingAdapter) {
		this.crawlingAdapter = crawlingAdapter;
	}

	public WrappingSpecificationAdapter getWrappingAdapter() {
		return wrappingAdapter;
	}

	public void setWrappingAdapter(WrappingSpecificationAdapter wrappingAdapter) {
		this.wrappingAdapter = wrappingAdapter;
	}

	public String getFonteDescription() {
		return fonteDescription;
	}

	public void setFonteDescription(String fonteDescription) {
		this.fonteDescription = fonteDescription;
	}
	
	
	
	
}
