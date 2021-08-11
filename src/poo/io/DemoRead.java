package poo.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DemoRead {

    public static void main(String[] args) {

//        StringBuilder sb = new StringBuilder();
//        Reader r1 = null;
//        try {
//            r1 = new FileReader("ressources/test.csv");
//
//            // debut
//            int current;
//            while( (current = r1.read()) != -1 ){
//                sb.append((char)current);
//            }
//            // fin
//
//        }
//        catch (FileNotFoundException ex){
//            System.out.println("fichier pas trouvé");
//        }
//        catch (IOException ex){
//            ex.printStackTrace();
//        }
//        finally {
//            if( r1 != null ) {
//                try {
//                    r1.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        System.out.println( sb );


        // try-with-ressource(s) - ferme automatiquement les ressources
//        List<Character> characterList = new ArrayList<>();
//        try ( Reader r = new FileReader("ressources/test.csv" ) ) {
//            System.out.println("fichier ouvert");
//
//            int current;
//            while( (current = r.read()) != -1 ){
//                characterList.add( (char)current );
//            }
//
//        } catch (IOException e) {
//            System.out.println("une erreur s'est produite");
//            e.printStackTrace();
//        }
//        System.out.println("fichier fermé");
//        characterList
//                .forEach(System.out::print);

        //

        List<Personne> pers = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader( new FileReader("ressources/test.csv") ) ){

//            br.lines()
//                    .forEach(System.out::println);

            br.readLine(); // skip the title line

            String line;
            Personne p = null;
            while( (line = br.readLine()) != null ){
                p = new Personne();

                String[] values = line.split(",");

                p.setId( Long.parseLong(values[0]) );
                p.setPrenom( values[1] );
                p.setNom( values[2] );
                p.setEmail( values[3] );
                p.setProfession( values[4] );

                pers.add( p );
            }
        }
        catch (IOException ignored){}

        pers.forEach(System.out::println);




    }

}
