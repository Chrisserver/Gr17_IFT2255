package org.example;

import java.net.http.HttpResponse;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

public class IntervenantMenu {
    public IntervenantMenu() {
    }

    public void afficherMenu(Scanner scanner) {
        int choice = -1;

        while(choice != 0) {
            System.out.println("--- Menu Intervenant ---");
            System.out.println("Choisissez une option:");
            System.out.println("1. Soumettre un nouveau projet de travaux");
            System.out.println("2. Mettre à jour les informations d'un chantier");
            System.out.println("3. Consulter la liste de requêtes de travail");
            System.out.println("0. Se déconnecter");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Veuillez entrer un nombre valide (1, 2 ou 3).");
                scanner.nextLine();
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
        System.out.println("Soumettre Projet...");
    }

    private void mettreAJourChantier(Scanner scanner) {
        System.out.println("Mettre à jour Chantier");
    }

    private void consulterRequetes() {
        System.out.println("Consulter les requêtes de travail:");
        String url = "http://localhost:7002/requetes";
        HttpResponse<String> response = HttpClientMaVille.get(url);
        if (response != null && response.statusCode() == 200) {
            String responseBody = (String)response.body();
            JSONArray requetesArray = new JSONArray(responseBody);
            if (requetesArray.length() == 0) {
                System.out.println("Aucune requête de travail disponible.");
            } else {
                int compteur = 1;

                for(int i = 0; i < requetesArray.length(); ++i) {
                    JSONObject requeteJson = requetesArray.getJSONObject(i);
                    String titre = requeteJson.getString("titre");
                    String description = requeteJson.getString("description");
                    String type = requeteJson.getString("type");
                    String dateDebut = requeteJson.getString("dateDebut");
                    RequeteTravail requete = new RequeteTravail(titre, description, type, dateDebut);
                    int var10001 = compteur++;
                    System.out.println("---- Requête " + var10001 + " ----");
                    System.out.println("Titre : " + requete.getTitreTravail());
                    System.out.println("Description : " + requete.getDescriptionDetaillee());
                    System.out.println("Type de travaux : " + requete.getTypeTravaux());
                    System.out.println("Date début : " + requete.getDateDebutEsperee());
                    System.out.println();
                }
            }
        } else {
            System.out.println("Erreur lors de la récupération des requêtes.");
        }

    }
}
