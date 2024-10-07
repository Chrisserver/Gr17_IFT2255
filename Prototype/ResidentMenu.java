package src;

import java.util.ArrayList;
import java.util.Scanner;

public class ResidentMenu {
    private ArrayList<RequeteTravail> requetes;
    private ArrayList<ProjetTravaux> travaux;

    private static ArrayList<Notification> notifications;
    public ResidentMenu(ArrayList<ProjetTravaux> travaux,ArrayList<RequeteTravail> requetes) {
        this.requetes = requetes;
        this.travaux = travaux;
    }

    public static ArrayList<Notification> getNotifications() {
        return notifications;
    }

    public static void setNotifications(ArrayList<Notification> notifications) {
        ResidentMenu.notifications = notifications;
    }

    public void afficherMenu(Scanner scanner) {
        int choice = -1;
        while (choice != 0) {
            System.out.println("----Menu Résident---");
            System.out.println("Choisissez une option:");
            System.out.println("1. Consulter les travaux en cours ou à venir");
            System.out.println("2. Rechercher des travaux");
            System.out.println("3. Recevoir des notifications personnalisées");
            System.out.println("4. Soumettre une requête de travail");
            System.out.println("5. Signaler un problème à la ville");
            System.out.println("0. Se déconnecter");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne restante

            switch (choice) {
                case 1:
                    consulterTravaux();
                    break;
                case 2:
                    rechercherTravaux(scanner);
                    break;
                case 3:
                    recevoirNotifs();// envoi tous es changements d'infos de chantier et informations sur nouveaux projet soumiss
                case 4:
                    soumettreRequete(scanner);
                    break;
                case 5:
                    signalerProbleme(scanner);
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

    private void rechercherTravaux(Scanner scanner){
        System.out.println("Choisissez un filtre pour rechercher travaux:\n1.titre\n2.Type travaux\n3.Quartier");
        int choix = scanner.nextInt();
        switch (choix){
            case 1:
                System.out.println("Quel titre?");
                String titre = scanner.nextLine();
                for(ProjetTravaux projet: travaux){
                    if(projet.getTitre().equalsIgnoreCase(titre)){
                        System.out.println(projet.toString());
                    }
                }
            case 2:
                System.out.println("Quel type de travaux?:\nTravaux routiers\n–" +
                        "\nTravaux de gaz ou électricité\n–" +
                        "\nConstruction ou rénovation\n–" +
                        "\nEntretien paysager\n–" +
                        "\nTravaux liés aux transports en commun\n–" +
                        "\nTravaux de signalisation et éclairage\n–" +
                        "\nTravaux souterrains" +
                        "\n–" +
                        "\nTravaux résidentiel" +
                        "\n–" +
                        "\nEntretien urbain\n–" +
                        "\nEntretien des réseaux de télécommunication");
                String type = scanner.nextLine();
                for(ProjetTravaux projet: travaux){
                    if(projet.getTypeTravaux().equalsIgnoreCase(type)){
                        System.out.println(projet.toString());
                    }
                }
            case 3:
                System.out.println("Quel Quartier ou arrondissement?\nAhuntsic-Cartierville +\n" +
                        "    \"Anjou\\n\" +\n" +
                        "    \"Côte-des-Neiges–Notre-Dame-de-Grâce\\n\" +\n" +
                        "    \"Lachine\\n\" +\n" +
                        "    \"LaSalle\\n\" +\n" +
                        "    \"Le Plateau-Mont-Royal\\n\" +\n" +
                        "    \"Le Sud-Ouest\\n\" +\n" +
                        "    \"L'Île-Bizard–Sainte-Geneviève\\n\" +\n" +
                        "    \"Mercier–Hochelaga-Maisonneuve\\n\" +\n" +
                        "    \"Montréal-Nord\\n\" +\n" +
                        "    \"Outremont\\n\" +\n" +
                        "    \"Pierrefonds-Roxboro\\n\" +\n" +
                        "    \"Rivière-des-Prairies–Pointe-aux-Trembles\\n\" +\n" +
                        "    \"Rosemont–La Petite-Patrie\\n\" +\n" +
                        "    \"Saint-Laurent\\n\" +\n" +
                        "    \"Saint-Léonard\\n\" +\n" +
                        "    \"Verdun\\n\" +\n" +
                        "    \"Ville-Marie\\n\" +\n" +
                        "    \"Villeray–Saint-Michel–Parc-Extension\"");
        }
    };


        // Méthode pour signaler un problème
        public static void signalerProbleme(Scanner scanner) {
            // Recueillir les informations auprès du résident
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

            // Créer un nouvel objet Probleme avec les informations saisies
            Probleme probleme = new Probleme(nomResident, adresseCourriel, adresseResidence, typeProbleme, descriptionProbleme);

            // Afficher les détails du problème signalé
            System.out.println("\nProblème signalé :");
            System.out.println(probleme.toString());
        }


    public void recevoirNotifs(){
        for(Notification notif: notifications){
            System.out.println(notif.toString());
        }
    };
    public ArrayList<ProjetTravaux> getTravaux() {
        return travaux;
    }

    public ArrayList<RequeteTravail> getRequetes() {
        return requetes;
    }
}
