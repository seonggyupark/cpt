package it.chi.webpipe.test.crawler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;


public class CrawlingSpecificationFirefoxPluginAdapter implements
		CrawlingSpecificationAdapter {

	private String pluginCrawlingSpecificationPath;
	private String adaptedCrawlingSpecificationPath;

	public CrawlingSpecificationFirefoxPluginAdapter(String crawlSpec) {
		this.pluginCrawlingSpecificationPath = crawlSpec;
		this.adaptedCrawlingSpecificationPath = crawlSpec.replace(".xml", "Adapted.xml");
	}

	public String getAdaptedFile() {

		try {
			//specifica di navigazione definita dal plugin
			Document pluginCrawlingSpecification = new SAXBuilder().build(this.pluginCrawlingSpecificationPath);


			//specifica di navigazione come se la aspetta la webpipe (da costruire)
			Document adaptedCrawlingSpecificaton = new Document();


			Element root = pluginCrawlingSpecification.getRootElement();

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

			List pcs = new ArrayList();
			//iterare sulle pageclass del vecchio xml e per ognuna prendiamo type, creiamo name e prendiamo expectedtype

			List<Element> pageClasses =  root.getChild("model").getChildren("pageclass");


			int i = 0;
			for (Element pc : pageClasses) {
				Element nuovaPageClass = new Element("pageclass");
				String type = pc.getAttributeValue("type");
				nuovaPageClass.setAttribute("pageclass",type); //attributo type

				Element nuovaClassRequest = new Element("classrequest");
				nuovaClassRequest.setAttribute("pageclass",type);

				//setta expectedtype e type
				try {
					if (i+1<pageClasses.size()) {
						Element pageClassSuccessiva = pageClasses.get(i+1);
						String tipoSuccessivo = pageClassSuccessiva.getAttributeValue("type");
						nuovaClassRequest.setAttribute("type",type+"2"+tipoSuccessivo);
						nuovaClassRequest.setAttribute("expectedType",tipoSuccessivo);

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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i++;

			}

			adaptedCrawlingSpecificaton.getRootElement().addContent(model); //aggiunge il model al documento

			
			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
		    try {
		      outputter.output(adaptedCrawlingSpecificaton, new FileOutputStream(new File(adaptedCrawlingSpecificationPath)));       
		    }
		    catch (IOException e) {
		      e.printStackTrace();
		      adaptedCrawlingSpecificationPath = null;
		    }

		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			adaptedCrawlingSpecificationPath = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			adaptedCrawlingSpecificationPath = null;
		} 




		// TODO Auto-generated method stub
		return adaptedCrawlingSpecificationPath;
	}

}
