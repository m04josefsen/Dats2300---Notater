package Dato_09_02_Sortering;

import java.util.Arrays;

public class Mergesort {

    private static void flett(int[] a, int[] b, int fra, int m, int til)
    {
        int n = m - fra;                // antall elementer i a[fra:m>
        System.arraycopy(a,fra,b,0,n);  // kopierer a[fra:m> over i b[0:n>

        int i = 0, j = m, k = fra;      // løkkevariabler og indekser

        while (i < n && j < til)        // fletter b[0:n> og a[m:til> og
        {                               // legger resultatet i a[fra:til>
            a[k++] = b[i] <= a[j] ? b[i++] : a[j++];
        }

        while (i < n) a[k++] = b[i++];  // tar med resten av b[0:n>
    }

    private static void flettesortering(int[] a, int[] b, int fra, int til)
    {
        if (til - fra <= 1) return;   // a[fra:til> har maks ett element
        int m = (fra + til)/2;        // midt mellom fra og til

        flettesortering(a,b,fra,m);   // sorterer a[fra:m>
        flettesortering(a,b,m,til);   // sorterer a[m:til>

        if (a[m-1] > a[m]) flett(a,b,fra,m,til);  // fletter a[fra:m> og a[m:til>
    }

    public static void flettesortering(int[] a) {
        int[] b = Arrays.copyOf(a, a.length/2);   // en hjelpetabell for flettingen
        flettesortering(a,b,0,a.length);          // kaller metoden over
    }
}
