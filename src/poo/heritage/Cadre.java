package poo.heritage;

import java.io.OutputStream;
import java.time.LocalDate;

public class Cadre extends Personne {

    private double salaireMois;

    public Cadre(String prenom, String nom, LocalDate dateNaiss, double salaireMois) {
        super(prenom, nom, dateNaiss);
        this.salaireMois = salaireMois;
    }

    // region get/set

    public double getSalaireMois() {
        return salaireMois;
    }

    public void setSalaireMois(double salaireMois) {
        this.salaireMois = salaireMois;
    }

    // endregion
}
