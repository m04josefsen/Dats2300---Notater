package Dato_08_23_Sortering;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Sortering {

    public static void main(String[] args) {
        int[] liste = {1, 4, 1, 2, 5, 8, 10};

        sorter(liste);

        /*
        for(int i : liste) {
            System.out.println(i);
        }
         */

        System.out.println(Arrays.toString(liste));
    }

    public static int maksIndeks(int[] a, int fra, int til) {
        if(a.length < 1){
            throw new NoSuchElementException("Tabellen er tom!");
        }

        int m = fra;
        int maksverdi = a[fra];

        for (int i = fra+1; i < til; i++) {
            if (a[i] > maksverdi) {
                maksverdi = a[i];
                m = i;
            }
        }
        return m;
    }

    public static int maksIndeks(int[] a) {
        return maksIndeks(a, 0, a.length);
    }

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sorter(int[] a) {
        for(int i = a.length; i > 0; i--) {
            int maks = maksIndeks(a, 0, i);
            bytt(a, maks, i-1);
        }
    }
    /*
    - Hvor effektiv er algoritmen?
        - Bruker ca 4n steg på å finne makselement
        - Må gjøre:
            - 4n + 4(n-1) + 4(n-2) + ... + 4 * 2 + 4 * 1
        - Finnes formel for 1 + 2 + 3 ... + n = (n * (n+1)) / 2
        - Vi får derfor 4 * (n * (n+1)) / 2 = 2n^2 + 2n
        - Dette er en O(n^2) algoritme
     */
}
