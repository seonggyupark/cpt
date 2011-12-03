package cybion.cpt_web.model;

import java.util.Set;


public class Fonte {
	
	private int idFonte;	
	private String nome;			//nome identificativo della fonte (es: TED)
	private String link;			// link alla homePage della fonte
	private String linkStartNavigazione;	//link di partenza della navigazione
	private NavXML xmlDescriber;	//descrive la navigazione della fonte
	private String scheduling; 		//contiene il periodo di tempo per lo scheduling del crawler
	private Set<Interesse> setInteressi;	//set di interessi

	
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
	public void setLinkStartNavigazione(String linkStartNavigazione) {
		this.linkStartNavigazione = linkStartNavigazione;
	}
	public String getLinkStartNavigazione() {
		return linkStartNavigazione;
	}
	

}
