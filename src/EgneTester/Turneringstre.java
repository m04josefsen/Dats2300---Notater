package EgneTester;

import java.util.Arrays;

public class Turneringstre {
    public static void main(String[] args) {
        //2n i størrelse
        int[] tabell = {2, 1, 3, 4, 7, 5, 4, 1};
        System.out.println(Arrays.toString(tabell));
        System.out.println("---");

        int[] turneringstre = turneringstre(tabell);
        System.out.println(Arrays.toString(turneringstre));

    }

    public static int[] turneringstre(int[] a) {
        int[] turnering = new int[2*a.length];

        // Setter inn verdier bakerst i tabellen
        int teller = 0;
        for(int i = a.length; i < turnering.length; i++){
            turnering[i] = a[teller];
            teller++;
        }


        for(int i = a.length; i < turnering.length; i+=2){
            int indeks1 = i;
            int indeks2 = i+1;

            int verdi1 = turnering[indeks1];
            int verdi2 = turnering[indeks2];
            int nyIndeks = indeks1 / 2;

            if(verdi1 >= verdi2) {
                turnering[nyIndeks] = verdi1;
            }
            else {
                turnering[nyIndeks] = verdi2;
            }
        }

        return turnering;
    }
}
