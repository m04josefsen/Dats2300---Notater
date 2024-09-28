package Dato_09_20_Lister;

import java.util.Objects;

interface Beholder <T> { // Collections i standard Java
    boolean leggInn(T t);
    boolean fjern(T t);
    int antall();
    boolean tom(T t);
    boolean inneholder();
    void nullstill();
}

interface List<T> extends Beholder<T> {
    boolean leggInn(int indeks, T t);
    T hent(int indeks);
    T oppdater(int indeks, T t);
    boolean fjern(int indeks);
    int indeksTil(T t);
}

class TabellListe<T> implements List<T> {
    T[] tabellListe;
    int antall;

    @SuppressWarnings("unchecked") // Sjekker ikke etter lenger warning av type "unchecked"
    public TabellListe(int størrelse) {
        antall = 0;
        tabellListe = (T[]) new Object[størrelse];
    }

    public TabellListe() {
        this(10);
    }

    public int antall() {
        return antall;
    }

    @Override
    public boolean tom(T t) {
        return false;
    }

    @Override
    public boolean inneholder() {
        return false;
    }

    @Override
    public void nullstill() {

    }

    @SuppressWarnings("unchecked")
    public boolean leggInn(T t) {
        Objects.requireNonNull(t, "Nullelement ikke lov å legge inn"); // Sjekker om et element er Null, gir videre feilmelding

        if(antall == tabellListe.length) {
            Object[] nyTabellListe = new Object[tabellListe.length * 2];
            for(int i = 0; i < antall; i++) {
                nyTabellListe[i] = tabellListe[i];
            }
            tabellListe = (T[]) nyTabellListe;
        }
        tabellListe[antall++] = t;

        return true;
    }

    @Override
    public boolean fjern(T t) {
        return false;
    }

    public boolean leggInn(int indeks, T t) {
        return true;
    }

    public T hent(int indeks) {
        if(indeks < 0 || indeks >= antall) {
            throw new IndexOutOfBoundsException("Du er utenfor lista");
        }

        return tabellListe[indeks];
    }
    public T oppdater(int indeks, T t){
        T gammelVerdi = tabellListe[indeks];
        tabellListe[indeks] = t;

        return gammelVerdi;
    }
    public boolean fjern(int indeks){throw new UnsupportedOperationException();}
    public int indeksTil(T t){throw new UnsupportedOperationException();}
}

class LenketListe<T> implements List<T> {

    private class Node {
        T verdi;
        Node neste;

        public Node(T verdi, Node neste) {
            this.verdi = verdi;
            this.neste = neste;
        }

        public Node(T verdi) {
            this(verdi, null);
        }

    }

    Node hode;
    int antall;

    // Legger kun inn i starten
    /*
    public boolean leggInn(T t) {
        hode = new Node(t, hode);
        antall++;
        return true;
    }
     */

    public boolean leggInn(int indeks, T t) {
        if(indeks < 0 || indeks >= antall) {
            throw new IndexOutOfBoundsException("Du er utenfor lista");
        }


        Node n = hode;
        Node f = null;
        for(int i = 0; i < indeks; i++) {
            f = n; n = n.neste;
        }

        f.neste = new Node(t, n);

        return true;
    }

    public T hent(int indeks) {
        if(indeks < 0 || indeks >= antall) {
            throw new IndexOutOfBoundsException("Du er utenfor lista");
        }
        Node n = hode;
        for(int i = 0; i < indeks; i++) {
            n = n.neste;
        }

        return n.verdi;
    }

    public T oppdater(int indeks, T t) {
        return null;
    }

    public boolean fjern(int indeks) {
        return false;
    }

    public int indeksTil(T t) {
        return 0;
    }

    public boolean leggInn(T t) {
        return false;
    }

    public boolean fjern(T t) {
        return false;
    }

    public int antall() {
        return antall;
    }

    public boolean tom(T t) {
        return antall == 0;
    }

    public boolean inneholder() {
        return false;
    }

    public void nullstill() {

    }
}

public class Forelesning {

}
