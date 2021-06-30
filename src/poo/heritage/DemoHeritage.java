package poo.heritage;

import java.time.LocalDate;

public class DemoHeritage {

    public static void main(String[] args) {
        Employe emp = new Employe("luc", "manant", LocalDate.now(), 0);
        Cadre cadre = new Cadre("luc", "manant", LocalDate.now(), 0);
        cadre.manger();

        Personne p = emp;
        p = cadre;

        // p = new Personne();
        Cadre c1 = null;
        if( p instanceof Cadre )
            c1 = (Cadre)p;

        Employe e1 = null;
        if( p instanceof Employe )
            e1 = (Employe)p;
    }

}
