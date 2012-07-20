package cybion.cpt_web.model;

/**
 * Statistics collected during crawling + information extraction
 */
public class Statistics {

    private int idFonte;
    private double media;
    private int contatore;
    private int last;

    public int getIdFonte() {
        return idFonte;
    }

    public void setIdFonte(int idFonte) {
        this.idFonte = idFonte;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public int getContatore() {
        return contatore;
    }

    public void setContatore(int contatore) {
        this.contatore = contatore;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

}
