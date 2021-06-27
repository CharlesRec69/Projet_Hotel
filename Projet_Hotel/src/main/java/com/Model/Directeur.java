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
@Table(name="directeur")
public class Directeur {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false, unique=true)
	private int id;
	
	@Column(name="nom", nullable=true, unique=false, length=50)
	private String nom;
	
	@Column(name="prenom", nullable=true, unique=false, length=50)
	private String prenom;
	

	/* un directeur pour plusieurs salaries */
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="directeur_id")
	private Set<Salarie> salaries;

	
	
	public Directeur() {
		super();
	}


	public Directeur(String nom, String prenom, Set<Salarie> salaries) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.salaries = salaries;
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

	
	

	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	
	

	
	
	public Set<Salarie> getSalaries() {
		return salaries;
	}


	public void setSalaries(Set<Salarie> salaries) {
		this.salaries = salaries;
	}


	
	
	
	
}
