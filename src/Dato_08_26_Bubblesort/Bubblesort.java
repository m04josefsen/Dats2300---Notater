package Dato_08_26_Bubblesort;

import java.util.Arrays;

public class Bubblesort {
    public static void main(String[] args) {
        int[] tabell = {2, 1, 3, 4, 7, 5, 4, 1};
        System.out.println(Arrays.toString(tabell));

        bubblesort(tabell);
        System.out.println(Arrays.toString(tabell));
    }

    public static void bubblesort(int[] tabell) {
        for (int i = tabell.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (tabell[j] > tabell[j + 1]) {
                    bytt(tabell, j, j + 1);
                }
            }
        }
    }

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
