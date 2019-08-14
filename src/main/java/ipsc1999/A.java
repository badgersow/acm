package ipsc1999;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class A {

    private static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    private static PrintWriter out = new PrintWriter(System.out);

    private static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws Exception {
        outer:
        for (int t = nextInt(); t > 0; t--) {
            final int n = nextInt(), m = nextInt();
            graph = new List[n];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                int u = nextInt() - 1, v = nextInt() - 1;
                graph[u].add(v);
                graph[v].add(u);
            }

            colors = new int[n];
            used = new boolean[n];

            final List<Integer> order = IntStream.range(0, n).boxed().collect(Collectors.toList());
            Collections.shuffle(order);

            for (int i : order) {
                if (colors[i] > 0) {
                    continue;
                }

                Arrays.fill(used, false);
                boolean result = fill(i);
                if (!result) {
                    out.println(-1);
                    continue outer;
                }
            }

            for (int i = 0; i < n; i++) {
                out.print(colors[i]);
                if (i < n - 1) {
                    out.print(' ');
                }
            }

            out.println();
        }


        out.flush();
    }

    private static List<Integer>[] graph;

    private static int[] colors;

    private static boolean[] used;

    private static final int[][] choices = new int[][]{
            {1, 2, 3},
            {1, 3, 2},
            {2, 1, 3},
            {2, 3, 1},
            {3, 1, 2},
            {3, 2, 1}
    };

    private static final Random r = new Random();

    private static boolean fill(int v) {
        used[v] = true;
        outer:
        for (int tryColor : choices[r.nextInt(3)]) {
            colors[v] = tryColor;
            for (Integer adjacent : graph[v]) {
                if (used[adjacent] && colors[adjacent] == tryColor)
                    continue outer;

                if (!used[adjacent]) {
                    final boolean result = fill(adjacent);
                    if (!result) {
                        continue outer;
                    }
                }
            }

            used[v] = false;
            return true;
        }

        colors[v] = 0;
        used[v] = false;
        return false;
    }


}
