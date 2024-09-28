package Dato_08_26_Bubblesort;

import java.util.Arrays;

public class x1x3x3 {
    public static void main(String[] args) {
        oppgave3();
    }

    public static void oppgave1() {
        // Gjort i tabell klassen
    }

    public static void oppgave2() {

    }

    public static void oppgave3() {
        int[] a = {5, 9, 6, 10, 2, 7, 3, 8, 4, 1};
        System.out.println(Arrays.toString(a));

        boblesorteringMotsatt(a);
        System.out.println(Arrays.toString(a));
    }

    public static void boblesorteringMotsatt(int[] a) {
        for(int n = 0; n < a.length-1;) {
            int byttindeks = a.length-1;
            for(int i = a.length-2; i >= n; i--) {
                if(a[i] > a[i+1]) {
                    bytt(a, i, i+1);
                    byttindeks = i;
                }
            }
            n = byttindeks;
        }
    }

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
