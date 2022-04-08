package com.initiformation;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Client> listeClient = new ArrayList<Client>();
	public static ArrayList<Medicament> listeMedicament = new ArrayList<Medicament>();
	
	
	public static void main(String[] args) {

		Medicament m1 = new Medicament(1, "Aspirine", 5.50, 15);
		listeMedicament.add(m1);
		Medicament m2 = new Medicament(2, "Doliprane", 9.99, 8);
		listeMedicament.add(m2);
		Medicament m3 = new Medicament(3, "Smecta", 8.00, 5);
		listeMedicament.add(m3);
		Medicament m4 = new Medicament(4, "Spasfon", 2.00, 90);
		listeMedicament.add(m4);
		Medicament m5 = new Medicament(5, "Efferalgan", 16.20, 45);
		listeMedicament.add(m5);
		Medicament m6 = new Medicament(6, "Dafalgan", 12.50, 35);
		listeMedicament.add(m6);
		Medicament m7 = new Medicament(7, "Advil", 9.40, 12);
		listeMedicament.add(m7);
		
		System.out.println("***************************************************************** \n");
		System.out.println("Veuillez sélectionner le programme que vous souhaitez : \n"
				+ "1. Effectuer un Achat \n"
				+ "2. Création d'un nouveau Client \n"
				+ "3. Afficher le profil d'un Client \n"
				+ "4. Afficher un médicament et son stock \n"
				+ "5. Approvisionner stock de médicament \n"
				+ "6. Fin de l'application \n");

		int key = sc.nextInt();
		switch (key)
		{
		case 1:
			effectuerAchat();
			break;

		case 2:
			creationClient();
			break;

		case 3:
			afficherClient();

			break;

		case 4:
			afficherMedicament();
			break;
			
		case 5:
			approvisionner();
			break;
			
		case 6:
			quitterApplication();
			break;

		default:
			break;
		}
	}


	
	
	private static void effectuerAchat() {
		
		main(null);
	}


	
	
	private static void creationClient() {
		Client c1 = new Client();
		System.out.print("Veuillez renseigner le nom du client a enregistrer : ");
		c1.setNom(sc.next());
		System.out.println("Le client " + c1.getNom() + " a bien été enregistré !\n");
		listeClient.add(c1);
		
		
		
		main(null);
	}
	
	
	
	
	private static void afficherClient() {
		System.out.println("Liste des clients enregistrés : " + listeClient);
		System.out.print("Choisir l'id de la personne dont vous souhaitez afficher les informations : ");
		int findClient = sc.nextInt();		
		
		boolean isTrouver = false;
		for (int i = 0; i < listeClient.size() ; i++)
		{
			if (listeClient.get(i).getId() == findClient)
			{
				isTrouver = true;
				System.out.println(listeClient.get(i) + "\n");
			}
			
		}
		if (isTrouver == false)
		{
		System.out.println("Aucun client ne correspondant à cet id.");
		}
		
		main(null);
	}
	
	
	
	
	
	private static void afficherMedicament() {
		System.out.print("Voici la liste des Médicaments enregistrés : \n" + listeMedicament
				+ "1. Aspirine \n"
				+ "2. Doliprane \n"
				+ "3. Smecta \n"
				+ "4. Spasfon \n"
				+ "5. Efferalgan \n"
				+ "6. Dafalgan \n"
				+ "7. Advil \n\n");
		
		System.out.print("Insérez le numéro respectif du médicament dont vous souhaitez afficher les informations  : ");
		int idMedicament = sc.nextInt();
		
		boolean isTrouver = false;
		for (int i = 0; i < listeMedicament.size() ; i++)
		{
			if (listeMedicament.get(i).getId() == idMedicament)
			{
				isTrouver = true;
				System.out.println(listeMedicament.get(i) + "\n");
				}
			}
		if (isTrouver == false)
		{
		System.out.println("Aucune médicament ne correspondant à cet id.");
		}
		
		main(null);
	}
	
	
	
	
	private static void approvisionner() {
		System.out.println("Quel médicament souhaitez vous approvisionner : ");
		
		String findMedicament = sc.next();
		if(listeMedicament.contains(findMedicament))
		{
			System.out.println("ca marche !");
		}
		else
		{
			System.out.println("Le médicament renseigné n'existe pas !");
		}
		
		main(null);
	}
	
	
	
	
	private static void quitterApplication() {
		System.out.println("Fin de l'application !\n"
				+ "Merci d'avoir utilisé notre logiciel !\n"
				+ "A bientôt.");
	}

}
