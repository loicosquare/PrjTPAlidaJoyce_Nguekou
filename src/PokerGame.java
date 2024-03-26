import Entities.MenuPrincipal;
import Entities.MenuRegles;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static Constants.Constant.*;

/**
 * Classe qui représente le jeu de poker.
 */
public class PokerGame {

    /**
     * Constante qui représente le capital de départ du joueur.
     */
    static final int CAPITAL_DEPART = 100;

    /**
     * Variable qui représente le capital du joueur.
     */
    static int capitalJoueur = CAPITAL_DEPART;

    /**
     * Variable qui représente le capital restant du joueur.
     */
    static int capitalRestant;

    /**
     * Tableau qui représente le paquet de cartes.
     */
    static int[] paquet = new int[52];

    /**
     * Tableau qui représente les symboles des cartes.
     */
    static char[] sorte = {'♠', '♡', '♢', '♣'};


    /**
     * Point d'entrée de l'application
     * @param args : tableau de chaînes de caractères qui contient les arguments passés à l'application.
     */
    public static void main(String[] args) {
        // Initialiser le capital avec le capital de départ au début du jeu.
        capitalJoueur = CAPITAL_DEPART;

        //Appel du premier menu.
        MenuPrincipal menuPrincipal = new MenuPrincipal(); // Création d'une instance de MenuPrincipal.
        menuPrincipal.start(); // Appel de la méthode run() de l'instance de MenuPrincipal.

        Scanner scanner = new Scanner(System.in);
        while (capitalJoueur >= 0) {
            jouerUnePartie();
            System.out.println(ORANGE + "Voulez-vous rejouer ? oui/non" + RESET);
            String choix;
            do {
                choix = scanner.nextLine();
                if (!choix.equalsIgnoreCase("oui") && !choix.equalsIgnoreCase("non")) {
                    System.out.println(YELLOW + "Veuillez entrer 'oui' ou 'non'." + RESET);
                }
            } while (!choix.equalsIgnoreCase("oui") && !choix.equalsIgnoreCase("non"));

            if (choix.equalsIgnoreCase("non")) {
                break;
            } else {
                // Mettre à jour le capital restant avec la valeur actuelle du capitalJoueur.
                capitalRestant = capitalJoueur;
            }
        }
        System.out.println(GREEN + "Merci d'avoir joué !" + RESET);
    }

    /**
     * Méthode qui permet de jouer une partie de poker.
     */
    public static void jouerUnePartie() {
        // Réinitialiser le capital du joueur avec le capital restant.
        //capitalJoueur = capitalRestant;
        System.out.println(YELLOW + "Votre capital est de : " + capitalJoueur + "$\n" + RESET);
        initialiserPaquet();
        melangerPaquet();
        System.out.println(CYAN + "Voici vos cartes au début du jeu (Avant changement) :" + RESET);
        afficher5Cartes();
        int nbCartesAChanger = choisirNbCartesAChanger();
        changerCartes(nbCartesAChanger);
        evaluerJeu();
        // Afficher les cartes à la fin de la partie
        System.out.println(PURPLE + "Voici vos cartes à la fin du jeu (Après changement) :" + RESET);
        afficher5Cartes();
    }

    /**
     * Méthode qui permet d'initialiser le paquet de cartes.
     */
    public static void initialiserPaquet() {
        for (int i = 0; i < paquet.length; i++) {
            paquet[i] = i;
        }
    }

    /**
     * Méthode qui permet de mélanger le paquet de cartes.
     */
    public static void melangerPaquet() {
        Random random = new Random();
        for (int i = 0; i < paquet.length; i++) {
            int j = random.nextInt(52);
            int temp = paquet[i];
            paquet[i] = paquet[j];
            paquet[j] = temp;
        }
    }

    /**
     * Méthode qui permet d'afficher les 5 cartes du joueur.
     */
    public static void afficher5Cartes() {
        System.out.println("*****************");
        System.out.print(CYAN);
        for (int i = 0; i < 5; i++) {
            int sorteIndex = paquet[i] / 13;
            int valeur = paquet[i] % 13 + 1;
            System.out.print(getSymbole(sorteIndex) + "\t");
        }
        System.out.println(PURPLE);
        for (int i = 0; i < 5; i++) {
            int sorteIndex = paquet[i] / 13;
            int valeur = paquet[i] % 13 + 1;
            System.out.print(valeur + "\t");
        }
        System.out.println("\t\t" + RESET);
        System.out.println("*****************\n");
    }

    /**
     * Méthode qui permet de retourner le symbole d'une carte.
     * @param index : l'index de la carte.
     * @return : le symbole de la carte.
     */
    public static String getSymbole(int index) {
        switch (index) {
            case 0:
                return "♠";
            case 1:
                return "♡";
            case 2:
                return "♢";
            case 3:
                return "♣";
            default:
                return "";
        }
    }

