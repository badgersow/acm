package ipsc2007;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class I {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        for (int T = in.nextInt(); T > 0; T--) {
            final int n = in.nextInt();
            final double[][] d = new double[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    d[i][j] = 100.0 / in.nextInt();
                }
            }

            final int m = in.nextInt();
            final Set<Integer> canStore = new HashSet<>();
            for (int i = 0; i < m; i++) {
                canStore.add(in.nextInt() - 1);
            }

            final int s = in.nextInt();

            // 1. First round of Floyd Warshall - calculate distances without memorizing
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        d[i][j] = Math.min(
                                d[i][j],
                                d[i][k] * d[k][j]
                        );
                    }
                }
            }

            // 2. Second round - distances between memorized computers using other formula
            for (Integer k : canStore) {
                for (Integer i : canStore) {
                    for (Integer j : canStore) {
                        d[i][j] = Math.min(
                                d[i][j],
                                d[i][k] + d[k][j]
                        );
                    }
                }
            }

            System.out.println(String.format("%.9f", s * d[0][1]));
        }
    }

}
