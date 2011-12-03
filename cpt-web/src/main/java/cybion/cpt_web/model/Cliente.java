package cybion.cpt_web.model;

import java.util.Set;

public class Cliente {
	
	
	private int idCliente;
	private String nome;	//identificativo del cliente
	private String email;	//email di riferimento per il cliente
	private Set<Interesse> setInteressi;	//set di interessi
	

	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Interesse> getSetInteressi() {
		return setInteressi;
	}
	public void setSetInteressi(Set<Interesse> setInteressi) {
		this.setInteressi = setInteressi;
	}
}
