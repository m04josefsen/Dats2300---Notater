package Dato_09_02_Sortering;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Tabell {
    private Tabell() {} // Hindrer instansiering av klassen

    public static void main(String[] args) {
        int[] a = {5, 9, 6, 10, 2, 7, 3, 8, 4, 1};

        System.out.println(Arrays.toString(a));
        boblesortering(a);
        System.out.println(Arrays.toString(a));
    }

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

    public static int inversjoner(int[] a) {
        int antall = 0;
        for(int i = 0; i < a.length; i++) {
            for(int j = i+1; j < a.length; j++) {
                if(a[i] > a[j]) {
                    antall++;
                }
            }
        }
        return antall;
    }

    public boolean erSortert(int[] a) {
        for(int i = 1; i < a.length; i++) {
            if(a[i-1] > a[i]) {
                return false;
            }
        }
        return true;
    }

    public static int boble(int[] a) {
        int antall = 0;
        for(int i = 1; i < a.length; i++) {
            if(a[i-1] > a[i]) {
                bytt(a, i-1, i);
                antall++;
            }
        }
        return antall;
    }

    public static void boblesortering(int[] a) {
        for(int n = a.length; n > 1;) {
            int byttindeks = 0;
            for(int i = 1; i < n; i++) {
                if(a[i-1] > a[i]) {
                    bytt(a, i-1, i);
                    byttindeks = i;
                }
            }
            n = byttindeks;
        }
    }

    public static int linærsøk(int[] a, int verdi) {
        if(a.length == 0 || verdi > a[a.length-1]) {
            return -(a.length-1);
        }

        int i = 0;
        for(; a[i] < verdi; i++);

        return verdi == a[i] ? i : -(i+1);
    }

    public static void fratilKontroll(int tablengde, int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    public static int binærsøk(int[] a, int fra, int til, int verdi) {
        fratilKontroll(a.length, fra, til);
        int v = fra;
        int h = til-1;

        while(v < h) {
            int m = (v + h) / 2;

            if(verdi > a[m]) {
                v = m + 1;
            }
            else {
                h = m;
            }
        }
        if(h < v || verdi < a[v]) {
            return -(v+1); // Ikke funnet
        }
        else if(verdi == a[v]) {
            return v; // Funnet
        }
        else {
            return -(v+2); // Ikke funnet
        }
    }

    public static int binærsøk(int[] a, int verdi)  // søker i hele a
    {
        return binærsøk(a,0,a.length,verdi);  // bruker metoden over
    }

    private static int parter0(int[] a, int v, int h, int skilleverdi) {
        while (true)                                  // stopper når v > h
        {
            while (v <= h && a[v] < skilleverdi) v++;   // h er stoppverdi for v
            while (v <= h && a[h] >= skilleverdi) h--;  // v er stoppverdi for h

            if (v < h) bytt(a, v++, h--);                 // bytter om a[v] og a[h]
            else return v;  // a[v] er nåden første som ikke er mindre enn skilleverdi
        }
    }

    private static int sParter0(int[] a, int v, int h, int indeks)
    {
        bytt(a, indeks, h);           // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0(a, v, h - 1, a[h]);  // partisjonerer a[v:h - 1]
        bytt(a, pos, h);              // bytter for å få skilleverdien på rett plass
        return pos;                   // returnerer posisjonen til skilleverdien
    }

    public static int kvikksøk(int[] a, int m)
    {
        if (m < 0 || m >= a.length)
            throw new IllegalArgumentException("m(" + m + ") er ulovlig!");

        int v = 0, h = a.length - 1;  // intervallgrenser

        while (true)
        {
            int k = sParter0(a,v,h,(v + h)/2);   // se Programkode 1.3.9 f)
            if (m < k) h = k - 1;
            else if (m > k) v = k + 1;
            else return k;
        }
    }

    public static int flett(int[] a, int m, int[] b, int n, int[] c)
    {
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) c[k++] = a[i] <= b[j] ? a[i++] : b[j++];

        while (i < m) c[k++] = a[i++];   // tar med resten av a
        while (j < n) c[k++] = b[j++];   // tar med resten av b

        return k;   // antallet verdier som er lagt inn i c
    }

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

    public static void flettesortering(int[] a)
    {
        int[] b = Arrays.copyOf(a, a.length/2);   // en hjelpetabell for flettingen
        flettesortering(a,b,0,a.length);          // kaller metoden over
    }

    public static int union(int[] a, int m, int[] b, int n, int[] c)
    {
        int i = 0, j = 0, k = 0;             // indekser for a, b og c
        while (i < m && j < n)
        {
            if (a[i] < b[j]) c[k++] = a[i++];  // tar med a[i]
            else if (a[i] == b[j])             // a[i] og b[j] er like
            {
                c[k++] = a[i++]; j++;            // tar med a[i], men ikke b[j]
            }
            else  c[k++] = b[j++];             // tar med b[j]
        }

        while (i < m) c[k++] = a[i++];       // tar med resten av a[0:m>
        while (j < n) c[k++] = b[j++];       // tar med resten av b[0:n>

        return k;                            // antall verdier i unionen
    }

    public static int union(int[] a, int[] b, int[] c)
    {
        return union(a, a.length, b, b.length, c);
    }

    public static int snitt(int[] a, int m, int[] b, int n, int[] c)
    {
        int i = 0, j = 0, k = 0;             // indekser for a, b og c
        while (i < m && j < n)
        {
            if (a[i] < b[j]) i++;              // hopper over a[i]
            else if (a[i] == b[j])             // a[i] og b[j] er like
            {
                c[k++] = a[i++]; j++;            // tar med a[i], men ikke b[j]
            }
            else  j++;                         // hopper over b[j]
        }

        return k;                            // antall i snittet
    }

    public static int snitt(int[] a, int[] b, int[] c)  // hele tabeller
    {
        return snitt(a, a.length, b, b.length, c);
    }

}
