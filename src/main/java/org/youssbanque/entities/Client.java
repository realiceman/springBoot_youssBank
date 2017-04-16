package org.youssbanque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable{

	@Id
	@GeneratedValue
	private Long code;
	private String nom;
	private String email;
	@OneToMany(mappedBy="client", fetch=FetchType.LAZY)
	private Collection<Compte> comptes;
	
	public Client() {
		// TODO Auto-generated constructor stub
	}

	public Client(String nom, String email) {
		super();
		this.nom = nom;
		this.email = email;
	}

	public Long getCode() {
		return code;
	}

	public Collection<Compte> getComptes() {
		return comptes;
	}

	public String getEmail() {
		return email;
	}

	public String getNom() {
		return nom;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
