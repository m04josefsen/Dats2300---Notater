package Dato_08_19_MaksElement;

public class x1x1x3 {
    public static void main(String[] args) {
        System.out.println(oppgave6(3));
    }

    public static void oppgave5(int[] a) {

    }

    public static long oppgave6(int n) {
        long sum = 1;

        while (n > 0) {
            sum *= n;
            n -= 1;
        }

        return sum;

        // Utføres N multiplikasjoner
    }
}
