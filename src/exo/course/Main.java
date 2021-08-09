package exo.course;

public class Main {

    public static void main(String[] args) {


        // System.out.println("" + String.format("%.2f, %d, %s", 0.45497313737, 3, "salut"));

        Circuit c = new Circuit(3,"spa", 10);
        Voiture v = new Voiture("VrimVroom",210,"Marie Vitesse");
        Voiture v1 = new Voiture("BipBoop",220,"Pol Rapide");
        Voiture v2 = new Voiture("VrimVroom",205,"Dominique Haleur");

        c.concourir(v);
        c.concourir(v1);
        c.concourir(v2);

        System.out.println(c);


    }

}
