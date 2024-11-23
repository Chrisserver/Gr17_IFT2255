package org.example;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaVilleTestBloc3 {

    @Test
    void testChargerEntravesDepuisApi() throws IOException {
        try {
            Assertions.assertEquals("avenue Earnscliffe ", MaVille.chargerEntravesDepuisApi().get(0).getStreetId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testChargerProjetsDepuisApi() throws IOException {
        try {
            Assertions.assertEquals("Rivière-des-Prairies-Pointe-aux-Trembles", MaVille.chargerProjetsDepuisApi().get(0).getQuartiersAffectes().get(0));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testreadIntervenantsFromFile() throws IOException {
        ArrayList<Intervenant> intervenants = UtilisateursAPI.readIntervenantsFromFile();

        Assertions.assertEquals(3, intervenants.size());
        Assertions.assertNotNull(intervenants);
        Assertions.assertEquals("Entreprise ABC", intervenants.get(0).getNomComplet());
    }
}
