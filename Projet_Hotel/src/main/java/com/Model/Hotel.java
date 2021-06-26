package com.Model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="hotel")

public class Hotel {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nom", nullable=true, unique=false, length=50)
	private String nom;
	
	@Column(name="adresse", nullable=false, unique=true, length=50)
	private String adresse;
	
	@Column(name="telephone", nullable=true, unique=false, length=50)
	private String telephone;
	
	
	
	@ManyToOne
	private Directeur directeur;
	
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="chambre_id")
	private Set<Chambre> chambres;
	

	

	public Hotel() {
		super();
	}
	
	
	
	public Hotel(String nom, String adresse, String telephone) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}




	
	
	
	public Set<Chambre> getChambre() {
		return chambres;
	}

	public void setChambre(Set<Chambre> chambres) {
		this.chambres = chambres;
	}
	
	
	

		
	
}
