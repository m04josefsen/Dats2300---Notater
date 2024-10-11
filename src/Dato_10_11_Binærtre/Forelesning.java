package Dato_10_11_Binærtre;

public class Forelesning {
}

        /*
        // Treet har ingen nullverdier
        if (verdi == null) {
            return false;
        }

        // q skal være forelder til p
        Node<T> p = rot, q = null;

        // Leter etter verdi
        while (p != null) {
            // Sammenligner
            int cmp = comp.compare(verdi,p.verdi);
            // Går til venstre
            if (cmp < 0) {
                q = p;
                p = p.venstre;
            }
            // Går til høyre
            else if (cmp > 0) {
                q = p;
                p = p.høyre;
            }
            // Den søkte verdien ligger i p
            else break;
        }

        // Finner ikke verdi
        if (p == null) {
            return false;
        }

        // Tilfelle 1) og 2), p har ett eller ingen barn
        if (p.venstre == null || p.høyre == null) {
            Node<T> b = p.venstre != null ? p.venstre : p.høyre;

            if(b != null) { // TODO: denne er ny
                b.forelder = q;
            }

            if (p == rot) {
                rot = b;
            }
            else if (p == q.venstre) {
                q.venstre = b;
            }
            else {
                q.høyre = b;
            }
        }
        // Tilfelle 3), p har to barn
        else {
            // Finner neste i inorden
            Node<T> s = p, r = p.høyre;
            while (r.venstre != null) {
                // s er forelder til r
                s = r;
                r = r.venstre;
            }

            // kopierer verdien i r til p
            p.verdi = r.verdi;

            if (s != p) {
                s.venstre = r.høyre;
                // TODO: denne er ny
                if(r.høyre != null) {
                    r.høyre.forelder = s;
                }
            }
            else {
                s.høyre = r.høyre;
                // TODO: denne er ny
                if(r.høyre != null) {
                    r.høyre.forelder = s;
                }
            }
        }

        antall--;
        endringer++;
        return true;
         */