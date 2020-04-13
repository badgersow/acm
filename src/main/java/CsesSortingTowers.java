import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class CsesSortingTowers {

    public static void main(String[] args) throws Exception {
        new CsesSortingTowers().solve();
    }

    private StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    private PrintWriter out = new PrintWriter(System.out);

    private int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    public void solve() throws Exception {
        final int n = nextInt();
        final int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }

        out.println(lis(a));
        out.flush();
    }

    public static int lis(int[] a) {
        final int n = a.length;
        final int[] d = new int[n + 1]; // d[i] is the value of the element, in which IS of length i ends
        int inf = Integer.MAX_VALUE / 2;
        Arrays.fill(d, inf);
        d[0] = -inf;

        int lisLength = 0;
        for (final int current : a) {
            // Find largest i with d[i] smaller than current
            int l = 0, r = lisLength;
            while (l + 1 < r) {
                int w = (l + r) / 2;
                if (d[w] <= current) {
                    l = w;
                } else {
                    r = w;
                }
            }

            final int i = (d[r] <= current) ? r : (d[l + 1] < current) ? l + 1 : l;

            d[i + 1] = Math.min(d[i + 1], current);
            lisLength = Math.max(lisLength, i + 1);
        }

        return lisLength;
    }
}
