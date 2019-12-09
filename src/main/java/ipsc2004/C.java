package ipsc2004;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            final int n = in.nextInt(), m = in.nextInt();
            final int[][] costs = new int[n * (n - 1) / 2][];

            int index = 0;
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < u; v++) {
                    costs[index++] = new int[]{u, v, in.nextInt()};
                }
            }

            Arrays.sort(costs, Comparator.comparingInt(a -> a[2]));
        }
    }

}
