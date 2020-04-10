import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class CsesSortingStickLengths {

    public static void main(String[] args) throws Exception {
        new CsesSortingStickLengths().solve();
    }

    private StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    private PrintWriter out = new PrintWriter(System.out);

    private int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    private String nextString() throws Exception {
        in.nextToken();
        return in.sval;
    }

    public void solve() throws Exception {
        final int n = nextInt();
        final int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }

        Arrays.sort(a);

        final int median = a[n / 2];
        long cost = 0L;

        for (int i = 0; i < a.length; i++) {
            cost += Math.abs(a[i] - median);
        }

        out.println(cost);
        out.flush();
    }
}
