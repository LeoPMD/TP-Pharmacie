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

		menu();
	}

	static void menu() {

		System.out.println("***************************************************************** \n");
		System.out.println("Veuillez sélectionner le programme que vous souhaitez : \n" + "1. Effectuer un Achat \n"
				+ "2. Création d'un nouveau Client \n" + "3. Afficher le profil d'un Client \n"
				+ "4. Afficher un médicament et son stock \n" + "5. Approvisionner stock de médicament \n"
				+ "6. Fin de l'application \n");

		int key = sc.nextInt();
		switch (key) {
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
		System.out.println("Cet achat est pour : \n" + "1. Un client déjà existant ?\n" + "2. Un nouveau client ?\n"
				+ "3. Retourner au menu");

		int key = sc.nextInt();
		switch (key) {
		case 1:

			// CECI EST MA PREMIRE VERSION QUI FONCTIONNE !!!!!!
//			System.out.print("Veuillez renseigner le nom du client (avec une majuscule) : ");
//			String findClient = sc.next();
//			int prixPaye = 0;
//			int quantiteSouhaitee = 0;
//			
//			boolean verificationClient = false;
//			for (int i = 0; i < listeClient.size() ; i++)
//			{
//			
//				if(listeClient.get(i).getNom().contains(findClient))
//				{
//					verificationClient = true;
//					System.out.print("Renseignez le médicament acheté (avec une majuscule) : ");
//					
//					String findMedicament = sc.next();
//					boolean verificationMedicament = false;
//					for (int ii = 0; ii < listeMedicament.size() ; ii++)
//					{
//						if(listeMedicament.get(ii).getNom().contains(findMedicament))
//						{
//							verificationMedicament = true;
//							System.out.print("Renseignez la quantité souhaitée : ");
//							quantiteSouhaitee = sc.nextInt();
//							
//							if(quantiteSouhaitee > listeMedicament.get(ii).getStock())
//							{
//								System.out.println("Il n'y a pas assez de stock disponible pour ce médicament, retour vers le menu ...\n");
//								menu();
//							}
//							else
//							{
//								prixPaye += (listeMedicament.get(ii).getPrix() * quantiteSouhaitee);
//								listeMedicament.get(ii).setStock(listeMedicament.get(ii).getStock() - quantiteSouhaitee);
//								System.out.println("Le nouveau stock de " + listeMedicament.get(ii).getNom() + " est de : " + listeMedicament.get(ii).getStock() + "\n");
//							}
//						}
//					}
//					
//					
//					if (verificationMedicament == false)
//					{
//						System.out.println("Le médicament renseigné n'existe pas !");
//					}
//					
//					
//					if (verificationClient == true && verificationMedicament == true)
//					{
//						listeClient.get(i).setCredit(prixPaye += listeClient.get(i).getCredit());
//						System.out.println("Le client " + listeClient.get(i).getNom() +  " devra payer la somme de : " +  prixPaye + "€\n");
//					}
//					
//					
//					
//				}
//
//				
//			}
//			
//			if (verificationClient == false)
//			{
//				System.out.println("Le client renseigné n'est pas trouvable !\n");
//				System.out.println("Voulez vous créer ce nouveau client ");
//				effectuerAchat();
//
//			}
//			
//			break;

			// ******************************************************************************//

			// VOICI MA DEUXIEME METHODE QUI FONCTIONNE !!
			int prixPaye = 0;
			int quantiteSouhaitee = 0;

			Client client = Client.lireClient();
			Medicament medicament = Medicament.lireMedicament();

			System.out.print("Renseignez la quantité souhaitée : ");
			quantiteSouhaitee = sc.nextInt();

			prixPaye += (medicament.getPrix() * quantiteSouhaitee);
			medicament.setStock(medicament.getStock() - quantiteSouhaitee);
			System.out.println(
					"Le nouveau stock de " + medicament.getNom() + " est de : " + medicament.getStock() + "\n");

			client.setCredit(prixPaye += client.getCredit());
			System.out.println("Le client " + client.getNom() + " devra payer la somme de : " + prixPaye + "€ pour "
					+ quantiteSouhaitee + " " + medicament.getNom() + "\n");

			break;

		case 2:
			creationClient();
			effectuerAchat();
			break;

		case 3:
			menu();
			break;

		}

		menu();
	}

	private static void creationClient() {
		Client c1 = new Client();
		System.out.print("Veuillez renseigner le nom du client a enregistrer : ");
		c1.setNom(sc.next());
		System.out.println("Le client " + c1.getNom() + " a bien été enregistré !\n");
		listeClient.add(c1);

		menu();
	}

	private static void afficherClient() {
		System.out.println("Liste des clients enregistrés : " + listeClient);
		System.out.print("Choisir l'id de la personne dont vous souhaitez afficher les informations : ");
		int findClient = sc.nextInt();

		boolean isTrouver = false;
		for (int i = 0; i < listeClient.size(); i++) {
			if (listeClient.get(i).getId() == findClient) {
				isTrouver = true;
				System.out.println(listeClient.get(i) + "\n");
			}

		}
		if (isTrouver == false) {
			System.out.println("Aucun client ne correspondant à cet id.");
		}

		menu();
	}

	private static void afficherMedicament() {
		System.out.print("Voici la liste des Médicaments enregistrés : \n" + listeMedicament + "1. Aspirine \n"
				+ "2. Doliprane \n" + "3. Smecta \n" + "4. Spasfon \n" + "5. Efferalgan \n" + "6. Dafalgan \n"
				+ "7. Advil \n\n");

		System.out.print("Insérez le numéro respectif du médicament dont vous souhaitez afficher les informations  : ");
		int idMedicament = sc.nextInt();

		boolean isTrouver = false;
		for (int i = 0; i < listeMedicament.size(); i++) {
			if (listeMedicament.get(i).getId() == idMedicament) {
				isTrouver = true;
				System.out.println(listeMedicament.get(i).toString() + "\n");
			}
		}
		if (isTrouver == false) {
			System.out.println("Aucune médicament ne correspondant à cet id.");
		}

		menu();
	}

	private static void approvisionner() {
		System.out.println(
				"Renseignez le médicament souhaitez vous approvisionner (avec la première lettre en majuscule) : ");

		String findMedicament = sc.next();
		boolean verificationMedicament = false;
		for (int i = 0; i < listeMedicament.size(); i++) {

			if (listeMedicament.get(i).getNom().contains(findMedicament)) {
				verificationMedicament = true;
				System.out.print("Renseignez le stock que souhaitez ajouter : ");
				int stockAjout = sc.nextInt();
				listeMedicament.get(i).setStock(stockAjout += listeMedicament.get(i).getStock());

				System.out.println("Le stock a bien été ajouté !\n" + "Le nouveau stock pour le médicament "
						+ listeMedicament.get(i).getNom() + " est de : " + listeMedicament.get(i).getStock() + "\n");
			}

		}

		if (verificationMedicament == false) {
			System.out.println("Le médicament renseigné n'existe pas !");
		}

		menu();
	}

	private static void quitterApplication() {
		System.out.println("Fin de l'application !\n" + "Merci d'avoir utilisé notre logiciel !\n" + "A bientôt.");
	}

}
