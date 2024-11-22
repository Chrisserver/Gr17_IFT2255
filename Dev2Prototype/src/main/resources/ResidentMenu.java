package org.example;

import java.io.PrintStream;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

public class ResidentMenu {
    public ResidentMenu() {
    }

    public void afficherMenu(Scanner scanner) {
        int choice = -1;

        while(choice != 0) {
            System.out.println("----Menu Résident---");
            System.out.println("Choisissez une option:");
            System.out.println("1. Consulter les travaux en cours ou à venir");
            System.out.println("2.Consulter les entraves associées aux travaux en cours");
            System.out.println("3. Rechercher des travaux");
            System.out.println("4. Recevoir des notifications personnalisées");
            System.out.println("5. Soumettre une requête de travail");
            System.out.println("6. Signaler un problème à la ville");
            System.out.println("0. Se déconnecter");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Veuillez entrer un nombre valide (1, 2 ou 3).");
                scanner.nextLine();
            }

            switch (choice) {
                case 1:
                    this.consulterTravaux();
                    break;
                case 2:
                    this.consulterEntraves();
                    break;
                case 3:
                    this.rechercherTravaux(scanner);
                    break;
                case 4:
                    this.recevoirNotifs();
                    break;
                case 5:
                    this.soumettreRequete(scanner);
                    break;
                case 6:
                    signalerProbleme(scanner);
                    break;
                case 7:
                    System.out.println("Déconnexion...");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }

    }

