package com.cybion.cpt.web.core.model;

public class NavigationXML {
	
	private String contentCrawling;	//contiene l'xml di navigazione
	private String contentWrapping; //contiene l'xml per l'estrazione di metadati
	private int idNavXML;
	private String description; //piccola descrizione
	
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
