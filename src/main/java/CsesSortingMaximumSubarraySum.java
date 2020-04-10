import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class CsesSortingMaximumSubarraySum {

    public static void main(String[] args) throws Exception {
        new CsesSortingMaximumSubarraySum().solve();
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
        long currentPrefix = 0L;
        long minPrefix = 0L;
        long maxSubarray = Long.MIN_VALUE / 2;
        for (int i = 0; i < n; i++) {
            currentPrefix += nextInt();
            maxSubarray = Math.max(maxSubarray, currentPrefix - minPrefix);
            minPrefix = Math.min(minPrefix, currentPrefix);
        }

        out.println(maxSubarray);
        out.flush();
    }
}
