import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.TreeSet;

public class CsesSortingConcertTickets {

    public static void main(String[] args) throws Exception {
        new CsesSortingConcertTickets().solve();
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
        final int n = nextInt(), m = nextInt();
        final TreeSet<Integer> tickets = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            tickets.add(nextInt());
        }

        for (int i = 0; i < m; i++) {
            final int maxPrice = nextInt();
            final Integer sellPrice = tickets.floor(maxPrice);
            if (sellPrice == null) {
                out.println(-1);
            } else {
                tickets.remove(sellPrice);
                out.println(sellPrice);
            }
        }

        out.flush();
    }
}
