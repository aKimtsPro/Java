package poo.generics;

import java.util.Arrays;

public class Boite<C> {

    private final Object[] contenu;
    private final int capacite;
    private int nbrContenu = 0;

    public Boite(int capacite) {
        this.capacite = capacite;
        contenu = new Object[capacite];
    }

    public int ajouter(C toAdd){
        if( nbrContenu < capacite ){
            contenu[nbrContenu] = toAdd;
            nbrContenu++;
            return nbrContenu - 1;
        }
        return -1;
    }

    public C retirer(int index){

        if(index >= capacite || index < 0)
            throw new IllegalArgumentException();

        C o = (C)contenu[index];
        contenu[index] = null;

        for (int i = index+1; i < contenu.length && contenu[i] != null; i++) {
            contenu[i-1] = contenu [i];
            contenu[i] = null;
        }

        nbrContenu--;

        return o;
    }

    public int indexOf(C o){
        for (int i = 0; i < nbrContenu; i++) {
            if( contenu[i] == o ){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Boite{" +
                "\n\tcontenu=" + Arrays.toString(contenu) +
                "\n\t, capacite=" + capacite +
                "\n\t, nbrContenu=" + nbrContenu +
                '}';
    }

    public int getCapacite() {
        return capacite;
    }

    public int getNbrContenu() {
        return nbrContenu;
    }
}
