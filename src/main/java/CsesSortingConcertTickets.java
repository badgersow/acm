import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.TreeMap;

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
        final TreeMap<Integer, Integer> tickets = new TreeMap();

        for (int i = 0; i < n; i++) {
            final int price = nextInt();
            if (tickets.containsKey(price)) {
                tickets.put(price, tickets.get(price) + 1);
            } else {
                tickets.put(price, 1);
            }
        }

        for (int i = 0; i < m; i++) {
            final int maxPrice = nextInt();
            final Integer sellPrice = tickets.floorKey(maxPrice);
            if (sellPrice == null) {
                out.println(-1);
            } else {
                tickets.put(sellPrice, tickets.get(sellPrice) - 1);
                if (tickets.get(sellPrice) == 0) {
                    tickets.remove(sellPrice);
                }
                out.println(sellPrice);
            }
        }

        out.flush();
    }
}
