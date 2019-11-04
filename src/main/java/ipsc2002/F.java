package ipsc2002;

import com.google.common.base.Preconditions;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class F {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        int maxN = Integer.MIN_VALUE;
        while (true) {
            final int n = in.nextInt();

            if (n == -1) {
                break;
            }

            final int m = in.nextInt();

            final int[] scores = new int[n];
            for (int i = 0; i < n; i++) {
                scores[i] = in.nextInt();
            }

            final Set<Integer>[] edges = new HashSet[n];

            for (int i = 0; i < n; i++) {
                edges[i] = new HashSet<>();
            }

            for (int i = 0; i < m; i++) {
                final int u = in.nextInt() - 1, v = in.nextInt() - 1;
                Preconditions.checkState(!edges[u].contains(v));

                edges[u].add(v);
                edges[v].add(u);
            }

            maxN = Math.max(maxN, n);
        }

        System.out.println(maxN);
    }

}
