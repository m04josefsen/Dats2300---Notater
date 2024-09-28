package Dato_08_23_Sortering;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Tabell {
    private Tabell() {} // Hindrer instansiering av klassen

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void bytt(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }

    public static void randPerm(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--) {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a, k, i);
        }
    }

    public static int maks(int[] a, int fra, int til) {
        if(fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Illegalt argument");
        }

        int m = fra;
        int maksverdi = a[m];

        for(int i = fra+1; i < til; i++) {
            if(a[i] > maksverdi) {
                m = i;
                maksverdi = a[i];
            }
        }
        return m;
    }

    public static int maks(int[] a) {
        return maks(a, 0, a.length);
    }

    public static int min(int[] a, int fra, int til) {
        if(fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Illegalt argument");
        }

        int m = fra;
        int minverdi = a[m];

        for(int i = fra+1; i < til; i++) {
            if(a[i] < minverdi) {
                m = i;
                minverdi = a[i];
            }
        }
        return m;
    }

    public static int min(int[] a) {
        return min(a, 0, a.length);
    }

    public int[] nestMaks(int[] a, int fra, int til) {
        if(a.length < 2) {
            throw new NoSuchElementException();
        }

        int m = 0;
        int nm = 1;

        if(a[1] > a[0]) {
            m = 1;
            nm = 0;
        }

        int maksverdi = a[m];
        int nestmaksverdi = a[nm];

        for(int i = fra+1; i < til; i++) {
            if(a[i] > nestmaksverdi) {
                if(a[i] > maksverdi) {
                    nm = m;
                    m = i;
                    nestmaksverdi = maksverdi;
                    maksverdi = a[i];
                }
                else {
                    nm = i;
                    nestmaksverdi = a[i];
                }
            }
        }

        return new int[]{m, nm};
    }

    public int[] nestMaks(int[] a) {
        return nestMaks(a, 0, a.length);
    }

    public int[] nestMinst(int[] a, int fra, int til) {
        if(a.length < 2) {
            throw new NoSuchElementException();
        }

        int m = 0;
        int nm = 1;

        if(a[1] < a[0]) {
            m = 1;
            nm = 0;
        }

        int minstverdi = a[m];
        int nestminstverdi = a[nm];

        for(int i = fra+1; i < til; i++) {
            if(a[i] < nestminstverdi) {
                if(a[i] < minstverdi) {
                    nm = m;
                    m = i;
                    nestminstverdi = minstverdi;
                    minstverdi = a[i];
                }
                else {
                    nm = i;
                    nestminstverdi = a[i];
                }
            }
        }

        return new int[]{m, nm};
    }

    public int[] nestMinst(int[] a) {
        return nestMinst(a, 0, a.length);
    }
}