    /**
     * Méthode qui permet de choisir le nombre de cartes à changer.
     * @return : le nombre de cartes à changer.
     */
    public static int choisirNbCartesAChanger() {
        Scanner scanner = new Scanner(System.in);
        int nbCartes;
        System.out.println("Combien de cartes souhaitez-vous changer ? (0-4)");
        do {
            // Vérifier si le prochain élément est un entier
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide.");
                // Vider la ligne de saisie pour permettre à l'utilisateur de saisir à nouveau
                scanner.next();
            }
            nbCartes = scanner.nextInt();
            if (nbCartes < 0 || nbCartes > 4) {
                System.out.println("Veuillez entrer un nombre entre 0 et 4.");
            } else if (nbCartes == 0) {
                System.out.println("Vous avez décidé de ne changer aucune carte.");
                break;
            }
        } while (nbCartes < 0 || nbCartes > 4);

        return nbCartes;
    }

    /**
     * Méthode qui permet de changer les cartes du joueur.
     * @param nbCartesAChanger : le nombre de cartes à changer.
     */
    public static void changerCartes(int nbCartesAChanger) {
        if (nbCartesAChanger == 0) {
            return;
        }
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < nbCartesAChanger; i++) {
            int index;
            do {
                System.out.println(CYAN + "Entrez le numéro de la carte " + (i + 1) + " à changer (1-5) : " + RESET);
                // Vérifier si le prochain élément est un entier
                while (!scanner.hasNextInt()) {
                    System.out.println(RED + "Veuillez entrer un nombre valide." + RESET);
                    scanner.next(); // Vider la ligne de saisie pour permettre à l'utilisateur de saisir à nouveau
                }
                index = scanner.nextInt() - 1;
                if (index < 0 || index >= 5) {
                    System.out.println(RED + "Numéro de carte invalide. Veuillez entrer un numéro de carte entre 1 et 5." + RESET);
                }
            } while (index < 0 || index >= 5);
            paquet[index] = paquet[5 + i];
        }
    }


    /**
     * Méthode qui permet d'évaluer le jeu du joueur.
     */
    public static void evaluerJeu() {
        int[] valeurs = new int[5];
        int[] sortes = new int[5];

        for (int i = 0; i < 5; i++) {
            valeurs[i] = paquet[i] % 13 + 1;
            sortes[i] = paquet[i] / 13;
        }
        Arrays.sort(valeurs);

        Afficher$(valeurs, sortes);
    }

    /**
     * Méthode qui permet d'afficher le gain du joueur.
     * @param valeurs : tableau des valeurs des cartes.
     * @param sortes : tableau des sortes des cartes.
     */
    public static void Afficher$(int[] valeurs, int[] sortes){

        boolean toutesDifferentes = valeurs[0] != valeurs[1] && valeurs[1] != valeurs[2] && valeurs[2] != valeurs[3] && valeurs[3] != valeurs[4];
        boolean unePaire = valeurs[0] == valeurs[1] || valeurs[1] == valeurs[2] || valeurs[2] == valeurs[3] || valeurs[3] == valeurs[4];
        boolean deuxPaires = (valeurs[0] == valeurs[1] && valeurs[2] == valeurs[3]) || (valeurs[0] == valeurs[1] && valeurs[3] == valeurs[4]) || (valeurs[1] == valeurs[2] && valeurs[3] == valeurs[4]);
        boolean brelan = valeurs[0] == valeurs[2] || valeurs[1] == valeurs[3] || valeurs[2] == valeurs[4];
        boolean suite = valeurs[4] - valeurs[0] == 4 && toutesDifferentes;
        boolean full = (valeurs[0] == valeurs[1] && valeurs[2] == valeurs[4]) || (valeurs[0] == valeurs[2] && valeurs[3] == valeurs[4]);
        boolean couleur = sortes[0] == sortes[1] && sortes[1] == sortes[2] && sortes[2] == sortes[3] && sortes[3] == sortes[4];
        boolean carre = valeurs[0] == valeurs[3] || valeurs[1] == valeurs[4];
        boolean quinteRoyale = suite && valeurs[0] == 1 && valeurs[4] == 13;

        int gain = 0;
        if (quinteRoyale) {
            gain = 500;
            System.out.println(BLUE + "Quinte Royale ! Vous avez gagné $500 \n" + RESET);
        } else if (carre) {
            gain = 150;
            System.out.println(ORANGE + "Carré ! Vous avez gagné $150 \n" + RESET);
        } else if (couleur) {
            gain = 100;
            System.out.println(ORANGE + "Couleur ! Vous avez gagné $100 \n" + RESET);
        } else if (full) {
            gain = 75;
            System.out.println(GREEN + "Full ! Vous avez gagné $75 \n" + RESET);
        } else if (suite) {
            gain = 50;
            System.out.println(GREEN + "Suite ! Vous avez gagné $50 \n" + RESET);
        } else if (brelan) {
            gain = 35;
            System.out.println(GREEN + "Brelan ! Vous avez gagné $35 \n" + RESET);
        } else if (deuxPaires) {
            gain = 20;
            System.out.println(GREEN + "Deux Paires ! Vous avez gagné $20 \n" + RESET);
        } else if (unePaire) {
            gain = 0;
            System.out.println(GREEN + "Une Paire ! Vous avez gagné $0 \n" + RESET);
        } else {
            gain = -10;
            System.out.println(RED + "Perdu ! Vous avez perdu $10 \n" + RESET);
        }

        capitalJoueur += gain;
        System.out.println(YELLOW + "Votre capital est de : " + capitalJoueur + "$\n");
    }
}