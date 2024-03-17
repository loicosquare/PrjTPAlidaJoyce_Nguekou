package Entities;

import java.util.Scanner;

import static Constants.Constant.*;

public class Menu2 {

    private Scanner scanner = new Scanner(System.in);
    public void run() {

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
    }
}
