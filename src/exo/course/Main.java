package exo.course;

import java.time.Duration;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {


        // System.out.println("" + String.format("%.2f, %d, %s", 0.45497313737, 3, "salut"));

        System.out.println("salut");

        Circuit c = new Circuit(3,"spa", 10);
        Voiture v = new Voiture("VrimVroom",210,"Marie Vitesse");
        Voiture v1 = new Voiture("BipBoop",220,"Pol Rapide");
        Voiture v2 = new Voiture("VrimVroom",205,"Dominique Haleur");

        c.concourir(v);
        c.concourir(v1);
        c.concourir(v1);
        c.concourir(v2);
        c.concourir(v);

        System.out.println(c);


    }

}
