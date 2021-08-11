package poo.io;

import java.io.*;

public class DemoRead {

    public static void main(String[] args) {

        // try-with-ressource(s) - ferme automatiquement les ressources
//        try( Reader r = new FileReader("ressources/test.csv") ) {
//            System.out.println("fichier ouvert");
//
//            int current;
//            while( (current = r.read()) != -1 ){
//                System.out.print( (char)current );
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("fichier fermé");

        //
        try ( BufferedReader br = new BufferedReader( new FileReader("ressources/test.csv") ) ){

            br.lines()
                    .forEach(System.out::println);

//            String line;
//            while( (line = br.readLine()) != null ){
//                System.out.println(line);
//            }

        }
        catch (IOException ignored){}




    }

}
