import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PokerGame {
    static final int CAPITAL_DEPART = 100;
    static int capitalJoueur = CAPITAL_DEPART;
    static int[] paquet = new int[52];
    static char[] sorte = {'♠', '♡', '♢', '♣'};


    public static void main(String[] args) {
        System.out.println("**************");
        System.out.println("*Jeu De Poker*");
        System.out.println("**************");
        System.out.println("NULL: -10$");
        System.out.println("1 PAIRE: 0$");
        System.out.println("2 PAIRES: 20$");
        System.out.println("BRELAN(3): 35$");
        System.out.println("SUITE: 50$");
        System.out.println("FULL(3+2): 75$");
        System.out.println("COULEUR: 100$");
        System.out.println("CARRE: 150$");
        System.out.println("QUINTE ROYALE: 500$");
        System.out.println("Vous avez " + CAPITAL_DEPART + "$ au départ.");

        Scanner scanner = new Scanner(System.in);
        while (capitalJoueur > 0) {
            jouerUnePartie();
            System.out.println("Voulez-vous rejouer ? oui/non");
            String choix;
            do {
                choix = scanner.nextLine();
                if (!choix.equalsIgnoreCase("oui") && !choix.equalsIgnoreCase("non")) {
                    System.out.println("Veuillez entrer 'oui' ou 'non'.");
                }
            } while (!choix.equalsIgnoreCase("oui") && !choix.equalsIgnoreCase("non"));

            if (choix.equalsIgnoreCase("non")) {
                break;
            }
        }
        System.out.println("Merci d'avoir joué !");
    }

    public static void jouerUnePartie() {
        initialiserPaquet();
        melangerPaquet();
        afficher5Cartes();
        int nbCartesAChanger = choisirNbCartesAChanger();
        changerCartes(nbCartesAChanger);
        evaluerJeu();
        // Afficher les cartes à la fin de la partie
        System.out.println("Voici vos cartes à la fin du jeu :");
        afficher5Cartes();
    }



    public static void initialiserPaquet() {
        for (int i = 0; i < paquet.length; i++) {
            paquet[i] = i;
        }
    }

    public static void melangerPaquet() {
        Random random = new Random();
        for (int i = 0; i < paquet.length; i++) {
            int j = random.nextInt(52);
            int temp = paquet[i];
            paquet[i] = paquet[j];
            paquet[j] = temp;
        }
    }

    public static void afficher5Cartes() {
        System.out.println("Voici vos cartes :");
        for (int i = 0; i < 5; i++) {
            int sorteIndex = paquet[i] / 13;
            int valeur = paquet[i] % 13 + 1;
            System.out.println(valeur + " " + getSymbole(sorteIndex));
        }
    }

    // afficher le tableau à la fin du jeu

    public static void afficherTableauApresChangement(){
        System.out.println("Voici vos cartes Apres changement :");
        for (int i = 0; i < 5; i++) {
            int sorteIndex = paquet[i] / 13;
            int valeur = paquet[i];
            System.out.println(valeur + " " + getSymbole(sorteIndex));
        }
    }

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

    public static int choisirNbCartesAChanger() {
        Scanner scanner = new Scanner(System.in);
        int nbCartes;
        do {
            System.out.println("Combien de cartes souhaitez-vous changer ? (0-4)");
            nbCartes = scanner.nextInt();
        } while (nbCartes < 0 || nbCartes > 4);
        return nbCartes;
    }

    public static void changerCartes(int nbCartesAChanger) {
        if (nbCartesAChanger == 0) {
            return;
        }
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < nbCartesAChanger; i++) {
            System.out.println("Entrez le numéro de la carte " + (i + 1) + " à changer (1-5) : ");
            int index = scanner.nextInt() - 1;
            if(index < 0 || index >= 5) {
                System.out.println("Numéro de carte invalide. Veuillez entrer un numéro de carte entre 1 et 5.");
                i--;
                continue;
            }
            paquet[index] = paquet[5 + i];
        }
    }

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
            System.out.println("Quinte Royale ! Vous avez gagné $500");
        } else if (carre) {
            gain = 150;
            System.out.println("Carré ! Vous avez gagné $150");
        } else if (couleur) {
            gain = 100;
            System.out.println("Couleur ! Vous avez gagné $100");
        } else if (full) {
            gain = 75;
            System.out.println("Full ! Vous avez gagné $75");
        } else if (suite) {
            gain = 50;
            System.out.println("Suite ! Vous avez gagné $50");
        } else if (brelan) {
            gain = 35;
            System.out.println("Brelan ! Vous avez gagné $35");
        } else if (deuxPaires) {
            gain = 20;
            System.out.println("Deux Paires ! Vous avez gagné $20");
        } else if (unePaire) {
            gain = 0;
            System.out.println("Une Paire ! Vous avez gagné $0");
        } else {
            gain = -10;
            System.out.println("Perdu ! Vous avez perdu $10");
        }

        capitalJoueur += gain;
    }
}
