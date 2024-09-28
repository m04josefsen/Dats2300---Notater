package Dato_09_16_Rekursjon;

public class Forelesning {
    public static void main(String[] args) {
        //System.out.println(sumTil(7));
        //System.out.println(fib(7));
        //hanoisTårn(8, 'A', 'B', 'C');
    }
    /*

    public static int sumTil(int n) {
        int resultat = 0;

        if(n < 0) {
            throw new IllegalArgumentException();
        }

        if(n == 0) {
            return 0;
        }

        System.out.println("Begynner metode sumTil: " + n);

        resultat = n + sumTil(n-1);
        System.out.println("Avslutter metode sumTil: " + n);
        return resultat;
    }

    public static int fib(int n) {
        System.out.println("Begunner fib n: " + n);
        if(n < 0) {
            throw new IllegalArgumentException();
        }
        if(n < 2) {
            return 1;
        }

        int resultat = fib(n-1) + fib(n-2);
        System.out.println("Avslutter fib n: " + n);
        return resultat;
    }

    public static void hanoisTårn(int n, char fra, char hjelp, char til) {
        if(n <= 0) {
            return;
        }

        hanoisTårn(n-1, fra, til, hjelp);
        System.out.println("Flytt disk fra: " + fra + ", til: " + til + "");
        hanoisTårn(n-1, hjelp, fra, til);
    }

    public static void quickSortIterativ(int[] tabell) {
        int fra = 0;
        int til = tabell.length - 1;

        if(fra >= til) return;

        int k = parti
    }

    // Quicksort
    public static void quicksort(int[] tabell) {
        quicksort(tabell, 0, tabell.length-1);
    }

    public static void quicksort(int[] tabell, int fra, int til) {
        if (fra >= til) return;

        bytt(tabell, til, fra + (til-fra)/2);
        int pivot = tabell[til];
        int v = fra, h = til-1;
        while (true) {
            while (v <= h && tabell[v] < pivot) v++;
            while (v <= h && tabell[h] >= pivot) h--;
            if (v >= h) break;
            bytt(tabell, v++, h--);
        }
        bytt(tabell, til, v);
        quicksort(tabell, fra, v-1);
        quicksort(tabell, v+1, til);
    }

    public static void bytt(int[] tabell, int i, int j) {
        int tmp = tabell[i];
        tabell[i] = tabell[j];
        tabell[j] = tmp;
    }
     */
}
