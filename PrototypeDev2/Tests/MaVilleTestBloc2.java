

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaVilleTestBloc2 {

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
}
