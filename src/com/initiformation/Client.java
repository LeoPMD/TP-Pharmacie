package com.initiformation;

import java.util.*;

public class Client {

	public static Scanner sc = new Scanner(System.in);

	private static int compteur = 0;
	private int id;
	private String nom;
	private double credit = 0.00;

	public Client() {
		compteur++;
		this.id = compteur;
	}

	public Client(String nom) {
		super();
		compteur++;
		this.id = compteur;
		this.nom = nom;
		this.credit = 0;
	}

	public static Client lireClient() {
		System.out.print("Veuillez renseigner le nom du client (avec une majuscule) : ");
		String findClient = sc.next();
		boolean verificationClient = false;

		for (int ii = 0; ii < Main.listeClient.size(); ii++) {
			if (Main.listeClient.get(ii).getNom().contains(findClient)) {
				verificationClient = true;
				return Main.listeClient.get(ii);

			}

		}

		if (verificationClient == false) {
			System.out.println("Le client renseigné n'est pas trouvable !\n");
			System.out.println("Voulez vous créer ce nouveau Client :\n"
			+ "1. Oui\n"
			+ "2. Non, retour au menu\n");

			int key = sc.nextInt();
			switch (key) {
			case 1:
				Client c1 = new Client(findClient);
				Main.listeClient.add(c1);
				
				System.out.println("Le client " + findClient + " a bien été enregistré !\n");

				
				return c1;
				

			case 2:
				Main.menu();
				break;

			default:
				break;
			}

		}

		return null;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public static int getCompteur() {
		return compteur;
	}

	public static void setCompteur(int compteur) {
		Client.compteur = compteur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", credit=" + credit + "]";
	}

}