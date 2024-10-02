package src;

import java.util.ArrayList;
import java.util.Scanner;

public class ResidentMenu {
    private ArrayList<RequeteTravail> requetes;
    private ArrayList<ProjetTravaux> travaux;

    public ResidentMenu(ArrayList<ProjetTravaux> travaux) {
        this.requetes = new ArrayList<>();
        this.travaux = travaux;
    }

    public void afficherMenu(Scanner scanner) {
        int choice = -1;
        while (choice != 0) {
            System.out.println("----Menu Résident---");
            System.out.println("Choisissez une option:");
            System.out.println("1. Consulter les travaux en cours ou à venir");
            System.out.println("2. Recevoir des notifications personnalisées");
            System.out.println("3. Soumettre une requête de travail");
            System.out.println("4. Signaler un problème à la ville");
            System.out.println("0. Se déconnecter");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne restante

            switch (choice) {
                case 1:
                    consulterTravaux();
                    break;
                case 2:
                    System.out.println("Recevoir notifications personalisées");
                    break;
                case 3:
                    soumettreRequete(scanner);
                    break;
                case 4:
                    System.out.println("Signaler un problème à a ville");
                    break;
                case 0:
                    System.out.println("Déconnexion...");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
                    break;
            }
        }
    }

    private void consulterTravaux() {
        if (travaux.isEmpty()) {
            System.out.println("Aucun travaux en cours ou à venir.");
        } else {
            for (ProjetTravaux projet : travaux) {
                System.out.println(projet);
            }
        }
    }


    private void soumettreRequete(Scanner scanner) {
        System.out.println("Soumettre une requête de travail:");
        System.out.print("Titre: ");
        String titre = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.println("Type:\n Les types possibles de travaux sont :" +
                "\nTravaux routiers " +
                "\nTravaux de gaz ou électricité" +
                "\nConstruction ou rénovation" +
                "\nEntretien paysager" +
                "\nTravaux liés aux transports en commun" +
                "\nTravaux de signalisation et éclairage" +
                "\nTravaux souterrains" +
                "\nTravaux résidentiels" +
                "\nEntretien urbain" +
                "\nEntretien des réseaux de télécommunication");
        String type = scanner.nextLine();
        System.out.println("Date debut:(YYYY-MM-DD)");
        String dateDebut = scanner.nextLine();
        RequeteTravail requete = new RequeteTravail(titre, description,type,dateDebut);
        requetes.add(requete);
        System.out.println("Votre requête a été soumise.");
    }

}
