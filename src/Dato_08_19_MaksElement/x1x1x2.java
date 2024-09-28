package Dato_08_19_MaksElement;

import java.util.NoSuchElementException;

public class x1x1x2 {
    public static void main(String[] args) {
    }

    public static int oppgave2(int[] a) {
        if(a.length < 1){
            throw new NoSuchElementException("Tabellen er tom!");
        }

        int m = 0;
        for(int i = 1; i < a.length; i++){
            if(a[i] < a[m]) {
                m = i;
            }
        }
        return m;
    }

    public static int oppgave3(int[] a) {
        if(a.length < 1){
            throw new NoSuchElementException("Tabellen er tom!");
        }

        int m = 0;
        for(int i = 1; i < a.length; i++){
            // Legg til >= for å få største elementet, hvis flere like vil det siste støreste bli m
            if(a[i] >= a[m]) {
                m = i;
            }
        }
        return m;
    }
}
