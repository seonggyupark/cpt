package cybion.cpt_web.business.utility;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class WrappingSpecificationFirefoxPluginAdapter implements WrappingSpecificationAdapter {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	ResourceBundle bundle = ResourceBundle.getBundle("config");
	String prePath = bundle.getString("prePath"); 
	private final String wrapperPath = "/webpipes/";
	private final String prePath2= "/webpipe/wrappers/";
	private final String postPath = ".xml";
	private String fonteDescription;
	


	private Document pluginWrappingSpecificationDocument;
	
	
	public WrappingSpecificationFirefoxPluginAdapter(){}
	
	
	public WrappingSpecificationFirefoxPluginAdapter(String wrappingPath, String fonteDescription) {
		try{ 
			this.fonteDescription=fonteDescription;
			InputStream is = new FileInputStream(wrappingPath);
			this.pluginWrappingSpecificationDocument = new SAXBuilder().build(is);
		}catch(Exception e){logger.error("ERRORE COSTRUTTORE WRAPPING SPECIFICATION",e);}	
	}
	
	public WrappingSpecificationFirefoxPluginAdapter(Document document) {
		this.pluginWrappingSpecificationDocument = document;
	}

	/**
	 * Estrae i metadati e li traduce nel formato della webpipe
	 * @return: Il document che rappresenta l'xml del wrapping
	 */
	
	public Document getAdaptedDoc() {
		Document result = null;
		
		try {
				Element root = this.pluginWrappingSpecificationDocument.getRootElement();		
				Element newRoot = new Element("wrappers");
				
				List<Element> pageClasses = root.getChild("model").getChildren("pageclass");
				
				for (Element pageclass : pageClasses) {
					String pageClassName = pageclass.getAttributeValue("type");
					Element metadata = pageclass.getChild("metadatas");
					if(metadata!=null){
						Element wrapperElement = createWrapperElement(pageclass, pageClassName);
						newRoot.addContent(wrapperElement);
						List<Element> dataList = metadata.getChildren("metadata");
						for (Element metadataElement: dataList) {
							Document wrapperDocument = new Document(); //documento del singolo wrapper
							Element wrapperRoot = new Element("wrapper");
							Element extractionRuleElement = createExtractionRuleElement(metadataElement, pageClassName);
							wrapperRoot.addContent(extractionRuleElement);
							wrapperDocument.setRootElement(wrapperRoot);
							outputOnFile(wrapperDocument, pageClassName);
						}
					}
				}
				result = new Document();
				result.setRootElement(newRoot);
			} catch(Exception e){logger.error("ERRORE GENERAZIONE DOCUMENTO ADATTATO",e);}
			return result;
	}
	/**
	 * Controlla se sono presenti metadati nel file xml
	 * @return true se presenti
	 * @return false se assenti
	 */
	private boolean isMetadataPresent(){
		boolean result = false;
		Element root = this.pluginWrappingSpecificationDocument.getRootElement();
		List<Element> pageClasses = root.getChild("model").getChildren("pageclass");
		for(Element pageClass : pageClasses) {
			Element metadata = pageClass.getChild("metadatas");
			if(metadata!=null)
				result = true;
		}
		return result;
	}

	private Element createExtractionRuleElement(Element metadataElement, String pageClassName) {
		Element erElement = null;
		try {
			String mdName = metadataElement.getChild("name").getValue();
			String xpath = metadataElement.getChild("extractor").getChild("xpath").getValue();
			erElement = new Element("extractionrule");
			erElement.setAttribute("extractor", "XPath");
			erElement.setAttribute("xpath", xpath);
			erElement.setAttribute("attribute", mdName);
		}catch(Exception e){logger.error("ERRORE GENERAZIONE REGOLA DI ESTRAZIONE",e);}
		return erElement;
	}

	public void setPluginWrappingSpecificationDocument(Document d) {
		this.pluginWrappingSpecificationDocument = d;
	}
	
	/**
	 * Scrive su file il documento
	 * @param document il documento da scrivere
	 * @param pageClassName il nome della pageclass (sarà anche il nome del file su file system)
	 */
	public void outputOnFile(Document document, String pageClassName){
		BufferedWriter out = null;
		try	{
			System.out.println("##INIZIO SCRITTURA WRAPPER SPECIFICO##");
			out = new BufferedWriter(new FileWriter(prePath+fonteDescription+prePath2+pageClassName+postPath));
			out.write(new XMLOutputter().outputString(document));
			out.flush();out.close();
			System.out.println("##FINE SCRITTURA WRAPPER SPECIFICO##");
		}catch(Exception e){logger.error("ERRORE SCRITTURA DOCUMENTO SU FILE",e);}
	}
	
	/**
	 * data la pageclass dell'xml del plugin
	 * restituisce l'elemento wrapper dell'xml della webpipe
	 * @param pageclass
	 * @return wrapper element 
	 */
	private Element createWrapperElement(Element pageclass, String pageClassName) {
		Element resultWrapper = null;
		try {
			resultWrapper = new Element("wrapper");
			resultWrapper.setAttribute("type", "xpath");
			resultWrapper.setAttribute("pageclassname", pageClassName);
			resultWrapper.setAttribute("relationname", pageClassName);
			resultWrapper.setAttribute("path",wrapperPath+fonteDescription+prePath2+pageClassName+postPath);
			resultWrapper.setText("");
		}catch(Exception e){logger.error("ERRORE GENERAZIONE ELEMENTO WRAPPER",e);}
		return resultWrapper;
	}
	
	public String getFonteDescription() {
		return fonteDescription;
	}


	public void setFonteDescription(String fonteDescription) {
		
		this.fonteDescription = fonteDescription;
	}
}