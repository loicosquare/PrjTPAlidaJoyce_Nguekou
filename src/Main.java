import Entities.Menu1;
import Entities.Menu2;

import java.awt.*;

public class Main {

    /**
     * Point d'entrée de l'application
     * @param args : tableau de chaînes de caractères qui contient les arguments passés à l'application.
     */

    public static void main(String[] args) {
        //Appel du premier menu.
        Menu1 menu1 = new Menu1(); // Création d'une instance de Menu1.
        menu1.start(); // Appel de la méthode run() de l'instance de Menu1.

        //Appel du deuxième menu.
        Menu2 menu2 = new Menu2(); // Création d'une instance de Menu2.
        menu2.run(); // Appel de la méthode run() de l'instance de Menu2.
    }
}