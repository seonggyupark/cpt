package cybion.cpt_web.business.utility;

import java.io.File;
import java.util.ResourceBundle;

import cybion.cpt_web.business.XMLAdapterExecutor;
import cybion.cpt_web.model.NavXML;
import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

/**
 * Utility class for XML handling
 */
public class DocumentUtils {

    private XMLAdapterExecutor executor;
    private Document document;

    private Logger logger = Logger.getLogger(this.getClass());

    ResourceBundle bundle = ResourceBundle.getBundle("config");
    String prePath = bundle.getString("prePath");
    private final String prePath2 = "/webpipe/wrappers/";


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

    /**
     * Generates the string contained inside the xml document
     */
    public String convertToString(Document d) {
        String result = "error";
        try {
            result = new XMLOutputter().outputString(d);
            if (logger.isDebugEnabled())
                logger.debug("document converted");
        } catch (Exception e) {
            logger.error(e);
        }
        return result;
    }

    /**
     * Modifies the document via teh {@link XMLAdapterExecutor} and returns the
     * {@link NavXML} with the string contained in the document as content
     */
    public NavXML modifyXml(Document d, String fonteDescription) {
        NavXML xml = null;
        try {
            String crawlingString = generateCrawlingSpecifics(d);
            String wrappingString = generateWrappingSpecifics(d, fonteDescription);
            xml = new NavXML();
            xml.setContentCrawling(crawlingString);
            xml.setContentWrapping(wrappingString);

        } catch (Exception e) {
            logger.error(e);
        }
        return xml;
    }

    /**
     * Genera la stringa del crawling contenuta nel documento
     *
     * @param d il documento che è stato uploadto dalla form
     * @return la stringa relativa al crawling contenuta nel documento
     */

    private String generateCrawlingSpecifics(Document d) {
        String result = null;
        try {
            executor.setDocument(d);
            Document resultDoc = executor.runCrawlingAdapter();
            result = convertToString(resultDoc);
        } catch (Exception e) {
            logger.error(e);
        }
        return result;
    }

    /**
     * Genera la stringa del wrapping contenuta nel documento
     *
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
        } catch (Exception e) {
            logger.error("ERRORE CREAZIONE SPECIFICHE WRAPPING");
        }
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
     *
     * @param fonteDescription: il nome di una fonte
     */
    public void createDirectories(String fonteDescription) {
        try {
            logger.info("CREAZIONE DIRECTORIES IN CORSO");
            new File(prePath + fonteDescription + "/webpipe/").mkdirs();
            new File(prePath + fonteDescription + prePath2).mkdirs();     //crea anche se non sono presenti le cartelle genitori
            logger.info("CREAZIONE DIRECTORIES COMPLETATA");
        } catch (Exception e) {
            logger.error("ERRORE CREAZIONE DIRECTORIES PER" + fonteDescription);
        }
    }

    /**
     * Elimina le directories relative ad una fonte
     *
     * @param nomeFonte: il nome della fonte
     */
    public void deleteDirectories(String nomeFonte) {
        try {
            File file = new File(prePath + nomeFonte);
            deleteDirectory(file);
            logger.info("DIRECTORIES ELIMINATE");
        } catch (Exception e) {
            logger.error("ERRORE ELIMINAZIONE DIRECTORIES PER" + nomeFonte);
        }
    }

    /*
      * Metodo ricorsivo che cancella il contenuto di una singola directory
      */
    private static boolean deleteDirectory(File path) {
        if (path.exists()) {
            File[] files = path.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    deleteDirectory(files[i]);
                } else {
                    files[i].delete();
                }
            }
        }
        return (path.delete());
    }


    public void copyFiles(String oldName, String newName) {
        try {
            File oldDir = new File(prePath + oldName + "/webpipe/");
            File newDir = new File(prePath + newName + "/webpipe/"); //destination directory

            File[] fileList = oldDir.listFiles();
            File workingFile;
            for (int i = 0; i < fileList.length; i++) {
                workingFile = fileList[i];
                workingFile.renameTo(new File(newDir, workingFile.getName()));
            }

            File oldWrappersDir = new File(prePath + oldName + "/webpipe/wrappers/");
            File newWrappersDir = new File(prePath + newName + "/webpipe/wrappers");
            fileList = oldWrappersDir.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                workingFile = fileList[i];
                workingFile.renameTo(new File(newWrappersDir, workingFile.getName()));
            }
        } catch (Exception e) {
            logger.error("ERRORE SPOSTAMENTO FILES");
        }
    }
}