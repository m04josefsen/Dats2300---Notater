package Dato_08_26_Bubblesort;

import java.util.NoSuchElementException;

public class x1x3x5 {
    public static void main(String[] args) {

    }

    public static void oppgave2() {

    }

    public static void oppgave4() {
        int[] a = {1, 2, 3};
        linærsøk(a, 2, 0, 2);
    }

    public static void oppgave5() {
        //linærsøkIntervall()
    }

    public static void oppgave6() {
        //TODO:
    }

    public static int linærsøk(int[] a, int verdi, int fra, int til) {
        if(a.length < 2) {
            throw new NoSuchElementException();
        }

        if(fra == til || verdi > a[til-1]) {
            return -(til+1);
        }

        int i = fra;
        for(; a[i] < verdi; i++);

        return verdi == a[i] ? i : -(i+1);
    }

    public static int linærsøkIntervall(int[] a, int k, int verdi) {
        if(k < 1) {
            throw new IllegalArgumentException("Lol");
        }

        int j = k - 1;
        for(; j < a.length && verdi > a[j]; j+=k); {}

        int i = j-k+1;
        for(; i < a.length && a[i] == verdi; i++);

        if(i < a.length && a[i] == verdi) {
            return i;
        }

        return -(i+1);
    }}