package cybion.cpt_web.model;

/**
 * the navigation description
 */
public class NavXML {

    private String contentCrawling;
    private String contentWrapping;
    private int idNavXML;
    private String description;

    public int getIdNavXML() {
        return idNavXML;
    }

    public void setIdNavXML(int idNavXML) {
        this.idNavXML = idNavXML;
    }

    public String getContentCrawling() {
        return contentCrawling;
    }

    public void setContentCrawling(String contentCrawling) {
        this.contentCrawling = contentCrawling;
    }

    public String getContentWrapping() {
        return contentWrapping;
    }

    public void setContentWrapping(String contentWrapping) {
        this.contentWrapping = contentWrapping;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
