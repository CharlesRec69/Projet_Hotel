package com.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="chambre")

public class Chambre {

		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="numero_chambre", nullable=true, unique=false, length=50)
	private int numero_chambre;
	
	@Column(name="superficie", nullable=false, unique=true, length=50)
	private String superficie;
	
	@Column(name="type", nullable=true, unique=false, length=50)
	private String type;
	
	@Column(name="etage", nullable=true, unique=false, length=50)
	private float etage;
	
	
	/* Plusieurs chambres pour un et un seul Hotel */
	@ManyToOne
	private Hotel hotel;

	

	public Chambre() {
		super();
	}
	
	
	
	public Chambre(int numero_chambre, String superficie, String type, float etage) {
		super();
	
		this.numero_chambre = numero_chambre;
		this.superficie = superficie;
		this.type = type;
		this.etage = etage;
		
	}




	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}




	public int getNumero_chambre() {
		return numero_chambre;
	}

	public void setNumero_chambre(int numero_chambre) {
		this.numero_chambre = numero_chambre;
	}




	public String getSuperficie() {
		return superficie;
	}

	public void setSuperficie(String superficie) {
		this.superficie = superficie;
	}




	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}




	public double getEtage() {
		return etage;
	}

	public void setEtage(float etage) {
		this.etage = etage;
	}




	
	
	
	
	public Hotel getHotel() {
		return hotel;
	}

	
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	
	
	
}
