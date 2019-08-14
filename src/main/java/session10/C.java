package session10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class C {

    private static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    private static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws Exception {
        final int n = nextInt();
        final int[][] a = new int[n][n];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                a[i][j] = nextInt();
            }
        }

        long[] sumDiag = new long[2 * n - 1];
        long[] diffDiag = new long[2 * n - 1];

        for (int sum = 0; sum <= 2 * (n - 1); sum++) {
            for (int i = 0; i < n; i++) {
                if (sum - i < 0 || sum - i >= n) {
                    continue;
                }
                sumDiag[sum] += a[i][sum - i];
            }
        }

        for (int diff = -n + 1; diff <= n - 1; diff++) {
            for (int i = 0; i < n; i++) {
                if (i - diff < 0 || i - diff >= n) {
                    continue;
                }
                diffDiag[n - 1 + diff] += a[i][i - diff];
            }
        }

        long evenBishop = -1;
        long oddBishop = -1;
        int evenI = 0, evenJ = 0;
        int oddI = 0, oddJ = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                final long sumDiagonal = sumDiag[i + j];
                final long diffDiagonal = diffDiag[n - 1 + i - j];
                long diagonal = sumDiagonal + diffDiagonal - a[i][j];

                if ((i + j) % 2 == 0) {
                    if (diagonal > evenBishop) {
                        evenBishop = diagonal;
                        evenI = i + 1;
                        evenJ = j + 1;
                    }
                } else {
                    if (diagonal > oddBishop) {
                        oddBishop = diagonal;
                        oddI = i + 1;
                        oddJ = j + 1;
                    }
                }
            }
        }

        System.out.println(evenBishop + oddBishop);
        System.out.println(evenI + " " + evenJ + " " + oddI + " " + oddJ);
    }

}
