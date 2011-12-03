package com.cybion.cpt.web.core.business.utility;

import org.jdom.Document;

public interface WrappingSpecificationAdapter {
	
	
	/** Torna un documento contenente un XML adattato per la Webpipe */
	public Document getAdaptedDoc();
	
	/** Getter & Setter */
	public void setPluginWrappingSpecificationDocument(Document d);
	public void setFonteDescription(String description);
	
}
