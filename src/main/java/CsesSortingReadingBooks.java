import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class CsesSortingReadingBooks {

    public static void main(String[] args) throws Exception {
        new CsesSortingReadingBooks().solve();
    }

    private StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    private PrintWriter out = new PrintWriter(System.out);

    private int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    public void solve() throws Exception {
        final int n = nextInt();
        long sum = 0L, max = 0L;

        for (int i = 0; i < n; i++) {
            final int current = nextInt();
            sum += current;
            max = Math.max(max, current);
        }

        out.println(Math.max(sum, 2 * max));
        out.flush();
    }
}
