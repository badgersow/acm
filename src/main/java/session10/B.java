package session10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class B {
    private static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    private static PrintWriter out = new PrintWriter(System.out);

    private static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws Exception {
        final int n = nextInt();
        final int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = nextInt();
        }

        long currentHeight = 0, energy = 0, moneySpent = 0;
        for (int i = 0; i < n; i++) {
            final long energyIncrease = currentHeight - a[i];
            if (energyIncrease >= 0 || energy >= -energyIncrease) {
                // just jump
                energy += energyIncrease;
            } else {
                // spend money
                moneySpent += -(energy + energyIncrease);
                energy = 0;
            }
            currentHeight = a[i];
        }

        out.println(moneySpent);
        out.flush();
    }

}
