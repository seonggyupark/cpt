package cybion.cpt_web.model;

public class Metadata {

    private String text;
    private String type;
    private String begin;
    private String end;
    private int occurencies;

    public Metadata() {
        this.occurencies = 1;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getOccurencies() {
        return occurencies;
    }

    public void setOccurencies(int occurencies) {
        this.occurencies = occurencies;
    }

}
