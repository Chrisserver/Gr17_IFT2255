

import java.io.BufferedWriter;
import java.io.FileWriter;
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

                    menu();// Pour rester connecter à l'appli et l'acceuil
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
                            ResidentMenu residentMenu = new ResidentMenu(Travaux,requetes);
                            residentMenu.afficherMenu(scanner);
                            break;
                        }
                    }

                    // Vérifier les comptes intervenants
                    if (!connexionReussie) {
                        for (Intervenant intervenant : intervenants) {
                            if (intervenant.getCourriel().equalsIgnoreCase(emailConnexion) && intervenant.getMotDePasse().equals(mdpConnexion)) {
                                System.out.println("Connexion réussie en tant qu'Intervenant!");
                                connexionReussie = true;
                                IntervenantMenu intervenantMenu = new IntervenantMenu(requetes);
                                intervenantMenu.afficherMenu(scanner);
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
    // source: https://stackoverflow.com/questions/8204680/java-regex-email
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



    /*public static void saveResidentAsText(ArrayList<Resident> residents) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("residents.txt"))) {
            for (Resident resident : residents) {
                writer.write(resident.getNomComplet()+","+resident.getCourriel()+","+resident.getMotDePasse()+","+resident.getDateDeNaissance()+","+resident.getTelephone()+","+resident.getAdresseResidentielle());
                writer.newLine(); // Ajouter un saut de ligne entre chaque utilisateur
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    };
    public static void saveIntervenantAsText(ArrayList<Intervenant> intervenants) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("intervenants.txt"))) {
            for (Intervenant intervenant : intervenants) {
                writer.write(intervenant.getNomComplet()+","+intervenant.getCourriel()+","+intervenant.getMotDePasse()+","+intervenant.getType()+","+intervenant.getIdentifiantVille());
                writer.newLine(); // Ajouter un saut de ligne entre chaque utilisateur
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
