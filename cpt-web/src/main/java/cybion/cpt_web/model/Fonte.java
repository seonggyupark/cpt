package cybion.cpt_web.model;

import java.util.Set;


/**
 * A source of information
 */
public class Fonte {

    private int idFonte;
    private String nome;
    private String link;
    private NavXML xmlDescriber;
    private String scheduling;
    private Set<Interesse> setInteressi;


    public NavXML getXmlDescriber() {
        return xmlDescriber;
    }

    public void setXmlDescriber(NavXML xmlDescriber) {
        this.xmlDescriber = xmlDescriber;
    }

    public int getIdFonte() {
        return idFonte;
    }

    public void setIdFonte(int idFonte) {
        this.idFonte = idFonte;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getScheduling() {
        return scheduling;
    }

    public void setScheduling(String scheduling) {
        this.scheduling = scheduling;
    }

    public Set<Interesse> getSetInteressi() {
        return setInteressi;
    }

    public void setSetInteressi(Set<Interesse> setInteressi) {
        this.setInteressi = setInteressi;
    }


}
