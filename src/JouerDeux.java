import java.util.Scanner;

public class JouerDeux {

    public static final int LIGNES = 6;
    public static final int COLONNES = 7;
    public static char[][] grille = new char[LIGNES][COLONNES];
    public static char joueur = 'J';

    public static void jouerDeux() {

        initialiserGrille();

        Scanner scanner = new Scanner(System.in);

        boolean EnCours = true;

        while (EnCours) {

            afficherGrille();
            System.out.println("\nJoueur " + joueur + ", choisissez une colonne (1-7): ");

            int colonne;

            do {
                colonne = scanner.nextInt() - 1;

                if (colonne < 0 || colonne >= COLONNES) {
                    System.out.println("Veuillez choisir une colonne entre 1 et 7 : ");
                }
            } while (colonne < 0 || colonne >= COLONNES || grille[0][colonne] != ' ');

            placerJeton(colonne);

            if (JouerDeux.verifierHorizontal() || JouerDeux.verifierVertical() || JouerDeux.verifierDiagonalDeGaucheDroite() || JouerDeux.verifierDiagonalDeDroiteGauche()) {
                afficherGrille();
                System.out.println("Joueur " + joueur + " a gagné !");
                EnCours = false;
                break;
            }

            if (JouerDeux.grilleRemplie()) {
                afficherGrille();
                System.out.println("Match nul !");
                EnCours = false;
                break;
            }

            joueur = (joueur == 'R') ? 'J' : 'R';  // Si joueur égal à R alors il passe J et si inverse il passe à R
        }

        scanner.close();
    }


    public static void initialiserGrille() {
        for (int i = 0; i < LIGNES; i++) {
            for (int j = 0; j < COLONNES; j++) {
                grille[i][j] = ' ';                 // Le ' ' signifie que la case est vide ou autrement dit qu'il y'a la création des case du tableau grille avec un espace ou une tabulation
            }
        }
    }

    public static void afficherGrille() {

        for (int i = 0; i < LIGNES; i++) {
            for (int j = 0; j < COLONNES; j++) {

                char joueur = grille[i][j];        // Sert a stocké un caractère à la position i et j dans la variable joueur ou autrement dit pour reconnaitre les joueurs (soit J ou R)

                if (joueur == 'J') {
                    System.out.print("\u001B[33m" + joueur + " \u001B[0m");         // Jaune pour le jeton du joueur
                } else if (joueur == 'R') {
                    System.out.print("\u001B[31m" + joueur + " \u001B[0m");         // Rouge pour le jeton de l'ordinateur
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void placerJeton(int colonne) {

        // Avec la boucle for, on parcourt les lignes du tableau en commencant par le bas jusqu'en haut jusqu'a qu'on trouve une case vide et une fois que nous avons trouvé la première case vide on place le jeton du joueur

        for (int i = LIGNES - 1; i >= 0; i--) {
            if (grille[i][colonne] == ' ') {
                grille[i][colonne] = joueur;
                break;
            }
        }
    }

    public static boolean verifierHorizontal() {

        // Vérification horizontal

        for (int i = 0; i < LIGNES; i++) {
            int alignements = 0;                   // Variable pour alignements
            for (int j = 0; j < COLONNES; j++) {
                if (grille[i][j] == joueur) {       // Si il voit qu'il y'a plusieurs jetons d'une certaines couleurs alignés (soit J ou R)
                    alignements++;                  // Alors il incremente la variable alignement
                    if (alignements == 4) {         // Quand il y'a 4 jetons couleurs (J ou R) alignés
                        return true;                // Alors retourne vrai ou autrement dit qu'il y'a l'alignement
                    }
                } else {
                    alignements = 0;
                }
            }
        } return false;
    }

    public static boolean verifierVertical() {

        // Vérification verticale

        for (int j = 0; j < COLONNES; j++) {
            int alignements = 0;                    // Variable pour alignements
            for (int i = 0; i < LIGNES; i++) {
                if (grille[i][j] == joueur) {       // Si il voit qu'il y'a plusieurs jetons d'une certaines couleurs alignés (soit J ou R)
                    alignements++;                  // Alors il incremente la variable alignement
                    if (alignements == 4) {         // Quand il y'a 4 jetons couleurs (J ou R) alignés
                        return true;                // Alors retourne vrai ou autrement dit qu'il y'a l'alignement
                    }
                } else {
                    alignements = 0;
                }
            }
        } return false;
    }

    public static boolean verifierDiagonalDeGaucheDroite() {            // Verification de gauche haut vers droite bas

        for (int i = 0; i < LIGNES - 3; i++) {                          // LIGNES - 3 car c'est pour s'assurer  qu'il y'est suffisament d'espace vers le bas pour detecter un alignement car nous avons besoin d'au moins 4 positions consécutives
            for (int j = 0; j < COLONNES - 3; j++) {                    // COLONNES - 3 signifie que la boucle s'arretera 3 colonnes avant la fin de la grille et pour savoir si nous avons suffisament d'espace vers la droite
                if (grille[i][j] != ' ' &&                              // Vérifie si la case actuelle dans la grille n'est pas vide autrement dit cela signifie qu'il y a un jeton dans la case
                        grille[i][j] == grille[i + 1][j + 1] &&
                        grille[i][j] == grille[i + 2][j + 2] &&
                        grille[i][j] == grille[i + 3][j + 3]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean verifierDiagonalDeDroiteGauche() {            // Verification de droite haut vers gauche bas

        for (int i = 0; i < LIGNES - 3; i++) {                          // LIGNES - 3 car c'est pour s'assurer  qu'il y'est suffisament d'espace vers le bas pour detecter un alignement car nous avons besoin d'au moins 4 positions consécutives
            for (int j = 3; j < COLONNES; j++) {                        // Ici nous avons un changement car nous commençons 3 positions a partir du bord droit avec j = 3 pour nous assurer que nous avons suffisamment d'espace vers la gauche pour vérifier si il y'a un alignement et COLONNES tout court car nous verifions l'alignements de la droite vers la gauche
                if (grille[i][j] != ' ' &&                              // Vérifie si la case actuelle dans la grille n'est pas vide autrement dit cela signifie qu'il y a un jeton dans la case
                        grille[i][j] == grille[i + 1][j - 1] &&
                        grille[i][j] == grille[i + 2][j - 2] &&
                        grille[i][j] == grille[i + 3][j - 3]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean grilleRemplie() {              // Cette classe fait : vérifie si une colonne est vide, si la case d'en haut de la colonne est vide (ce qui permet de placer le jeton)

        for (int j = 0; j < COLONNES; j++) {             // Parcours le tableau
            if (grille[0][j] == ' ') {                   // Condition pour savoir si la case à la première ligne et à la colonne j est vide ou pas
                return false;                            // Retourne faux ou autrement dit la colonne choisi n'est pas disponible car la case du dessus a un jeton
            }
        }
        return true;                                     // Sinon retourne vrai ou autrement dit met le jeton car la case du dessus est vide
    }




}
