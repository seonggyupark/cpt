package cybion.cpt_web.business.utility;

import java.util.List;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;

/**
 * {@link CrawlingSpecificationAdapter} adapted to CMG Firefox plugin updated to
 * March 25th 2009
 */
public class CrawlingSpecificationFirefoxPluginAdapter implements
        CrawlingSpecificationAdapter {

    private Logger logger = Logger.getLogger(this.getClass());

    private Document pluginCrawlingSpecificationDocument;

    public CrawlingSpecificationFirefoxPluginAdapter(Document pluginCrawlingSpecificationDocument) {
        this.pluginCrawlingSpecificationDocument = pluginCrawlingSpecificationDocument;
    }

    /**
     * Adapts the current document and returns a new adapted document
     */
    public Document getAdaptedDoc() throws Exception {

        // this is the resulting adpated document
        Document adaptedCrawlingSpecificaton = new Document();

        Element root = this.pluginCrawlingSpecificationDocument.getRootElement();

        // root node
        adaptedCrawlingSpecificaton.addContent(new Element("navigation"));

        Element entryPoint = root.getChild("entrypoint");
        String url = entryPoint.getChild("url").getText().replace("<![CDATA[", "").replace("]]>", ""); //url

        // entrypoint
        Element newEntryPoint = new Element("entrypoint");
        newEntryPoint.setAttribute("url", url);
        newEntryPoint.setAttribute("pageclass", entryPoint.getAttributeValue("type"));
        adaptedCrawlingSpecificaton.getRootElement().addContent(newEntryPoint);

        // model
        Element model = new Element("model"); //nuovo tag model

        // iterates over the pageclasses of the old xml and for each takes type, creates a new name and takes expectedtype
        List<Element> pageClasses = root.getChild("model").getChildren("pageclass");


        int i = 0;
        for (Element pc : pageClasses) {
            Element nuovaPageClass = new Element("pageclass");
            String type = pc.getAttributeValue("type");
            nuovaPageClass.setAttribute("type", type);

            Element nuovaClassRequest = new Element("classrequest");
            nuovaClassRequest.setAttribute("pageclass", type);

            //s setting expectedtype and type
            if (i + 1 < pageClasses.size()) {
                Element pageClassSuccessiva = pageClasses.get(i + 1);
                String tipoSuccessivo = pageClassSuccessiva.getAttributeValue("type");
                nuovaClassRequest.setAttribute("type", type + "2" + tipoSuccessivo);
                nuovaClassRequest.setAttribute("expectedtype", tipoSuccessivo);

                // clickonall element
                Element clickOnAll = new Element("clickonall");
                clickOnAll.setAttribute("xpath", pc.getChild("classlink").getChild("linksfactory").getChild("xpath").getText());

                // add clickonall to the  classrequest
                nuovaClassRequest.addContent(clickOnAll);


                // add the classrequest to the pageclass
                nuovaPageClass.addContent(nuovaClassRequest);

            }
            model.addContent(nuovaPageClass); //aggiunge la pageclass al model
            i++;

        }

        adaptedCrawlingSpecificaton.getRootElement().addContent(model); //aggiunge il model al documento

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
