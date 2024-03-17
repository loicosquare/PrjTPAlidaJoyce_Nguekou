package Entities;

import java.util.Scanner;

import static Constants.Constant.*;

public class Menu2 {

    private Scanner scanner = new Scanner(System.in);
    public void run() {
        //int choice;

        //1 - Affichage du nom et des prénoms.
//        System.out.println(PURPLE + "***********************");
//        System.out.println("* " + ALIDA_NAME + " *");
//        System.out.println("***********************" + RESET);
//        System.out.println("\n");

        //2 - Affichage du titre : Jeu de Pocker et des règles.
        System.out.println("*******************\t\t\t\t\t\tNULL = -10$");
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
        System.out.println(PURPLE +"♦       ♥       ♣       ♣       ♦\t\t" +RESET +"**************" + RESET);
        System.out.println("**********************************\n");
        System.out.println("Entrez les cartes a échanger (1, 2, 3, 4, 5) par exemple : \n");

//        do {
//            System.out.println("**********************");
//            System.out.println("*   " + YELLOW + "MENU DU POKER" + RESET + "    *");
//            System.out.println("**********************");
//            System.out.println("* 1. " + BLUE + "Démarrer le jeu" + RESET + " *");
//            System.out.println("* 2. " + RED + "Règles du jeu" + RESET + "   *");
//            System.out.println("* 3. " + YELLOW + "Quitter" + RESET + "         *");
//            System.out.println("**********************");
//            System.out.print("Choix : ");
//            choice = scanner.nextInt();
//
//            switch (choice) {
//                case 1:
//                    System.out.println("Démarrage du jeu...");
//                    // Mettez ici le code pour démarrer le jeu
//                    break;
//                case 2:
//                    System.out.println("Règles du jeu :");
//                    // Mettez ici le code pour afficher les règles du jeu
//                    break;
//                case 3:
//                    System.out.println("Merci d'avoir joué au poker !");
//                    break;
//                default:
//                    System.out.println("Choix invalide. Veuillez choisir à nouveau.");
//            }
//        } while (choice != 3);

        //scanner.close();
    }
}
