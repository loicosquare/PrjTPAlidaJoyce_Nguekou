package Entities;

import java.util.Scanner;

public class PokerGame {
    private Scanner scanner = new Scanner(System.in);

    // Méthode pour demander au joueur de rentrer la position des cartes à changer
    public int[] demanderCartesAChanger() {
        int[] positions = new int[5];
        System.out.println("Entrez les positions des cartes à changer (entre 1 et 5) séparées par des espaces :");
        for (int i = 0; i < 5; i++) {
            positions[i] = scanner.nextInt();
        }
        return positions;
    }

    // Méthode pour initialiser le paquet de cartes
    public int[] initialiserPaquet() {
        int[] paquet = new int[52];
        for (int i = 0; i < 52; i++) {
            paquet[i] = i; // Chaque carte est représentée par un nombre de 0 à 51
        }
        return paquet;
    }


    public static void main(String[] args) {
        PokerGame game = new PokerGame();

        // Méthode pour tester la demande des cartes à changer
        int[] positions = game.demanderCartesAChanger();
        System.out.println("Positions des cartes à changer : ");
        for (int position : positions) {
            System.out.print(position + " ");
        }

        // Méthode pour tester l'initialisation du paquet de cartes
        int[] paquet = game.initialiserPaquet();
        System.out.println("Paquet de cartes initialisé : ");
        for (int carte : paquet) {
            System.out.print(carte + " ");
        }
    }
}
