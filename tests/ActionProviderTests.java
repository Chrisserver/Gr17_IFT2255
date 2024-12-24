

import io.javalin.Javalin;
import org.example.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ActionProviderTests {


    @BeforeEach
    void setup() {
        // Configurer les fichiers de test
        RequeteAPI.FILE_PATH="test_requetes.json";
        ProjetAPI.FILE_PATH = "test_Projets.json";
        NotificationAPI.FILE_PATH = "test_notifications.json";
        UtilisateursAPI.INTERVENANTS_FILE_PATH = "test_intervenants.json";
        UtilisateursAPI.RESIDENTS_FILE_PATH = "test_residents.json";

        // Charger les données initiales
        MaVille.requetes = (ArrayList<RequeteTravail>) RequeteAPI.readFromFile(RequeteAPI.FILE_PATH, RequeteTravail.class);
        MaVille.projets = (ArrayList<ProjetTravaux>) ProjetAPI.readFromFile(ProjetAPI.FILE_PATH, ProjetTravaux.class);
        MaVille.notifications = (ArrayList<Notification>) NotificationAPI.readFromFile(NotificationAPI.FILE_PATH, Notification.class);
    }

    @AfterEach
    void teardown() {
        // Réinitialiser les fichiers de production
        RequeteAPI.FILE_PATH = "requetes.json";
        ProjetAPI.FILE_PATH ="Projets.json";
        NotificationAPI.FILE_PATH = "Notifications.json";
        UtilisateursAPI.INTERVENANTS_FILE_PATH = "Intervenants.json";
        UtilisateursAPI.RESIDENTS_FILE_PATH = "Residents.json";
    }

    // === Tests pour Soumettre un Projet ===
    @Test
    void testSoumettreProjetValide() {
        assertDoesNotThrow(() -> ActionProvider.soumettreProjet(
                "ID123", "Projet Test", "Description Test", "Réparation",
                new ArrayList<>(List.of("Quartier1")), new ArrayList<>(List.of("Rue1")),
                "2024-01-01", "2024-01-15", "8h-17h"
        ));
    }

    @Test
    void testSoumettreProjetSansQuartier() {
        assertDoesNotThrow(() -> ActionProvider.soumettreProjet(
                "ID123", "Projet Test", "Description Test", "Réparation",
                new ArrayList<>(), new ArrayList<>(List.of("Rue1")),
                "2024-01-01", "2024-01-15", "8h-17h"
        ));
    }

    @Test
    void testSoumettreProjetAvecErreur() {
        assertDoesNotThrow(() -> {
            try {
                ActionProvider.soumettreProjet(
                        "ID123", "Projet Invalide", null, "Réparation",
                        null, null, null, null, null
                );
            } catch (Exception e) {
                throw new RuntimeException("Erreur simulée lors de la soumission");
            }
        });
    }

    // === Tests pour Soumettre une Requête ===
    @Test
    void testSoumettreRequeteValide() {
        assertDoesNotThrow(() -> ActionProvider.soumettreRequete(
                "Resident123", "Requete Test", "Description", "Type1", "2024-01-01"
        ));
    }

    @Test
    void testSoumettreRequeteSansTitre() {
        assertDoesNotThrow(() -> ActionProvider.soumettreRequete(
                "Resident123", "", "Description", "Type1", "2024-01-01"
        ));
    }

    @Test
    void testSoumettreRequeteAvecErreur() {
        assertDoesNotThrow(() -> {
            try {
                ActionProvider.soumettreRequete(
                        null, "Titre", null, "Type1", null
                );
            } catch (Exception e) {
                throw new RuntimeException("Erreur simulée lors de la soumission");
            }
        });
    }


    // === Tests pour Ajouter une Candidature ===
    @Test
    void testAjouterCandidatureValide() {
        assertDoesNotThrow(() -> ActionProvider.addCandidature("Requete123", "Candidat123"));
    }

    @Test
    void testAjouterCandidatureSansRequete() {
        assertDoesNotThrow(() -> ActionProvider.addCandidature("", "Candidat123"));
    }

    @Test
    void testAjouterCandidatureAvecErreur() {
        assertDoesNotThrow(() -> ActionProvider.addCandidature(null, null));
    }

    @Test
    void testChargerProjetsDepuisApiLocale() throws IOException {
        ArrayList<ProjetTravaux> projets = ProjetEntravesService.getInstance().chargerProjetsDepuisApi();
        assertNotNull(projets, "Les projets devraient être chargés.");
        assertTrue(projets.size() > 0, "Il devrait y avoir au moins un projet.");
    }



    @Test
    void testChargerProjetsAvecErreur() {
        assertDoesNotThrow(() -> {
            ProjetEntravesService.getInstance().chargerProjetsDepuisApi();
        }, "Le chargement des projets ne devrait pas lever d'exception.");
    }
    @Test
    void testChargerRequetesEnMap() throws IOException {
        Map<String, RequeteService.IndexedEntity<RequeteTravail>> requetesMap = RequeteService.getInstance().chargerRequetesEnMap();
        assertNotNull(requetesMap, "La map des requêtes ne devrait pas être nulle.");
        assertTrue(requetesMap.size() > 0, "La map devrait contenir des requêtes.");
    }

    @Test
    void testChargerRequetesAvecErreur() {
        assertDoesNotThrow(() -> {
            RequeteService.getInstance().chargerRequetesDepuisApi();
        }, "Le chargement des requêtes ne devrait pas lever d'exception.");
    }
    // === Tests pour validerCourriel(Inscription) ===
    @Test
    void testValiderCourrielValide() {
        assertTrue(ActionProvider.validerCourriel("test@example.com"), "Le courriel valide devrait être accepté.");
    }

    @Test
    void testValiderCourrielSansDomaine() {
        assertFalse(ActionProvider.validerCourriel("test@"), "Le courriel sans domaine ne devrait pas être accepté.");
    }



    // === Tests pour validerMotDePasse(Inscription) ===
    @Test
    void testValiderMotDePasseValide() {
        assertTrue(ActionProvider.validerMotDePasse("Password1"), "Le mot de passe valide devrait être accepté.");
    }

    @Test
    void testValiderMotDePasseSansMajuscule() {
        assertFalse(ActionProvider.validerMotDePasse("password1"), "Le mot de passe sans majuscule ne devrait pas être accepté.");
    }

    @Test
    void testValiderMotDePasseSansChiffre() {
        assertFalse(ActionProvider.validerMotDePasse("Password"), "Le mot de passe sans chiffre ne devrait pas être accepté.");
    }

}
