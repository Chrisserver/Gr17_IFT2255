package src;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaVille {

    public static void main(String[] args) throws IOException {
        ArrayList<Resident> residents = new ArrayList<>();
        ArrayList<Intervenant> intervenants = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        menu();

        while (true) {
            int choix = scanner.nextInt();
            scanner.nextLine(); // Capturer la ligne suivante
            switch (choix) {
                case 1:
                    // Inscription
                    System.out.println("Entrer rôle: Resident ou Intervenant \n Taper EXIT pour revenir au menu");
                    String role = scanner.nextLine();
                    if (role.equalsIgnoreCase("EXIT")) {
                        menu();
                        continue;
                    }

                    String courriel ="";
                    while(!validerCourriel(courriel)) {
                        System.out.println("Courriel:");
                        courriel= scanner.nextLine();
                        if(!validerCourriel(courriel)) {
                            System.out.println("Adresse courriel invalide. Réessayez.");
                        };
                    }

                    System.out.println("Mot de passe:");
                    String mdp = scanner.nextLine();

                    if (role.equalsIgnoreCase("Resident")) {
                        // Logique d'inscription pour Resident
                        System.out.println("Nom complet:");
                        String nom = scanner.nextLine();

                        System.out.println("Date de naissance (format: yyyy-MM-dd):");
                        String dateString = scanner.nextLine();
                        LocalDate dateNaissance = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                        System.out.println("Téléphone (optionnel):");
                        String telephone = scanner.nextLine();

                        System.out.println("Adresse résidentielle:");
                        String adresse = scanner.nextLine();

                        // Ajout du résident dans la liste
                        residents.add(new Resident(nom, courriel, mdp, dateNaissance, telephone, adresse));
                        System.out.println("Votre compte résident a été enregistré!");
                    } else if (role.equalsIgnoreCase("Intervenant")) {
                        // Logique d'inscription pour Intervenant
                        System.out.println("Nom complet:");
                        String nom = scanner.nextLine();

                        System.out.println("Type (Entreprise publique, Entrepreneur privé, Particulier):");
                        String type = scanner.nextLine();

                        System.out.println("Identifiant de la ville (code à 8 chiffres):");
                        String identifiantVille = scanner.nextLine();

                        // Ajout de l'intervenant dans la liste
                        intervenants.add(new Intervenant(nom, courriel, mdp, type, identifiantVille));
                        System.out.println("Votre compte intervenant a été enregistré!");
                    } else {
                        System.out.println("Rôle non reconnu. Veuillez réessayer.");
                    }

                    menu();
                    break;

                case 2:
                    // Connexion
                    System.out.println("Entrez votre adresse e-mail:");
                    String emailConnexion = scanner.nextLine();

                    System.out.println("Entrez votre mot de passe:");
                    String mdpConnexion = scanner.nextLine();

                    boolean connexionReussie = false;

                    // Vérifier les comptes résidents
                    for (Resident resident : residents) {
                        if (resident.getCourriel().equalsIgnoreCase(emailConnexion) && resident.getMotDePasse().equals(mdpConnexion)) {
                            System.out.println("Connexion réussie en tant que Resident!");
                            connexionReussie = true;
                            resident_menu(scanner);
                            break;
                        }
                    }

                    // Vérifier les comptes intervenants
                    if (!connexionReussie) {
                        for (Intervenant intervenant : intervenants) {
                            if (intervenant.getCourriel().equalsIgnoreCase(emailConnexion) && intervenant.getMotDePasse().equals(mdpConnexion)) {
                                System.out.println("Connexion réussie en tant qu'Intervenant!");
                                connexionReussie = true;
                                intervenant_menu(scanner);
                                break;
                            }
                        }
                    }

                    if (!connexionReussie) {
                        System.out.println("Échec de la connexion. Courriel ou mot de passe incorrect.");
                    }

                    menu();
                    break;

                case 3:
                    // Quitter l'application
                    System.out.println("Merci d'avoir utilisé MaVilleApp.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    menu();
                    break;
            }
        }
    }

    // Méthode pour valider l'adresse courriel
    public static boolean validerCourriel(String courriel) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(courriel);
        return matcher.matches();
    };


    // Affichage du menu principal
    public static void menu() {
        System.out.println("Bienvenue dans MaVille");
        System.out.println("Menu:");
        System.out.println("Choisir une option:");
        System.out.println("1. S'inscrire");
        System.out.println("2. Se connecter");
        System.out.println("3. Quitter l'application");
    }

    public static void resident_menu(Scanner scanner){
        int choice = 17;
        while(choice!=0){
            System.out.println("----Menu Résident---");
            System.out.print("Choisissez une option:");
            System.out.println("1. Consulter les travaux en cours ou à venir");
            System.out.println("2. Recevoir des notifications personnalisées");
            System.out.println("3. Soumettre une requête de travail ou signaler un problème");
            System.out.println("0. Se déconnecter");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Consultation des travaux en cours ou à venir...");
                    // Simulation de la consultation
                    break;
                case 2:
                    System.out.println("Configuration des notifications personnalisées...");
                    // Simulation de la configuration des notifications
                    break;
                case 3:
                    System.out.println("Soumission d'une requête ou signalement d'un problème...");
                    // Simulation de la soumission
                    break;
                case 0:
                    System.out.println("Déconnexion...");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
                    break;

            }}
    };
    public static void intervenant_menu(Scanner scanner){
        int choice = 17;
        while(choice!=0){
            System.out.println("--- Menu Intervenant ---");
            System.out.print("Choisissez une option:");
            System.out.println("1. Soumettre un nouveau projet de travaux");
            System.out.println("2. Mettre à jour les informations d'un chantier");
            System.out.println("3. Consulter la liste de requêtes de travail");
            System.out.println("0. Se déconnecter");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Soumettre un nouveau projet de travaux");
                    // Simulation de la consultation
                    break;
                case 2:
                    System.out.println("Mettre à jour les informations d'un chantier");
                    // Simulation de la configuration des notifications
                    break;
                case 3:
                    System.out.println("Consulter la liste de requêtes de travail");
                    // Simulation de la soumission
                    break;
                case 0:
                    System.out.println("Déconnexion...");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
                    break;

            }}
    };
}
