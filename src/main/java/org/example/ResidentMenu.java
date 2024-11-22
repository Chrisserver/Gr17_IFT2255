package org.example;

import java.io.IOException;
import java.io.PrintStream;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class ResidentMenu {
    public ResidentMenu() {
    }


    public void afficherMenu(Scanner scanner) throws IOException {
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
                continue;
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
        ArrayList<ProjetTravaux> projets = MaVille.projets;
        LocalDate aujourdHui = LocalDate.now();
        LocalDate dansTroisMois = aujourdHui.plusMonths(3);
        int compteur = 1;

        Scanner scanner = new Scanner(System.in);
        ArrayList<ProjetTravaux> projetsFiltrables = new ArrayList<>();

        System.out.println("Travaux prévus dans les trois prochains mois :");
        for (ProjetTravaux projet : projets) {
            LocalDate dateFin = LocalDate.parse(projet.getDateFin(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            if (dateFin.isBefore(dansTroisMois) && dateFin.isAfter(aujourdHui)) {
                afficherUnProjet(projet, compteur++);
                projetsFiltrables.add(projet); // Ajouter aux projets filtrables
            }
        }

        if (compteur == 1) {
            System.out.println("Aucun projet prévu dans les trois prochains mois.");
            return;
        }
        int choix = -1;
        while(choix!=3){
        System.out.println("\nVoulez-vous filtrer les travaux ?");
        System.out.println("1. Par quartier");
        System.out.println("2. Par type de travaux");
        System.out.println("3. Retourner au menu principal");
        if(scanner.hasNextInt()){
        choix = scanner.nextInt();
        scanner.nextLine();// Consommer le saut de ligne
        }else{
            System.out.println("Veuillez entrer un nombre valide (1, 2 ou 3).");
            scanner.nextLine();// Consommer le saut de ligne
            continue;

        }

        switch (choix) {
            case 1:
                System.out.println("Quartiers disponibles :");
                for (String quartier : MaVille.quartiers) {
                    System.out.println("- " + quartier);
                }
                System.out.println("Entrez le nom du quartier à filtrer :");
                String quartierChoisi = scanner.nextLine();

                ArrayList<ProjetTravaux> travauxParQuartier = new ArrayList<>();
                for (ProjetTravaux projet : projetsFiltrables) {
                    if (projet.getQuartiersAffectes().contains(quartierChoisi)) {
                        travauxParQuartier.add(projet);
                    }
                }
                afficherTravauxFiltres(travauxParQuartier, "quartier : " + quartierChoisi);
                break;

            case 2:
                System.out.println("Types de travaux disponibles :");
                for (String type : MaVille.typeTravaux) {
                    System.out.println("- " + type);
                }
                System.out.println("Entrez le type de travaux à filtrer :");
                String typeChoisi = scanner.nextLine();

                ArrayList<ProjetTravaux> travauxParType = new ArrayList<>();
                for (ProjetTravaux projet : projetsFiltrables) {
                    if (projet.getTypeTravaux().equalsIgnoreCase(typeChoisi)) {
                        travauxParType.add(projet);
                    }
                }
                afficherTravauxFiltres(travauxParType, "type de travaux : " + typeChoisi);
                break;

            case 3:
                System.out.println("Retour au menu principal.");
                return;

            default:
                System.out.println("Choix invalide.");
        }
    }
    }

    // Méthode pour afficher les projets filtrés
    private void afficherTravauxFiltres(ArrayList<ProjetTravaux> travauxFiltres, String critere) {
        if (travauxFiltres.isEmpty()) {
            System.out.println("Aucun projet trouvé pour le critère " + critere + ".");
        } else {
            System.out.println("Travaux filtrés par " + critere + " :");
            int compteur = 1;
            for (ProjetTravaux projet : travauxFiltres) {
                afficherUnProjet(projet, compteur++);
            }
        }
    }

    public void consulterEntraves() {
        int count = 0;
        for(Entrave entrave:MaVille.entraves)
            this.afficherUneEntrave(entrave, count++);
        menuRechercheEntraves();
            }


    public void chercherEntravesParTravail(String idTravail) {
        boolean trouve = false;
        for (Entrave entrave : MaVille.entraves) {
            if (entrave.getIdRequest().equals(idTravail)) {
                this.afficherUneEntrave(entrave, -1); // Affiche l'entrave trouvée
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Aucune entrave associée au travail avec l'ID : " + idTravail);
        }
    }

    public void chercherEntravesParRue(String streetId) {
        boolean trouve = false;
        for (Entrave entrave : MaVille.entraves) {
            if (entrave.getStreetId().equalsIgnoreCase(streetId)) {
                this.afficherUneEntrave(entrave, -1); // Affiche l'entrave trouvée
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Aucune entrave trouvée pour la rue avec l'ID : " + streetId);
        }
    }
    public void menuRechercheEntraves() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Options de recherche d'entraves :");
            System.out.println("1. Rechercher par ID de travail");
            System.out.println("2. Rechercher par ID de rue");
            System.out.println("3. Retour au menu principal");
            int choix;
            if (scanner.hasNextInt()) {
                choix = scanner.nextInt();
                scanner.nextLine();// Consomme la nouvelle ligne
            } else {
                System.out.println("Veuillez entrer un nombre valide (1, 2 ou 3).");
                scanner.nextLine();// Consommer le saut de ligne
                continue;
            }

            switch (choix) {
                case 1:
                    System.out.println("Entrez l'ID du travail :");
                    String idTravail = scanner.nextLine();
                    chercherEntravesParTravail(idTravail);
                    break;
                case 2:
                    System.out.println("Entrez l'ID de la rue :");
                    String streetId = scanner.nextLine();
                    chercherEntravesParRue(streetId);
                    break;
                case 3:
                    return; // Quitte le sous-menu
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }



    private void soumettreRequete(Scanner scanner) throws IOException {
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
        String url = "http://localhost:7000/requetes";
        HttpResponse<String> response = HttpClientMaVille.post(url, json);
        if (response != null && response.statusCode() == 201) {
            System.out.println("Votre requête a été soumise avec succès.");
            // Mettre a jour les requetes du systeme
            MaVille.requetes = MaVille.chargerRequetesDepuisApi();
        } else {
            System.out.println("Erreur lors de la soumission de la requête.");
        }

    }

    private void rechercherTravaux(Scanner scanner) {
        System.out.println("Rechercher Travaux.....");
    }

    private static void signalerProbleme(Scanner scanner) {
        System.out.println("Signaler un Problème...");
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
