

import java.util.ArrayList;
import java.util.Scanner;

public class ResidentMenu {
    private ArrayList<RequeteTravail> requetes;
    private ProjectManager ProjectManager = new ProjectManager();

    private static ArrayList<Notification> notifications = new ArrayList<Notification>();
    public ResidentMenu(ArrayList<RequeteTravail> requetes) {
        this.requetes = requetes;
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
            //scanner.nextLine(); // Consommer la ligne restante

            switch (choice) {
                case 1:
                    consulterTravaux();
                    break;
                case 2:
                    rechercherTravaux(scanner);
                    break;
                case 3:
                    recevoirNotifs();
                    break;// envoi tous es changements d'infos de chantier et informations sur nouveaux projet soumiss
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
        if (ProjectManager.getProjets().isEmpty()) {
            System.out.println("Aucun travaux en cours ou à venir.");
        } else {
            for (ProjetTravaux projet : ProjectManager.getProjets()) {
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
                for(ProjetTravaux projet: ProjectManager.getProjets()){
                    if(projet.getTitre().equalsIgnoreCase(titre)){
                        System.out.println(projet.toString());
                    }
                }
            case 2:
               for(String typeTravaux: ProjectManager.get)
                String type = scanner.nextLine();
                for(ProjetTravaux projet: ProjectManager.getProjets()){
                    if(projet.getTypeTravaux().equalsIgnoreCase(type)){
                        System.out.println(projet.toString());
                    }
                }
            case 3:
                System.out.println("Quel Quartier ou arrondissement?\nVoici ceux disponibles:\n1.Ahuntsic-Cartierville +\n" +
                        "    \"2.Anjou\\n\" +\n" +
                        "    \"3.Côte-des-Neiges–Notre-Dame-de-Grâce\\n\" +\n" +
                        "    \"4.Lachine\\n\" +\n" +
                        "    \"5.LaSalle\\n\" +\n" +
                        "    \"6.Le Plateau-Mont-Royal\\n\" +\n" +
                        "    \"7.Le Sud-Ouest\\n\" +\n" +
                        "    \"8.L'Île-Bizard–Sainte-Geneviève\\n\" +\n" +
                        "    \"9.Mercier–Hochelaga-Maisonneuve\\n\" +\n" +
                        "    \"10.Montréal-Nord\\n\" +\n" +
                        "    \"11.Outremont\\n\" +\n" +
                        "    \"12.Pierrefonds-Roxboro\\n\" +\n" +
                        "    \"13.Rivière-des-Prairies–Pointe-aux-Trembles\\n\" +\n" +
                        "    \"14.Rosemont–La Petite-Patrie\\n\" +\n" +
                        "    \"15.Saint-Laurent\\n\" +\n" +
                        "    \"16.Saint-Léonard\\n\" +\n" +
                        "    \"17.Verdun\\n\" +\n" +
                        "    \"18.Ville-Marie\\n\" +\n" +
                        "    \"19.Villeray–Saint-Michel–Parc-Extension\"");
                String quartier = scanner.nextLine();
                for(ProjetTravaux projet: ProjectManager.getProjets()){
                        if(projet.getQuartierAffectes.contains(quartier)){
                        System.out.println(projet.toString());
                    }
                    }

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
        return ProjectManager.getProjets();
    }

    public ArrayList<RequeteTravail> getRequetes() {
        return requetes;
    }
}
