import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CsesSortingRestaurantCustomers {

    public static void main(String[] args) throws Exception {
        new CsesSortingRestaurantCustomers().solve();
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
        int[] times = new int[2 * n];
        final Set<Integer> arrival = new HashSet<>(n);

        for (int i = 0; i < n; i++) {
            times[i] = nextInt();
            times[n + i] = nextInt();
            arrival.add(times[i]);
        }

        Arrays.sort(times);
        int current = 0, max = 0;
        for (int i = 0; i < times.length; i++) {
            if (arrival.contains(times[i])) {
                current++;
            } else {
                current--;
            }
            max = Math.max(max, current);
        }

        out.println(max);
        out.flush();
    }
}
