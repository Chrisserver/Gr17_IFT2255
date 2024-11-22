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
    void testChargerResidentsDepuisApi() throws IOException {
        ArrayList<Resident> residents = MaVille.chargerResidentsDepuisApi();
        Assertions.assertNotNull(residents);
        Assertions.assertFalse(residents.isEmpty());
        Assertions.assertEquals("alice.dupont@example.com", ((Resident)residents.get(0)).getCourriel());
    }
}
