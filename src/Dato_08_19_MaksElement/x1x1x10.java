package Dato_08_19_MaksElement;

import java.util.NoSuchElementException;
import java.util.Random;

public class x1x1x10 {
    public static void main(String[] args) {
        oppgave1();

        // Konklusjon:
            // Programkode 1.1.2 er drastisk treigere enn de to andre, dvs tabell aksessering krever mye tid
            // Programkode 1.1.4 var ikke mye treigere, og noen ganger raskere enn den neste, som vil si vaktpost ikke er svært viktig
    }

    public static void oppgave1() {
        int n = 200000;
        int antall = 2000;
        long tid = 0;
        int a[] = randPerm(n);

        tid = System.currentTimeMillis();
        for(int i = 0; i < antall; i++) {
            kostnader(a);
        }
        tid = System.currentTimeMillis() - tid;
        System.out.println("Faste kostnader: " + tid + "ms");

        tid = System.currentTimeMillis();
        for(int i = 0; i < antall; i++) {
            programkode112(a);
        }
        tid = System.currentTimeMillis() - tid;
        System.out.println("Programkode 1.1.2: " + tid + "ms");

        tid = System.currentTimeMillis();
        for(int i = 0; i < antall; i++) {
            programkode114(a);
        }
        tid = System.currentTimeMillis() - tid;
        System.out.println("Programkode 1.1.4: " + tid + "ms");

        tid = System.currentTimeMillis();
        for(int i = 0; i < antall; i++) {
            programkode115(a);
        }
        tid = System.currentTimeMillis() - tid;
        System.out.println("Programkode 1.1.5: " + tid + "ms");

    }

    public static int kostnader(int[] a) {
        int m = 0;
        for(int i = 0; i < a.length; i++) {
        }
        return m;
    }

    // Versjon 1
    public static int programkode112(int[] a) {
        if(a.length < 1){
            throw new NoSuchElementException("Tabellen er tom!");
        }

        int m = 0;
        for(int i = 1; i < a.length; i++){
            if(a[i] > a[m]) {
                m = i;
            }
        }
        return m;
    }

    // Versjon 2; lagerer maksverdi i en variabel;
    public static int programkode114(int[] a) {
        if(a.length < 1){
            throw new NoSuchElementException("Tabellen er tom!");
        }

        int m = 0;
        int maksverdi = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] > maksverdi) {
                maksverdi = a[i];
                m = i;
            }
        }
        return m;
    }

    public static int programkode115(int[] a) {
        int sist = a.length - 1;
        int m = 0;
        int maksverdi = a[0];
        int temp = a[sist];
        a[sist] = 0x7fffffff;

        for (int i = 0; ; i++) {
            if (a[i] >= maksverdi) {
                if (i == sist) {
                    a[sist] = temp;
                    return temp >= maksverdi ? sist : m;
                } else {
                    maksverdi = a[i];
                    m = i;
                }
            }
        }
    }

    public static int[] randPerm(int n) {
        Random r = new Random();      // en randomgenerator
        int[] a = new int[n];         // en tabell med plass til n tall

        for (int i = 0; i < n; i++)
            a[i] = r.nextInt(n) + 1;    // tabellen fylles med tall

        return a;                     // tabellen returneres
    }
}
