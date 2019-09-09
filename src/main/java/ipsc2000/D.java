package ipsc2000;

import org.apache.commons.lang3.tuple.Pair;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D {

    private static int n, m, c;
    private static List<Pair<Integer, Integer>>[] d;
    private static boolean[] visited;

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final PrintWriter out = new PrintWriter(System.out);

        n = in.nextInt();
        m = in.nextInt();
        c = in.nextInt();
        d = new ArrayList[n + 1];
        for (int i = 0; i < d.length; i++) {
            d[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            final int u = in.nextInt() - 1, v = in.nextInt() - 1, dist = in.nextInt();
            d[u].add(Pair.of(v, dist));
            d[v].add(Pair.of(u, dist));
        }

        visited = new boolean[n + 1];
        out.println(solve(0));
        out.flush();
    }

    private static int solve(int v) {
        if (v == n - 1) {
            // Already at the destination
            return 0;
        }

        visited[v] = true;
        int best = Integer.MAX_VALUE;
        for (Pair<Integer, Integer> child : d[v]) {
            int u = child.getLeft(), dist = child.getRight();

            if (visited[u]) {
                continue;
            }

            int childSolution = solve(u);
            if (childSolution == -1) {
                continue;
            }

            int needInCurrentNode = needToHave(childSolution, dist);
            best = Math.min(best, needInCurrentNode);
        }

        return best == Integer.MAX_VALUE ? -1 : best;
    }

    private static int needToHave(int needInChild, int dist) {
        if (dist > c) {
            // Impossible to get there
            return Integer.MAX_VALUE;
        }

        if (needInChild <= c - dist) {
            // Single trip
            return needInChild + dist;
        }

        if (dist * 2 >= c) {
            // Impossible to leave something
            return Integer.MAX_VALUE;
        }

        // One last trip with full tank
        int solution = c;
        int leftNeeded = needInChild - (c - dist);

        // Half trips
        int halfTrips = leftNeeded / (c - 2 * dist);
        solution += (halfTrips * c);

        leftNeeded = leftNeeded % (c - 2 * dist);
        if (leftNeeded > 0) {
            // Partial half trip (if needed)
            solution += leftNeeded + (2 * dist);
        }

        return solution;
    }


}
