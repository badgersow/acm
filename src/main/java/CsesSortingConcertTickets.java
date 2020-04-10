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
        final TreeMap<Integer, Integer> tickets = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            final int price = nextInt();
            final Integer peopleWithPrice = tickets.get(price);
            if (peopleWithPrice != null) {
                tickets.put(price, peopleWithPrice + 1);
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
                final Integer peopleWithPrice = tickets.get(sellPrice);
                if (peopleWithPrice == 1) {
                    tickets.remove(sellPrice);
                } else {
                    tickets.put(sellPrice, peopleWithPrice - 1);
                }
                out.println(sellPrice);
            }
        }

        out.flush();
    }
}
