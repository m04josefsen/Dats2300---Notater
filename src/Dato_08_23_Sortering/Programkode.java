package Dato_08_23_Sortering;

public class Programkode {

    // Halvåpent tabell intervall (dvs fra og med, til men ikke med); [fra:til>
    public static int programkode121(int[] a, int fra, int til) {
        if(fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Illegalt argument");
        }

        int m = fra; // Indeks til største verdi, starter fra starten
        int maksverdi = a[m];

        for(int i = fra+1; i < til; i++) {
            if(a[i] > maksverdi) {
                m = i;
                maksverdi = a[i];
            }
        }
        return m;
    }

    public static int programkode112maks(int[] a) {
        return programkode121(a, 0, a.length);
    }

    // Lukket tabell intervall; [v:h]
    public static int lukketTabellIntervall(int[] a, int v, int h) { // v = venstre, h = høyre
        if(v < 0 || h >= a.length || v >= h) {
            throw new IllegalArgumentException("Illegalt argument");
        }

        int m  = v;
        int maksverdi = a[m];

        for(int i = v+1; i <= h; i++) {
            if(a[i] > maksverdi) {
                m = i;
                maksverdi = a[i];
            }
        }
        return m;
    }
}
