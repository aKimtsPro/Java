package exo.course;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

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

    // EXO 1
    // l'ensemble des Performances réalisées par un pilote donné
    public List<Performance> getPerformanceBy(String pilote){
        return leaderboard.stream()
                .filter( perf -> perf.getAuteur().getNomPilote().equals(pilote) )
                .collect( Collectors.toList() );
    }

    // EXO 2
    // les différents noms des pilotes ayant parcouru le circuit
    public List<String> getDistinctPilotes(){
        return leaderboard.stream()
                .map( perf -> perf.getAuteur().getNomPilote() )
                .distinct()
                .collect(Collectors.toList());
    }

    // EXO 3
    // le temps total en sec passé sur le circuit pour les perfomances
    public long getTotalTimeOnTrack(){

//        long total = leaderboard.stream()
//                .map(perf -> perf.getTotalTime())
//                .reduce((acc, add) -> acc.plus(add) )
//                .get()
//                .getSeconds();

        long total = leaderboard.stream()
                .map( Performance::getTotalTime )
                .reduce(Duration.ZERO, Duration::plus)
                .getSeconds();

//        long total = leaderboard.stream()
//                .map(perf -> perf.getTotalTime().getSeconds())
//                .reduce((acc, add) -> acc + add )
//                .get();

//        long total = leaderboard.stream()
//                .map(perf -> perf.getTotalTime().getSeconds())
//                .reduce(0L, (acc, add) -> acc + add );

//        long total = leaderboard.stream()
//                .mapToLong(perf -> perf.getTotalTime().getSeconds())
//                .sum();

        return total;

    }


    @Override
    public String toString() {


        return "-- Circuit --" +
                "\nnbrTour=" + nbrTour +
                "\nnom='" + nom + '\'' +
                "\nlongueurTour=" + longueurTour +
                "\nleaderboard=[\n" + getLeaderboard() +"]" ;
    }
}