    private void consulterTravaux() {
        String resourceId = "cc41b532-f12d-40fb-9f55-eb58c9a2b12b";
        HttpClientApi clientApi = new HttpClientApi();
        ApiResponse response = clientApi.getData(resourceId);
        if (response != null && response.getStatusCode() == 200) {
            String responseBody = response.getBody();
            JSONObject jsonResponse = new JSONObject(responseBody);
            JSONArray records = jsonResponse.getJSONObject("result").getJSONArray("records");
            LocalDate aujourdHui = LocalDate.now();
            LocalDate dansTroisMois = aujourdHui.plusMonths(3L);
            int compteur = 1;

            for(int i = 0; i < records.length(); ++i) {
                JSONObject projetJson = records.getJSONObject(i);
                String dateFinString = projetJson.optString("duration_end_date", "Non spécifié").substring(0, 10);
                LocalDate dateFin = LocalDate.parse(dateFinString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                if (dateFin.isBefore(dansTroisMois) && dateFin.isAfter(aujourdHui)) {
                    String var10000 = projetJson.optString("reason_category", "Non spécifié");
                    String titre = var10000 + " situé à " + projetJson.getString("boroughid");
                    String typeTravaux = projetJson.optString("reason_category", "Non spécifié");
                    String quartier = projetJson.optString("boroughid", "Non spécifié");
                    String rue = projetJson.optString("streetid", "Non spécifié");
                    String intervenant = projetJson.optString("organizationname", "Non spécifié");
                    String statut = projetJson.optString("currentstatus", "Non spécifié");
                    String categorie = projetJson.optString("submittercategory", "Non spécifié");
                    String description = "Type de travaux : " + typeTravaux + ", Quartier : " + quartier + ", Rues affectées : " + rue + ", Intervenant : " + intervenant + ", Statut actuel : " + statut + ", Catégorie : " + categorie;
                    ArrayList<String> quartiersAffectes = new ArrayList();
                    quartiersAffectes.add(quartier);
                    ArrayList<String> ruesAffectees = new ArrayList();
                    ruesAffectees.add(rue);
                    ProjetTravaux projet = new ProjetTravaux(projetJson.getString("id"), titre, description, typeTravaux, quartiersAffectes, ruesAffectees, projetJson.optString("duration_start_date", "Non spécifié").substring(0, 10), dateFinString, projetJson.optString("work_schedule", "Non spécifié"));
                    this.afficherUnProjet(projet, compteur++);
                }
            }

            if (compteur == 1) {
                System.out.println("Aucun projet prévu dans les trois prochains mois.");
            }
        } else {
            System.out.println("Erreur lors de la récupération des projets de travaux : " + response.getMessage());
        }

    }

    public void consulterEntraves() {
        String resourceId = "a2bc8014-488c-495d-941b-e7ae1999d1bd";
        HttpClientApi clientApi = new HttpClientApi();
        ApiResponse response = clientApi.getData(resourceId);
        if (response != null && response.getStatusCode() == 200) {
            String responseBody = response.getBody();
            JSONObject jsonResponse = new JSONObject(responseBody);
            JSONArray records = jsonResponse.getJSONObject("result").getJSONArray("records");
            int count = 1;

            for(int i = 0; i < records.length(); ++i) {
                JSONObject entraveJson = records.getJSONObject(i);
                Entrave entrave = new Entrave(entraveJson.getString("id_request"), entraveJson.getString("streetid"), entraveJson.getString("shortname"), entraveJson.getString("streetimpacttype"));
                this.afficherUneEntrave(entrave, count++);
            }
        } else {
            System.out.println("Erreur lors de la récupération des entraves : " + response.getMessage());
        }

    }

    private void soumettreRequete(Scanner scanner) {
        System.out.println("Soumettre une requête de travail:");
        System.out.print("Titre: ");
        String titre = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.println("Quel Type de travaux?");
        String type = scanner.nextLine();
        String dateDebut = "";
        boolean validDate = false;

        while(!validDate) {
            System.out.println("Date debut (YYYY-MM-DD):");
            dateDebut = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            try {
                LocalDate.parse(dateDebut, formatter);
                validDate = true;
            } catch (DateTimeParseException var11) {
                System.out.println("Date invalide. Veuillez entrer une date au format YYYY-MM-DD.");
            }
        }

        RequeteTravail requete = new RequeteTravail(titre, description, type, dateDebut);
        String json = String.format("{\"titre\": \"%s\", \"description\": \"%s\", \"type\": \"%s\", \"dateDebut\": \"%s\"}", requete.getTitreTravail(), requete.getDescriptionDetaillee(), requete.getTypeTravaux(), requete.getDateDebutEsperee());
        String url = "http://localhost:7002/requetes";
        HttpResponse<String> response = HttpClientMaVille.post(url, json);
        if (response != null && response.statusCode() == 201) {
            System.out.println("Votre requête a été soumise avec succès.");
        } else {
            System.out.println("Erreur lors de la soumission de la requête.");
        }

    }

    private void rechercherTravaux(Scanner scanner) {
        System.out.println("Rechercher Travaux.....");
    }

    private static void signalerProbleme(Scanner scanner) {
        System.out.print("Nom du résident : ");
        String nomResident = scanner.nextLine();
        System.out.print("Adresse courriel : ");
        String adresseCourriel = scanner.nextLine();
        System.out.print("Adresse de résidence : ");
        String adresseResidence = scanner.nextLine();
        System.out.print("Type de problème : ");
        String typeProbleme = scanner.nextLine();
        System.out.print("Description du problème : ");
        String descriptionProbleme = scanner.nextLine();
        Probleme probleme = new Probleme(nomResident, adresseCourriel, adresseResidence, typeProbleme, descriptionProbleme);
        System.out.println("\nProblème signalé :");
        System.out.println(probleme.toString());
    }

    public void recevoirNotifs() {
        System.out.println("Recevoir Notifications.....");
    }

    public void afficherUnProjet(ProjetTravaux projet, int id) {
        System.out.println("--- Projet " + id + " ---");
        System.out.println("Titre : " + projet.getTitre());
        System.out.println("Description : " + projet.getDescription());
        System.out.println("Quartiers affectés : " + String.join(", ", projet.getQuartiersAffectes()));
        System.out.println("Rues affectées : " + String.join(", ", projet.getRuesAffectees()));
        PrintStream var10000 = System.out;
        String var10001 = projet.getDateDebut();
        var10000.println("Dates : " + var10001 + " au " + projet.getDateFin());
        System.out.println("Type de travaux : " + projet.getTypeTravaux());
        System.out.println("Horaire des travaux : " + projet.getHoraireTravaux());
    }

    public void afficherUneEntrave(Entrave entrave, int count) {
        System.out.println("--- Entrave " + count + " ---");
        System.out.println("Rue : " + entrave.getShortName());
        System.out.println("Type d'impact : " + entrave.getStreetImpactType());
        System.out.println("ID de la rue : " + entrave.getStreetId());
        System.out.println("Identifiant de travail du projet lié : " + entrave.getIdRequest());
    }
}
