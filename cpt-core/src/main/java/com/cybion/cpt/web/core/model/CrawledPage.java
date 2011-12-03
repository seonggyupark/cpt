package com.cybion.cpt.web.core.model;

import java.util.Date;

public class CrawledPage {
	
	private int idPagina;
	private String content;
	private Date data;
	private String uri;	//uri della pagina
	private int idFonte; //id della fonte di cui la pagina fa parte
	
	public int getIdPagina() {
		return idPagina;
	}
	public void setIdPagina(int idPagina) {
		this.idPagina = idPagina;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public int getIdFonte() {
		return idFonte;
	}
	public void setIdFonte(int idFonte) {
		this.idFonte = idFonte;
	}
	public String toString(){
		return "DATA: "+this.data+"\nCONTENT: "+this.content;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}

}
