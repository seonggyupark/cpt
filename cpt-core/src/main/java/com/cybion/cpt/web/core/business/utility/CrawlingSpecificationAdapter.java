package com.cybion.cpt.web.core.business.utility;

import org.jdom.Document;

/**
 * 
 * @author Tommaso Teofili
 *
 */
public interface CrawlingSpecificationAdapter {
	
	/** Torna un documento contenente un XML adattato per la Webpipe */
	public Document getAdaptedDoc();
	
	/** Getter & Setter */
	public void setPluginCrawlingSpecificationDocument(Document d);

}