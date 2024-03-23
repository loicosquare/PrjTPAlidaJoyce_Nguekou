package Entities;

import java.util.Scanner;

import static Constants.Constant.*;

public class Menu2 {

    private Scanner scanner = new Scanner(System.in);

    //Déclaration des variables pour les cartes à échanger.
    int numeroDeCarte1;
    int numeroDeCarte2;

    public void run() {

        //2 - Affichage du titre : Jeu de Pocker et des règles.
        System.out.println("\n\n*******************\t\t\t\t\t\tNULL = -10$");
        System.out.println("** " + CYAN + POKER_TITLE + RESET + " **\t\t\t\t\t\t1 PAIRE = 0$");
        System.out.println("*******************\t\t\t\t\t\t2 PAIRE = 20$");
        System.out.println("\n\t\t\t\t\t\t\t\t\t\tBRELAN (3) = 35$");
        System.out.println("\t\t\t\t\t\t\t\t\t\tSUITE = 50$");
        System.out.println("\t\t\t\t\t\t\t\t\t\tFULL (3+2) = 75$");
        System.out.println("\t\t\t\t\t\t\t\t\t\tCOULEUR = 100$");
        System.out.println("\t\t\t\t\t\t\t\t\t\tCARRE = 150$");
        System.out.println(GREEN + "\t\t\t\t\t\t\t\t\t\tQUINTE ROYALE = 500$ \n" + RESET);

        // Solde initial
        System.out.println(BLUE + "\t\t\t\t\t\t\t\t\t\tVous avez 100$ au départ\n" + RESET);

        System.out.println("**********************************\t\t**************");
        System.out.println(CYAN +"A       D       V       4       5\t\t*" +RESET + GREEN + " GAIN : 100$" + RESET + " *");
        System.out.println(PURPLE +"♦       ♥       ♣      ♣       ♦\t\t" +RESET +"**************" + RESET);
        System.out.println("**********************************\n");

        // Demander à l'utilisateur de choisir les cartes à échanger.
        System.out.println(YELLOW + "Entrez les cartes à échanger (1, 2, 3, 4, 5) par exemple : \n" + RESET);

        // Saisie du numéro de la première carte
        System.out.print(GREEN + "Entrez le numéro de la carte 1 à changer (0 pour aucune) : " + RESET);
        numeroDeCarte1 = scanner.nextInt();

        // Vérification du numéro de carte 1
        if (numeroDeCarte1 < 0 || numeroDeCarte1 > 5) {
            do {
                System.err.println("Erreur : le numéro de la carte à changer doit être entre 0 et 5.\n");
                System.out.print("Entrez le numéro de la carte 1 à changer (0 pour aucune) : ");
                numeroDeCarte1 = scanner.nextInt();
            } while (numeroDeCarte1 < 0 || numeroDeCarte1 > 5);
        }

        if (numeroDeCarte1 == 0) {
            System.out.println("Vous avez choisi de ne pas changer de carte 1.\n");
        } else {
            // Saisie du numéro de la deuxième carte
            System.out.print(GREEN + "Entrez le numéro de la carte 2 à changer (0 pour aucune) : " + RESET);
            numeroDeCarte2 = scanner.nextInt();

            // Vérification du numéro de carte 2
            if (numeroDeCarte2 < 0 || numeroDeCarte2 > 5) {
                do {
                    System.err.println("Erreur : le numéro de la carte à changer doit être entre 0 et 5.\n");
                    System.out.print(GREEN + "Entrez le numéro de la carte 2 à changer (0 pour aucune) : \n" + RESET);
                    numeroDeCarte2 = scanner.nextInt();
                } while (numeroDeCarte2 < 0 || numeroDeCarte2 > 5);
            }

            if (numeroDeCarte2 == 0) {
                System.out.println("Vous avez choisi de ne pas changer de carte 2.\n");
            } else if (numeroDeCarte2 < 1 || numeroDeCarte2 > 5 || numeroDeCarte2 == numeroDeCarte1) {
                if (numeroDeCarte2 == numeroDeCarte1) {
                    System.err.println("Erreur : Vous avez déjà choisi la carte numéro " + numeroDeCarte1 + " pour être changée.");
                    System.out.print(GREEN + "Entrez le numéro de la carte 2 à changer (0 pour aucune) : \n" + RESET);
                    numeroDeCarte2 = scanner.nextInt();
                } else {
                    System.out.println("Erreur : le numéro de la carte à changer doit être entre 1 et 5.\n");
                }
            } else {
                System.out.println("Vous avez choisi de changer la carte numéro " + numeroDeCarte1 + " et la carte numéro " + numeroDeCarte2);
            }
        }

        scanner.close();
    }

    // Méthode pour demander au joueur de rentrer la position des cartes à changer
    public int[] demanderCartesAChanger() {
        int[] positions = new int[5];
        System.out.println("Entrez les positions des cartes à changer (entre 1 et 5) séparées par des espaces :");
        for (int i = 0; i < 5; i++) {
            positions[i] = scanner.nextInt();
        }
        return positions;
    }
}
