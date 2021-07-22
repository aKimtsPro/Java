package poo.generics;

public class Main {

    public static void main(String[] args) {

        Boite<Biscuit> boite = new Boite<>(5);

        System.out.println("après instanciation" + boite);

        boite.ajouter(new Biscuit());
        boite.ajouter(new Biscuit());
        boite.ajouter(new Biscuit());

        System.out.println("après 3 ajouts" + boite);

        boite.ajouter(new Biscuit());
        boite.ajouter(new Biscuit());

        System.out.println("après 5 ajouts" + boite);

        Biscuit supprime = boite.retirer(2);
        boite.indexOf(null);

        System.out.println("après la suppression de l'index 2" + boite);
    }
}
