package poo.io;

import java.io.*;

public class DemoRead {

    public static void main(String[] args) {

        try(BufferedReader r = new BufferedReader(new FileReader("./ressources/test.csv"))) {
            r.lines().skip(1)
                    .map(e -> {
                        String[] tab =  e.split(",");
                        if(tab.length != 5)
                            throw new RuntimeException("trop de partie, a corriger");

                        return tab;

                    } ).forEach(strings -> {
                for (String string : strings) {
                    System.out.print(string+", ");
                }
                System.out.println();
            });
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

}
