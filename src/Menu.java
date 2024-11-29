import java.util.Scanner;

public class Menu {

    public static void menuPuissance4 () {

        Scanner scanner = new Scanner(System.in);

        int choix = 0;

        System.out.println("BUT DU JEU :");
        System.out.println("Le vainqueur est le joueur qui réalise en premier un alignement (horizontal, vertical ou diagonal) consécutif d'au moins quatre pions de sa couleur." + ("\n") +
                "Si toutes les cases de la grille du jeu sont remplies et aucun des deux joueurs n'a réalisé un tel alignement, la partie est déclarée nulle.");

        System.out.println(("\n") + "1. Jouer contre l'ordinateur.");
        System.out.println("2. Jouer contre un joueur.");

        System.out.println(("\n") + "Choisissez votre mode de jeu (Tapez 1 ou 2) :");
        choix = scanner.nextInt();

        switch (choix) {
            case 1:
                Ordi.jouer();
                break;

            case 2:
                JouerDeux.jouerDeux();
                break;
        }
    }

}
