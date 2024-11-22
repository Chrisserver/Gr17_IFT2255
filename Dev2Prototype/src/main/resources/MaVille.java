package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaVille {
    public static ArrayList<Resident> residents = new ArrayList();
    public static ArrayList<Intervenant> intervenants = new ArrayList();

    public MaVille() {
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Resident> residents = chargerResidentsDepuisJson("src/main/resources/Residents.json");
        ArrayList<Intervenant> intervenants = chargerIntervenantsDepuisJson("src/main/resources/Intervenants.json");
        ArrayList<RequeteTravail> requetesTravail = chargerRequetesTravailDepuisJson("src/main/resources/requetes.json");
        Scanner scanner = new Scanner(System.in);
        menu();

        while(true) {
            while(true) {
                int choix = -1;
                if (scanner.hasNextInt()) {
                    choix = scanner.nextInt();
                } else {
                    System.out.println("Veuillez entrer un nombre valide (1, 2 ou 3).");
                    scanner.nextLine();
                }

                scanner.nextLine();
                String emailConnexion;
                String mdpConnexion;
                switch (choix) {
                    case 1:
                        System.out.println("Entrer rôle: Resident ou Intervenant \n Taper EXIT pour revenir au menu");
                        String role = scanner.nextLine();
                        if (role.equalsIgnoreCase("EXIT")) {
                            menu();
                            break;
                        }

                        String courriel = "";

                        while(!validerCourriel(courriel)) {
                            System.out.println("Courriel:");
                            courriel = scanner.nextLine();
                            if (!validerCourriel(courriel)) {
                                System.out.println("Adresse courriel invalide. Réessayez.");
                            }
                        }

                        System.out.println("Mot de passe (au moins 8 caractères, une lettre majuscule, et un chiffre):");
                        String mdp = "";

                        while(!validerMotDePasse(mdp)) {
                            mdp = scanner.nextLine();
                            if (!validerMotDePasse(mdp)) {
                                System.out.println("Mot de passe invalide. Assurez-vous qu'il contient au moins 8 caractères, une lettre majuscule, et un chiffre.");
                            }
                        }

                        String nom;
                        if (role.equalsIgnoreCase("Resident")) {
                            System.out.println("Nom complet:");
                            nom = scanner.nextLine();
                            System.out.println("Date de naissance (format: yyyy-MM-dd):");
                            emailConnexion = scanner.nextLine();
                            System.out.println("Téléphone (optionnel):");
                            mdpConnexion = scanner.nextLine();
                            System.out.println("Adresse résidentielle:");
                            String adresse = scanner.nextLine();
                            residents.add(new Resident(nom, courriel, mdp, emailConnexion, mdpConnexion, adresse));
                            System.out.println("Votre compte résident a été enregistré!");
                        } else if (role.equalsIgnoreCase("Intervenant")) {
                            System.out.println("Nom complet:");
                            nom = scanner.nextLine();
                            System.out.println("Type (Entreprise publique, Entrepreneur privé, Particulier):");
                            emailConnexion = scanner.nextLine();
                            System.out.println("Identifiant de la ville (code à 8 chiffres):");
                            mdpConnexion = scanner.nextLine();
                            intervenants.add(new Intervenant(nom, courriel, mdp, emailConnexion, mdpConnexion));
                            System.out.println("Votre compte intervenant a été enregistré!");
                        } else {
                            System.out.println("Rôle non reconnu. Veuillez réessayer.");
                        }

                        menu();
                        break;
                    case 2:
                        boolean connexionReussie = false;

                        while(!connexionReussie) {
                            System.out.println("Entrez votre adresse e-mail (ou tapez 'EXIT' pour quitter) :");
                            emailConnexion = scanner.nextLine();
                            if (emailConnexion.equalsIgnoreCase("EXIT")) {
                                System.out.println("Retour au menu.");
                                menu();
                                break;
                            }

                            System.out.println("Entrez votre mot de passe :");
                            mdpConnexion = scanner.nextLine();
                            Iterator var12 = residents.iterator();

                            while(var12.hasNext()) {
                                Resident resident = (Resident)var12.next();
                                if (resident.getCourriel().equalsIgnoreCase(emailConnexion) && resident.getMotDePasse().equals(mdpConnexion)) {
                                    System.out.println("Connexion réussie en tant que Resident!");
                                    connexionReussie = true;
                                    ResidentMenu residentMenu = new ResidentMenu();
                                    residentMenu.afficherMenu(scanner);
                                    break;
                                }
                            }

                            if (!connexionReussie) {
                                var12 = intervenants.iterator();

                                while(var12.hasNext()) {
                                    Intervenant intervenant = (Intervenant)var12.next();
                                    if (intervenant.getCourriel().equalsIgnoreCase(emailConnexion) && intervenant.getMotDePasse().equals(mdpConnexion)) {
                                        System.out.println("Connexion réussie en tant qu'Intervenant!");
                                        connexionReussie = true;
                                        IntervenantMenu intervenantMenu = new IntervenantMenu();
                                        intervenantMenu.afficherMenu(scanner);
                                        break;
                                    }
                                }
                            }

                            if (!connexionReussie) {
                                System.out.println("Échec de la connexion. Courriel ou mot de passe incorrect. Essayez à nouveau.");
                            }
                        }

                        menu();
                        break;
                    case 3:
                        System.out.println("Merci d'avoir utilisé MaVilleApp.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Choix invalide, veuillez réessayer.");
                        menu();
                }
            }
        }
    }

    public static boolean validerCourriel(String courriel) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(courriel);
        return matcher.matches();
    }

    public static boolean validerMotDePasse(String motDePasse) {
        String regex = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(motDePasse);
        return matcher.matches();
    }

    public static void menu() {
        System.out.println("Bienvenue dans MaVille");
        System.out.println("Menu:");
        System.out.println("Choisir une option:");
        System.out.println("1. S'inscrire");
        System.out.println("2. Se connecter");
        System.out.println("3. Quitter l'application");
    }

    public static ArrayList<Resident> chargerResidentsDepuisJson(String cheminFichier) throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader(cheminFichier);
        Type type = (new TypeToken<ArrayList<Resident>>() {
        }).getType();
        return (ArrayList)gson.fromJson(reader, type);
    }

    public static ArrayList<Intervenant> chargerIntervenantsDepuisJson(String cheminFichier) throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader(cheminFichier);
        Type type = (new TypeToken<ArrayList<Intervenant>>() {
        }).getType();
        return (ArrayList)gson.fromJson(reader, type);
    }

    public static ArrayList<RequeteTravail> chargerRequetesTravailDepuisJson(String cheminFichier) throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader(cheminFichier);
        Type type = (new TypeToken<ArrayList<RequeteTravail>>() {
        }).getType();
        return (ArrayList)gson.fromJson(reader, type);
    }

    public static ArrayList<Resident> chargerResidentsDepuisApi() throws IOException {
        String url = "http://localhost:7002/residents";
        HttpResponse<String> response = HttpClientMaVille.get(url);
        if (response != null && response.statusCode() == 200) {
            Gson gson = new Gson();
            Type type = (new TypeToken<ArrayList<Resident>>() {
            }).getType();
            return (ArrayList)gson.fromJson((String)response.body(), type);
        } else {
            System.out.println("Erreur de récupération des résidents.");
            return new ArrayList();
        }
    }
}
