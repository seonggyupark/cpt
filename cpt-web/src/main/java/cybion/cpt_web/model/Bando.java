package cybion.cpt_web.model;

import java.util.Date;

public class Bando {
	
	private int idBando;
	private String titolo;
	private String oggetto;
	private String ente;
	private String beneficiario;
	private String dataScadenza;
	private String linkAllaFonte;
	private String budget;
	private String attivita;
	private String percFinanziamento;
	private String tipoFinanziamento;
	private String testoIntegrale;
	private Date timestamp;
	private String regGeografica;
	private String note;
	private String tagList;
	private String categoria;
	private String lingua;
	private String sunto;
	
	private int annotationsNumber;
	
	
	public int getIdBando() {
		return idBando;
	}
	public void setIdBando(int idBando) {
		this.idBando = idBando;
	}
	public String getTagList() {
		return tagList;
	}
	public void setTagList(String tagList) {
		this.tagList = tagList;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getOggetto() {
		return oggetto;
	}
	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}
	public String getEnte() {
		return ente;
	}
	public void setEnte(String ente) {
		this.ente = ente;
	}
	public String getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}
	public String getDataScadenza() {
		return dataScadenza;
	}
	public void setDataScadenza(String dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	public String getLinkAllaFonte() {
		return linkAllaFonte;
	}
	public void setLinkAllaFonte(String linkAllaFonte) {
		this.linkAllaFonte = linkAllaFonte;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getAttivita() {
		return attivita;
	}
	public void setAttivita(String attivita) {
		this.attivita = attivita;
	}
	public String getPercFinanziamento() {
		return percFinanziamento;
	}
	public void setPercFinanziamento(String percFinanziamento) {
		this.percFinanziamento = percFinanziamento;
	}
	public String getTipoFinanziamento() {
		return tipoFinanziamento;
	}
	public void setTipoFinanziamento(String tipoFinanziamento) {
		this.tipoFinanziamento = tipoFinanziamento;
	}
	public String getTestoIntegrale() {
		return testoIntegrale;
	}
	public void setTestoIntegrale(String testoIntegrale) {
		this.testoIntegrale = testoIntegrale;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timeStamp) {
		this.timestamp = timeStamp;
	}
	public String getRegGeografica() {
		return regGeografica;
	}
	public void setRegGeografica(String regGeografica) {
		this.regGeografica = regGeografica;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public void setAnnotationsNumber(int annotationsNumber) {
		this.annotationsNumber = annotationsNumber;
	}
	public int getAnnotationsNumber() {
		return annotationsNumber;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setLingua(String lingua) {
		this.lingua = lingua;
	}
	public String getLingua() {
		return lingua;
	}
  public void setSunto(String sunto) {
    this.sunto = sunto;
  }
  public String getSunto() {
    return sunto;
  }
	
  @Override
  public String toString() {
    return "attivita: "+this.attivita+" - beneficiario: "+this.beneficiario+" - budget: "+this.budget+
    "- categoria : "+this.categoria+" - data scadenza : "+this.dataScadenza+" - ente : "+this.ente+
    " - lingua : "+this.lingua+" - link alla fonte : "+this.linkAllaFonte+" - note: "+this.note+
    " - oggetto: "+this.oggetto+ " - perc. finanz.: "+this.percFinanziamento+" - reg. geo.: "+
    this.regGeografica+" - sunto: "+this.sunto+" - tags: "+this.tagList+" - tipo fin.: "+
    this.tipoFinanziamento+ " - titolo: ";
  }
	
}
