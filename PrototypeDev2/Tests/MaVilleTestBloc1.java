
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaVilleTestBloc1 {

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
}
