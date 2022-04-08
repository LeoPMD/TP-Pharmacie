package com.initiformation;

import java.util.*;

public class Medicament {

	public static Scanner sc = new Scanner(System.in);

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

	public static Medicament lireMedicament() {
		System.out.print("Veuillez renseigner le nom du medicament (avec une majuscule) : ");
		String findMedicament = sc.next();
		boolean verificationMedicament = false;

		for (int ii = 0; ii < Main.listeMedicament.size(); ii++) {
			if (Main.listeMedicament.get(ii).getNom().contains(findMedicament)) {
				verificationMedicament = true;
				return Main.listeMedicament.get(ii);

			}
		}

		if (verificationMedicament == false) {
			System.out.println("Le medicament renseigné n'est pas trouvable !\n");
			System.out.println("Retour au menu\n");
			Main.menu();
		}
		return null;
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