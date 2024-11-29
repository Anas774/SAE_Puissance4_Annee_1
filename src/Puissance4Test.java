//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;
//
//public class Puissance4Test {
//
//    @Test
//    public void testVerifieGagnerHorizontal() {
//        char[][] grille = {
//                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                {'J', 'J', 'J', 'J', ' ', ' ', ' '}
//        };
//        JouerDeux.grille = grille;                      // C'est pour faire comprendre que ce tableau correspond au tableau dans fonction JouerDeux() donc le tableau originel
//        assertTrue(JouerDeux.verifierHorizontal());
//    }
//
//    @Test
//    public void testVerifieGagnerVertical() {
//        char[][] grille = {
//                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                {' ', ' ', ' ', 'J', ' ', ' ', ' '},
//                {' ', ' ', ' ', 'J', ' ', ' ', ' '},
//                {' ', ' ', ' ', 'J', ' ', ' ', ' '},
//                {' ', ' ', ' ', 'J', ' ', ' ', ' '},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' '}
//        };
//        JouerDeux.grille = grille;
//        assertTrue(JouerDeux.verifierVertical());
//    }
//
//    @Test
//    public void testVerifieGagnerDiagonal() {
//        char[][] grille = {
//                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                {'J', ' ', ' ', ' ', ' ', ' ', ' '},
//                {' ', 'J', ' ', ' ', ' ', ' ', ' '},
//                {' ', ' ', 'J', ' ', ' ', ' ', ' '},
//                {' ', ' ', ' ', 'J', ' ', ' ', ' '},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' '}
//        };
//        JouerDeux.grille = grille;
//        assertTrue(JouerDeux.verifierDiagonalDeGaucheDroite());
//    }
//
//    @Test
//    public void testGrilleRemplie() {
//        char[][] grille = {
//                {'J', 'J', 'J', 'J', 'J', 'J', 'J'},
//                {'J', 'J', 'J', 'J', 'J', 'J', 'J'},
//                {'J', 'J', 'J', 'J', 'J', 'J', 'J'},
//                {'J', 'J', 'J', 'J', 'J', 'J', 'J'},
//                {'J', 'J', 'J', 'J', 'J', 'J', 'J'},
//                {'J', 'J', 'J', 'J', 'J', 'J', 'J'}
//        };
//        JouerDeux.grille = grille;
//        assertTrue(JouerDeux.grilleRemplie());
//    }
//
//
//}
