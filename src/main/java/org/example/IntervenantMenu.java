package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class IntervenantMenu {
    private ArrayList<RequeteTravail> requetes = MaVille.requetes;  // Utilisation de la liste requetes depuis MaVille

    public IntervenantMenu() {
    }

    public void afficherMenu(Scanner scanner) {
        int choice = -1;

        while (choice != 0) {
            System.out.println("--- Menu Intervenant ---");
            System.out.println("Choisissez une option:");
            System.out.println("1. Soumettre un nouveau projet de travaux");
            System.out.println("2. Mettre à jour les informations d'un chantier");
            System.out.println("3. Consulter la liste de requêtes de travail");
            System.out.println("0. Se déconnecter");

            // Vérification du choix utilisateur
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();  // Consommer le retour à la ligne
            } else {
                System.out.println("Veuillez entrer un nombre valide (1, 2 ,3 ou 0).");
                scanner.nextLine();  // Consommer l'entrée invalide
                continue;
            }

            switch (choice) {
                case 0:
                    System.out.println("Déconnexion...");
                    break;
                case 1:
                    this.soumettreProjet(scanner);
                    break;
                case 2:
                    this.mettreAJourChantier(scanner);
                    break;
                case 3:
                    this.consulterRequetes();
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

    private void soumettreProjet(Scanner scanner) {
        System.out.println("SoumettreProjet....");
    }
    private void consulterRequetes() {
        System.out.println("Consulter les requêtes de travail:");

        // Vérification si la liste est vide
        if (requetes.isEmpty()) {
            System.out.println("Aucune requête de travail disponible.");
        } else {
            int compteur = 1;
            for (RequeteTravail requete : requetes) {
                System.out.println("---- Requête " + compteur++ + " ----");
                System.out.println("Titre : " + requete.getTitreTravail());
                System.out.println("Description : " + requete.getDescriptionDetaillee());
                System.out.println("Type de travaux : " + requete.getTypeTravaux());
                System.out.println("Date début : " + requete.getDateDebutEsperee());
                System.out.println();
            }
        }
    }

    public void mettreAJourChantier(Scanner scanner){
       System.out.println("Mettre a jour Chantier.....");
    };

}
