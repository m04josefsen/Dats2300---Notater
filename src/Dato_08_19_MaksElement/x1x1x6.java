package Dato_08_19_MaksElement;

public class x1x1x6 {
    public static void main(String[] args) {

    }

    public static void oppgave1() {
        // 5 først = 0
        // 5 andre = 24
        // 5 tredje = 36
        // 5 fjerde = 44
        // 5 femte = 50
        // (0 + 24 + 36 + 44 + 50) / 120 = 154 / 120 = 1 / 2 + 1 / 3 + 1 / 4 + 1 / 5
    }

    public static double oppgave4(int n) {
        return harmonisk(n) - Math.log(n);
    }

    public static double harmonisk(int n)
    {
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0/i;
        }
        return sum;
    }
}
