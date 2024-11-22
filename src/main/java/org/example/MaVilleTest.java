package org.example;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaVilleTest {
    private Resident resident;
    private Intervenant intervenant;

    public MaVilleTest() {
    }

    @Test
    void testValiderCourriel_Valide() {
        Assertions.assertTrue(MaVille.validerCourriel("valid.email@example.com"));
    }

    @Test
    void testValiderCourriel_Invalide() {
        Assertions.assertFalse(MaVille.validerCourriel("invalid.email"));
    }

    @Test
    void testValiderMotDePasse_Valide() {
        Assertions.assertTrue(MaVille.validerMotDePasse("Password1"));
    }

    @Test
    void testValiderMotDePasse_Invalide() {
        Assertions.assertFalse(MaVille.validerMotDePasse("Pass1"));
    }

    @Test
    void testValiderMotDePasse_Invalide_SansMajuscule() {
        Assertions.assertFalse(MaVille.validerMotDePasse("password1"));
    }

    @Test
    void testValiderMotDePasse_Invalide_SansChiffre() {
        Assertions.assertFalse(MaVille.validerMotDePasse("Password"));
    }

    @Test
    void testChargerEntravesDepuisApi() throws IOException {
        try {
            Assertions.assertEquals("avenue Earnscliffe ",MaVille.chargerEntravesDepuisApi().get(0).getStreetId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void testChargerProjetsDepuisApi() throws IOException {
        try {
            Assertions.assertEquals("Rivière-des-Prairies-Pointe-aux-Trembles",MaVille.chargerProjetsDepuisApi().get(0).getQuartiersAffectes().get(0));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void testreadIntervenantsFromFile() throws IOException{
        ArrayList<Intervenant> intervenants = UtilisateursAPI.readIntervenantsFromFile();

        Assertions.assertEquals(3,intervenants.size());
        Assertions.assertNotNull(intervenants);
        Assertions.assertEquals("Entreprise ABC",intervenants.get(0).getNomComplet());
    }


}
