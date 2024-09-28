package Dato_09_02_Sortering;

public class Quicksort {

    // Sorter hele tabellen
    public static void kvikksortering(int[] a) {
        kvikksortering(a, 0, a.length - 1);
    }

    // a[venster:høyre]
    private static void kvikksortering0(int[] a, int v, int h) {
        if(v >= h) {
            return;
        }
        int k = sParter0(a, v, h, (v+h) / 2);

        kvikksortering0(a, v, k - 1);
        kvikksortering0(a, k + 1, h);

    }

    // a[fra:til>
    public static void kvikksortering(int[] a, int fra, int til) {
        fratilKontroll(a.length, fra, til);  // sjekker når metoden er offentlig
        kvikksortering0(a, fra, til - 1);  // v = fra, h = til - 1
    }

    private static int sParter0(int[] a, int v, int h, int indeks) {
        bytt(a, indeks, h);           // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0(a, v, h - 1, a[h]);  // partisjonerer a[v:h - 1]
        bytt(a, pos, h);              // bytter for å få skilleverdien på rett plass
        return pos;                   // returnerer posisjonen til skilleverdien
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

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void fratilKontroll(int tablengde, int fra, int til) {
        if (fra < 0) {
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");
        }

        if (til > tablengde) {
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");
        }

        if (fra > til) {
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
        }
    }
}
