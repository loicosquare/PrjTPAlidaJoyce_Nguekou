package Entities;
import java.util.Scanner;

import static Constants.Constant.*;
import static Constants.Constant.RESET;

public class MenuOption {

    /**
     * Déclaration des variables globales.
     */
    private Scanner scanner = new Scanner(System.in);

    //Déclaration de la variable qui permet de savoir si le jeu a commencé.
    private boolean gameStarted = false;

    public void start() {
        // Variale qui permet de stocker le choix de l'utilisateur.
        int choice;

        //1 - Affichage du nom et des prénoms.
        System.out.println(PURPLE + "***********************");
        System.out.println("* " + ALIDA_NAME + " *");
        System.out.println("***********************" + RESET);
        System.out.println("\n");

        do {
            System.out.println("**********************");
            System.out.println("*   " + YELLOW + "MENU DU POKER" + RESET + "    *");
            System.out.println("**********************");
            System.out.println("* 1. " + BLUE + "Démarrer le jeu" + RESET + " *");
            System.out.println("* 2. " + RED + "Règles du jeu" + RESET + "   *");
            System.out.println("* 3. " + YELLOW + "Quitter" + RESET + "         *");
            System.out.println("**********************\n");
            System.out.print("Entrez votre choix : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    //Si on choisit 1, on appelle le deuxième menu.
//                    if(!gameStarted) {
//                        callMenu2();
//                        gameStarted = true;
//                    } else {
//                        System.out.println("Le jeu a déjà commencé.");
//                    }
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
        MenuInformations menuInformations = new MenuInformations();
        menuInformations.run();
    }

    public static void exit() {
        System.out.println("Merci d'avoir joué au poker !");
        System.exit(0);
    }
}