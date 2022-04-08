package com.initiformation;

import java.util.*;

public class Medicament {

	private int id;
	private String nom;
	private double prix;
	private int stock;

	
 
    public Medicament() {
    }
    
	public Medicament(int id, String nom, double prix, int stock) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.stock = stock;
	}
    
    

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getStock() {
		return stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	
	
	
	
	@Override
	public String toString() {
		return "Medicament [id=" + id + ", nom=" + nom + ", prix=" + prix + ", stock=" + stock + "]";
	}






	
	
	
    
}