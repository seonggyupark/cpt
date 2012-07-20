package cybion.cpt_web.business.utility;

import org.jdom.Document;

/**
 * Adapts a crawling specification from the CMG model to the Webpipe model
 */
public interface CrawlingSpecificationAdapter {

    /**
     * Converted the current objec to an XML {@link Document} adapted to the
     * Webpipe format
     */
    public Document getAdaptedDoc() throws Exception;

    public void setPluginCrawlingSpecificationDocument(Document d);

}