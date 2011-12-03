package com.cybion.cpt.web.core.business.utility;

import java.util.List;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;

/**
 * Adapter per la versione del plugin per Firefox aggiornato al 25 Marzo 2009
 * @author Tommaso Teofili
 *
 */
public class CrawlingSpecificationFirefoxPluginAdapter implements
		CrawlingSpecificationAdapter {
	
	private Logger logger = Logger.getLogger(this.getClass());

	private Document pluginCrawlingSpecificationDocument;
	
	public CrawlingSpecificationFirefoxPluginAdapter(){}
	
	
	public CrawlingSpecificationFirefoxPluginAdapter(Document pluginCrawlingSpecificationDocument) {
		this.pluginCrawlingSpecificationDocument = pluginCrawlingSpecificationDocument;
	}
	
	/**
	 * adapt the document and returns a new adapted document
	 * @return
	 */
	public Document getAdaptedDoc() {
		
		//specifica di navigazione come se la aspetta la webpipe (da costruire)
		Document adaptedCrawlingSpecificaton = new Document();

		try {

			Element root = this.pluginCrawlingSpecificationDocument.getRootElement();

			//nodo radice navigazione
			adaptedCrawlingSpecificaton.addContent(new Element("navigation"));

			Element entryPoint = root.getChild("entrypoint");
			String url = entryPoint.getChild("url").getText().replace("<![CDATA[","").replace("]]>", ""); //url

			//entrypoint
			Element newEntryPoint = new Element("entrypoint");
			newEntryPoint.setAttribute("url", url);
			newEntryPoint.setAttribute("pageclass",entryPoint.getAttributeValue("type"));
			adaptedCrawlingSpecificaton.getRootElement().addContent(newEntryPoint);

			//model 
			Element model = new Element("model"); //nuovo tag model
			//iterare sulle pageclass del vecchio xml e per ognuna prendiamo type, creiamo name e prendiamo expectedtype

			List<Element> pageClasses =  root.getChild("model").getChildren("pageclass");


			int i = 0;
			for (Element pc : pageClasses) {
				Element nuovaPageClass = new Element("pageclass");
				String type = pc.getAttributeValue("type");
				nuovaPageClass.setAttribute("type",type); //attributo type

				Element nuovaClassRequest = new Element("classrequest");
				nuovaClassRequest.setAttribute("pageclass",type);

				//setta expectedtype e type
				try {
					if (i+1<pageClasses.size()) {
						Element pageClassSuccessiva = pageClasses.get(i+1);
						String tipoSuccessivo = pageClassSuccessiva.getAttributeValue("type");
						nuovaClassRequest.setAttribute("type",type+"2"+tipoSuccessivo);
						nuovaClassRequest.setAttribute("expectedtype",tipoSuccessivo);

						//crea elemento clickonall
						Element clickOnAll = new Element("clickonall");
						clickOnAll.setAttribute("xpath",pc.getChild("classlink").getChild("linksfactory").getChild("xpath").getText());

						//aggiunge clickonall alla classrequest
						nuovaClassRequest.addContent(clickOnAll);


						//aggiunge la classrequest alla pageclass
						nuovaPageClass.addContent(nuovaClassRequest);
						
					}
					model.addContent(nuovaPageClass); //aggiunge la pageclass al model
				} catch (Exception e) {
					logger.error("ERRORE GENERAZIONE PAGECLASS",e);
				}
				i++;

			}

			adaptedCrawlingSpecificaton.getRootElement().addContent(model); //aggiunge il model al documento

		

		} catch (Exception e) {
			logger.error("ERRORE GENERAZIONE SPECIFICHE CRAWLING",e);
		} 
		
		
		return adaptedCrawlingSpecificaton;
	}

	public Document getPluginCrawlingSpecificationDocument() {
		return pluginCrawlingSpecificationDocument;
	}


	public void setPluginCrawlingSpecificationDocument(
			Document pluginCrawlingSpecificationDocument) {
		this.pluginCrawlingSpecificationDocument = pluginCrawlingSpecificationDocument;
	}


}
