package exo.course;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Circuit {

    private final int nbrTour;
    private final String nom;
    private final int longueurTour;
    private final List<Performance> leaderboard = new ArrayList<>();

    public Circuit(int nbrTour, String nom, int longueurTour) {
        this.nbrTour = nbrTour;
        this.nom = nom;
        this.longueurTour = longueurTour;
    }


    public void concourir(Voiture concurrent){

        List<Duration> temps = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < nbrTour; i++) {
            double vitesseTour = concurrent.getVitesseMoyenne()/10. *  ((r.nextDouble()*4)+8);
            double hour = longueurTour / vitesseTour;
            long millisecond = (long) (hour * 3600000);
            temps.add( Duration.ofMillis(millisecond) );
        }

        leaderboard.add(new Performance(concurrent,temps));

    }


    public int getNbrTour() {
        return nbrTour;
    }

    public String getNom() {
        return nom;
    }

    public int getLongueurTour() {
        return longueurTour;
    }

    public List<Performance> getLeaderboard() {
        return leaderboard;
    }

    @Override
    public String toString() {
        return "-- Circuit --" +
                "\nnbrTour=" + nbrTour +
                "\nnom='" + nom + '\'' +
                "\nlongueurTour=" + longueurTour +
                "\nleaderboard=" + leaderboard ;
    }
}
