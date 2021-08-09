package exo.course;

import java.time.Duration;
import java.util.List;

public class Performance {

    private final Voiture auteur;
    private final List<Duration> temps;

    public Performance(Voiture auteur, List<Duration> temps) {
        this.auteur = auteur;
        this.temps = temps;
    }

    public Voiture getAuteur() {
        return auteur;
    }

    public List<Duration> getTemps() {
        return temps;
    }

    public Duration getTotalTime() {
        Duration d = Duration.ZERO;

        for (Duration temp : temps) {
            d = d.plus(temp);
        }

        return d;
    }

    @Override
    public String toString() {

        StringBuilder temps = new StringBuilder();

        for (Duration temp : this.temps) {
            temps.append(temp.getSeconds()).append("sec, ");
        }

        return "Performance{" +
                "auteur=" + auteur +
                ", temps=" + temps +
                ", temps total =" + getTotalTime().getSeconds() +
                "sec }";
    }


}
