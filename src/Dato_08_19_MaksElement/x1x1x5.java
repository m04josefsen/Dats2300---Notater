package Dato_08_19_MaksElement;

public class x1x1x5 {
    public static void main(String[] args) {
        int[] a = {7};
        int[] b = new int[0];

        System.out.println(oppgave1(a));
        System.out.println(oppgave1(b));

        // Hvis lengden er 1 vil den returnerer riktig indeks, men kan bli mer optimalisert
        // Ved lengde 0 får vi IndexOutOfBounds
    }

    public static int oppgave1(int[] a) {
        int sist = a.length - 1;       // siste posisjon i tabellen
        int m = 0;                     // indeks til største verdi
        int maksverdi = a[0];          // største verdi
        int temp = a[sist];            // tar vare på siste verdi
        a[sist] = 0x7fffffff;          // legger tallet 2147483647 sist

        for (int i = 0; ; i++)         // i starter med 0
            if (a[i] >= maksverdi)       // denne blir sann til slutt
            {
                if (i == sist)             // sjekker om vi er ferdige
                {
                    a[sist] = temp;          // legger siste verdi tilbake
                    return temp >= maksverdi ? sist : m;   // er siste størst?
                }
                else
                {
                    maksverdi = a[i];        // maksverdi oppdateres
                    m = i;                   // m oppdateres
                }
            }
    }
}
