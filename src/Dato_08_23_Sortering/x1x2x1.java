package Dato_08_23_Sortering;

public class x1x2x1 {
    public static void main(String[] args) {

    }

    public static int oppgave1(int[] a, int fra, int til) {
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

    public static int oppgave1min(int[] a) {
        return oppgave1(a, 0, a.length);
    }

    public static void oppgave4() {
        // Fra løsningsforslag
        // binarySearch, compare, compareUnsigned, copyOfRange, equals, fill, mismatch, parallelPrefix, parellelSort, sort
        //Arrays.sort();
    }

    public static void oppgave5() {
        int[] liste = {1, 2, 3, 4, 5};

        for(int i : liste) {
            System.out.println(i);
        }
    }
}
