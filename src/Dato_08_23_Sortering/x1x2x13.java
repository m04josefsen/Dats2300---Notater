package Dato_08_23_Sortering;

public class x1x2x13 {
    public static void main(String[] args) {

    }

    public static int[] oppgave1(int[] a) {
        int n = a.length;

        if(n < 2) {
            throw new IllegalArgumentException("Illegalt argument");
        }

        int[] b = new int[n*2];
        System.arraycopy(a,0,b,n,n); // Legger a bakerst i b

        for(int i = 2*n-2; i > 1; i-=2) {
            b[i / 2] = Math.max(b[i], b[i + 1]);
        }

        int maksverdi = b[1];
        int nestmaksverdi = Integer.MIN_VALUE;

        for(int i = 2*n-1, j = 2; j < i; j *= 2) {
            int tempverdi = b[j+1];
            if(maksverdi != b[j]) {
                tempverdi = b[j];
                j++;
            }
            if(tempverdi > nestmaksverdi) {
                nestmaksverdi = tempverdi;
            }
        }

        return new int[] {maksverdi, nestmaksverdi};
    }

    //TODO: DENNE
    public static int[] oppgave2(int[] a) {
        int n = a.length;

        if(n < 2) {
            throw new IllegalArgumentException("Illegalt argument");
        }

        int[] b = new int[n*2];
        System.arraycopy(a,0,b,n,n); // Legger a bakerst i b

        for(int i = 2*n-2; i > 1; i-=2) {
            b[i / 2] = Math.max(b[i], b[i + 1]);
        }

        int maksverdi = b[1];
        int nestmaksverdi = Integer.MIN_VALUE;

        for(int i = 2*n-1, j = 2; j < i; j *= 2) {
            int tempverdi = b[j+1];
            if(maksverdi != b[j]) {
                tempverdi = b[j];
                j++;
            }
            if(tempverdi > nestmaksverdi) {
                nestmaksverdi = tempverdi;
            }
        }

        return new int[] {maksverdi, nestmaksverdi};
    }
}
