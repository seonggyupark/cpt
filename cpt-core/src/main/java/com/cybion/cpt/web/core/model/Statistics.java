package com.cybion.cpt.web.core.model;

public class Statistics {
	
	private int idFonte;	//id della fonte
	private double media;	//media delle pagine scaricate
	private int contatore;	//numero di scaricamenti effettuati
	private int last;		//pagine scaricate durante l'ultimo crawling
	
	
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
