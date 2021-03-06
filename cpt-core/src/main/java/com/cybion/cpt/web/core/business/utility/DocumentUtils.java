package com.cybion.cpt.web.core.business.utility;

import java.io.File;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import com.cybion.cpt.web.core.business.XMLAdapterExecutor;
import com.cybion.cpt.web.core.model.NavigationXML;


/**
 * 
 * @author marco Classe di utilità per la gestione degli xml
 */
public class DocumentUtils {

	private XMLAdapterExecutor executor;
	private Document document;
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	ResourceBundle bundle = ResourceBundle.getBundle("config");
	String prePath = bundle.getString("prePath"); 
	private final String prePath2= "/webpipe/wrappers/";
	


	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public XMLAdapterExecutor getExecutor() {
		return executor;
	}

	public void setExecutor(XMLAdapterExecutor executor) {
		this.executor = executor;
	}

	/** Genera la stringa contenuta nel documento (xml) */
	public String convertToString(Document d) {
		String result = "error";
		try {
			result = new XMLOutputter().outputString(d);
			logger.info("DOCUMENTO CONVERTITO IN STRINGA");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}

	/**
	 * modifica il documento tramite l'XMLAdapterExecutor e ritorna l'oggetto
	 * NavXML con content la stringa contenuta nel documento
	 */
	public NavigationXML modifyXml(Document d, String fonteDescription) {
		NavigationXML xml = null;
		try {
			String crawlingString = generateCrawlingSpecifics(d);
			String wrappingString = generateWrappingSpecifics(d, fonteDescription);
			xml = new NavigationXML();
			xml.setContentCrawling(crawlingString);
			xml.setContentWrapping(wrappingString);

		} catch (Exception e) {
			logger.error("ERRORE"+this.getClass().toString(),e);
		}
		return xml;
	}
	
	/**
	 * Genera la stringa del crawling contenuta nel documento
	 * @param d il documento che è stato uploadto dalla form
	 * @return la stringa relativa al crawling contenuta nel documento
	 */

	private String generateCrawlingSpecifics(Document d) {
		String result = null;
		try {
			executor.setDocument(d);
			Document resultDoc = executor.runCrawlingAdapter();
			result = convertToString(resultDoc);
		}catch(Exception e){logger.error("ERRORE CREAZIONE SPECIFICHE CRAWLING");}
		return result;
	}
	
	/**
	 * Genera la stringa del wrapping contenuta nel documento
	 * @param d il documento che è stato uploadato dalla form
	 * @return la stringa relativa al wrapping contenuta nel documento
	 */

	private String generateWrappingSpecifics(Document d, String fonteDescription) {
		String result = null;
		try {
			executor.setDocument(d);
			executor.setFonteDescription(fonteDescription);
			Document resultDoc = executor.runWrappingAdapter();
			result = convertToString(resultDoc);
		} catch (Exception e) {logger.error("ERRORE CREAZIONE SPECIFICHE WRAPPING");}
		return result;
	}
	
	
	
	public String getUrlFromDocument(Document d) {
		String url = null;
		try {
			Element entryPoint = d.getRootElement().getChild("entrypoint");
			url = entryPoint.getChild("url").getValue();
			System.out.println("url:" + url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}
	
	/**
	 * Crea le directories per ogni fonte
	 * @param fonteDescription: il nome di una fonte
	 */
	public void createDirectories(String fonteDescription) {
		try {
			logger.info("CREAZIONE DIRECTORIES IN CORSO");
			new File(prePath+fonteDescription+"/webpipe/").mkdirs();
			new File(prePath+fonteDescription+prePath2).mkdirs(); 	//crea anche se non sono presenti le cartelle genitori
			logger.info("CREAZIONE DIRECTORIES COMPLETATA");
		}catch(Exception e) {logger.error("ERRORE CREAZIONE DIRECTORIES PER"+fonteDescription);}
	}
	
	/**
	 * Elimina le directories relative ad una fonte
	 * @param nomeFonte: il nome della fonte
	 */
	public void deleteDirectories(String nomeFonte){
		try {
			File file = new File(prePath+nomeFonte);
			deleteDirectory(file);
			logger.info("DIRECTORIES ELIMINATE");
		}catch(Exception e){logger.error("ERRORE ELIMINAZIONE DIRECTORIES PER"+nomeFonte);}
	}
	
	/*
	 * Metodo ricorsivo che cancella il contenuto di una singola directory
	 */
	private static boolean deleteDirectory(File path) {
	    if( path.exists() ) {
	      File[] files = path.listFiles();
	      for(int i=0; i<files.length; i++) {
	         if(files[i].isDirectory()) {
	           deleteDirectory(files[i]);
	         }
	         else {
	           files[i].delete();
	         }
	      }
	    }
	    return( path.delete() );
	  }
	
	
	public void copyFiles(String oldName, String newName) {
		try {
		File oldDir = new File(prePath+oldName+"/webpipe/");
		File newDir = new File(prePath+newName+"/webpipe/"); //destination directory
		
		File[]fileList = oldDir.listFiles();
		File workingFile; 
		for(int i = 0; i<fileList.length;i++) {
			workingFile = fileList[i];
		     workingFile.renameTo(new File(newDir, workingFile.getName()));
		}
		
		File oldWrappersDir = new File(prePath+oldName+"/webpipe/wrappers/");
		File newWrappersDir = new File(prePath+newName+"/webpipe/wrappers");
		fileList = oldWrappersDir.listFiles();
		for(int i = 0; i<fileList.length;i++) {
			workingFile = fileList[i];
			workingFile.renameTo(new File(newWrappersDir, workingFile.getName()));
			}
		}catch(Exception e) {logger.error("ERRORE SPOSTAMENTO FILES");}
	}
}