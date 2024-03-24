package Entities;
import java.util.Scanner;

import static Constants.Constant.*;
import static Constants.Constant.RESET;

/**
 * Classe qui représente le menu principal du jeu.
 */
public class MenuPrincipal {


    /**
     * Scanner pour lire les entrées de l'utilisateur.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Méthode qui affiche le menu principal du jeu.
     */
    public void start() {
        int choice;

        //1 - Affichage du nom et des prénoms.
        System.out.println(PURPLE + "***********************");
        System.out.println("* " + ALIDA_NAME + " *");
        System.out.println("***********************" + RESET);
        System.out.println("\n");

        /*do {*/
            System.out.println("**********************");
            System.out.println("*   " + YELLOW + "MENU DU POKER" + RESET + "    *");
            System.out.println("**********************");
            System.out.println("* 1. " + BLUE + "Démarrer le jeu" + RESET + " *");
            System.out.println("* 2. " + RED + "Quitter" + RESET + "         *");
            System.out.println("**********************");
            System.out.print("Entrez votre choix : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    //Si on choisit 1, on appelle le menu qui contient les règles et on lance le jeu.
                    callMenuRegles();
                    return;
                case 2:
                    //Si on choisit 2, on quitte le jeu.
                    exit();
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir à nouveau.");
            }
        /*} while (choice != 2);*/

        scanner.close();
    }

    /**
     * Méthode qui appelle le menu des règles du jeu.
     */
    public static void callMenuRegles() {
        MenuRegles menuRegles = new MenuRegles();
        menuRegles.run();
    }

    /**
     * Méthode qui permet de quitter le jeu.
     */
    public static void exit() {
        System.out.println(GREEN + "Merci d'avoir joué au poker !" + RESET);
        System.exit(0);
    }
}