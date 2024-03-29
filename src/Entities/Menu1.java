package Entities;
import java.util.Scanner;

import static Constants.Constant.*;
import static Constants.Constant.RESET;

public class Menu1 {

    private Scanner scanner = new Scanner(System.in);
    public void start() {
        int choice;

        //1 - Affichage du nom et des prénoms.
        System.out.println(PURPLE + "***********************");
        System.out.println("* " + ALIDA_NAME + " *");
        System.out.println("***********************" + RESET);
        System.out.println("\n");

//        // Solde initial
//        System.out.println(BLUE + "\t\t\t\t\t\t\t\t\t\tVous avez 100$ au départ\n" + RESET);
//
//        System.out.println("**********************************\t\t**************");
//        System.out.println(CYAN +"A       D       V       4       5\t\t*" +RESET + GREEN + " GAIN : 100$" + RESET + " *");
//        System.out.println(PURPLE +"♦       ♥       ♣       ♣       ♦\t\t" +RESET +"**************" + RESET);
//        System.out.println("**********************************\n");
//        System.out.println("Entrez les cartes a échanger (1, 2, 3, 4, 5) par exemple : \n");

        do {
            System.out.println("**********************");
            System.out.println("*   " + YELLOW + "MENU DU POKER" + RESET + "    *");
            System.out.println("**********************");
            System.out.println("* 1. " + BLUE + "Démarrer le jeu" + RESET + " *");
            System.out.println("* 2. " + RED + "Règles du jeu" + RESET + "   *");
            System.out.println("* 3. " + YELLOW + "Quitter" + RESET + "         *");
            System.out.println("**********************");
            System.out.print("Entrez votre choix : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    //Si on choisit 1, on appelle le deuxième menu.
                    callMenu2();
                    break;
                case 2:
                    System.out.println("Règles du jeu :");
                    // Mettez ici le code pour afficher les règles du jeu
                    break;
                case 3:
                    //Si on choisit 3, on quitte le jeu.
                    exit();
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir à nouveau.");
            }
        } while (choice != 3);

        scanner.close();
    }

    public static void callMenu2() {
        Menu2 menu2 = new Menu2();
        menu2.run();
    }

    public static void exit() {
        System.out.println("Merci d'avoir joué au poker !");
        System.exit(0);
    }
}