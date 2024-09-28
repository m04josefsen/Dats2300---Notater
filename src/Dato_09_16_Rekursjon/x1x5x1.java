package Dato_09_16_Rekursjon;

public class x1x5x1 {
    public static void main(String[] args) {
        System.out.println(oppgave7(3));
    }

    public static int oppgave1(int n) {
        int resultat = 0;



        for(int i = 0; i < n; i++) {
        }

        return resultat;
    }

    // Regner 1^2 + 2^2 + ... + n^2
    public static int oppgave7(int n) {
        if(n == 1) {
            return 1;
        }

        return n*n + oppgave7(n-1);
    }

    // Regner n!
    public static int oppgave10(int n) {
        if(n == 1) {
            return 1;
        }

        return n * oppgave10(n-1);
    }

    public static int oppgave13(int n) {
        return 0;
    }


}
