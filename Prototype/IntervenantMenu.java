package src;

import java.util.ArrayList;
import java.util.Scanner;

public class IntervenantMenu {
    private ArrayList<RequeteTravail> requetes;
    private ArrayList<ProjetTravaux> travaux;

    private ArrayList<Notification> new_notifications = ResidentMenu.getNotifications();


    public IntervenantMenu(ArrayList<ProjetTravaux> travaux,ArrayList<RequeteTravail> requetes) {
        this.requetes =requetes;
        this.travaux = travaux;
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
            choice = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne restante

            switch (choice) {
                case 1:
                    soumettreProjet(scanner);
                    break;
                case 2:
                    mettreAJourChantier(scanner);
                    break;
                case 3:
                    consulterRequetes();
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

    private void soumettreProjet(Scanner scanner) {
        System.out.println("Titre du projet:");
        String titre = scanner.nextLine();

        System.out.println("Description du projet:");
        String description = scanner.nextLine();

        System.out.println("Type de travaux:");
        String typeTravaux = scanner.nextLine();

        ArrayList<String> quartiersAffectes = new ArrayList<>();
        System.out.println("Entrez les quartiers affectés (tapez 'fin' pour terminer):");
        while (true) {
            String quartier = scanner.nextLine();
            if (quartier.equalsIgnoreCase("fin")) {
                break;
            }
            quartiersAffectes.add(quartier);
        };


        ArrayList<String> ruesAffectees = new ArrayList<>();
        System.out.println("Entrez les rues affectées (tapez 'fin' pour terminer):");
        while (true) {
            String rue = scanner.nextLine();
            if (rue.equalsIgnoreCase("fin")) {
                break;
            }
            ruesAffectees.add(rue);
        };
        System.out.print("Date de début(AAAA-MM-JJ):");
        String dateDebut=scanner.nextLine();

        System.out.print("Date de fin(AAAA-MM-JJ):");
        String dateFin=scanner.nextLine();

        System.out.print("Horaire des travaux:");
        String horaireTravaux=scanner.nextLine();

        // Ajouter le projet de travaux
        ProjetTravaux nouveauProjet = new ProjetTravaux(titre, description, typeTravaux, quartiersAffectes, ruesAffectees,dateDebut,dateFin,horaireTravaux);
        travaux.add(nouveauProjet);
        String msgNotif = "Projet ajouté\nInformations sur le projet:\n"+nouveauProjet.toString();
        Notification notification = new Notification(msgNotif);
        new_notifications.add(notification);
        ResidentMenu.setNotifications(new_notifications);

    }

    private void mettreAJourChantier(Scanner scanner) {
        if (travaux.isEmpty()) {
            System.out.println("Aucun chantier disponible pour mise à jour.");
            return;
        }

        System.out.println("Choisissez un chantier à mettre à jour:");
        // liste des travaux
        for (int i = 0; i < travaux.size(); i++) {
            System.out.println((i + 1) + ". " + travaux.get(i).getTitre());
        }

        int choixChantier = scanner.nextInt() - 1;// rentrer numéro pour choisir le chantier à mettre à jour
        scanner.nextLine();

        if (choixChantier >= 0 && choixChantier < travaux.size()) {
            ProjetTravaux projet = travaux.get(choixChantier);

            System.out.println("Nouveau titre (laissez vide pour ne pas changer):");
            String nouveauTitre = scanner.nextLine();
            if (!nouveauTitre.isEmpty()) {
                projet.setTitre(nouveauTitre);
            }

            System.out.println("Nouvelle description (laissez vide pour ne pas changer):");
            String nouvelleDescription = scanner.nextLine();
            if (!nouvelleDescription.isEmpty()) {
                projet.setDescription(nouvelleDescription);
            }
            String msgNotif = "Chantier mise à jour\nNouveaux informations du chantier:\n"+ projet.toString();
            Notification notification = new Notification(msgNotif);
            new_notifications.add(notification);
            ResidentMenu.setNotifications(new_notifications);
        } else {
            System.out.println("Chantier invalide.");
        }
    }

    private void consulterRequetes() {
        if (requetes.isEmpty()) {
            System.out.println("Aucune requête de travail disponible.");
        } else {
            for (RequeteTravail requete : requetes) {
                System.out.println(requete.toString());
            }
        }
    }

    public ArrayList<RequeteTravail> getRequetes() {
        return requetes;
    }
}
