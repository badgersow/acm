import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class CsesSortingConcertTickets {

    public static void main(String[] args) throws Exception {
        new CsesSortingConcertTickets().solve();
    }

    private Parser in = new Parser(System.in);

    private PrintWriter out = new PrintWriter(System.out);

    public void solve() throws Exception {
        final int n = in.nextInt(), m = in.nextInt();
        final TreeMap<Integer, Integer> tickets = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            final int price = in.nextInt();
            final Integer peopleWithPrice = tickets.get(price);
            if (peopleWithPrice != null) {
                tickets.put(price, peopleWithPrice + 1);
            } else {
                tickets.put(price, 1);
            }
        }

        for (int i = 0; i < m; i++) {
            final int maxPrice = in.nextInt();
            final Map.Entry<Integer, Integer> entry = tickets.floorEntry(maxPrice);

            if (entry == null) {
                out.println(-1);
            } else {
                final Integer price = entry.getKey();
                final Integer peopleWithPrice = entry.getValue();
                if (peopleWithPrice == 1) {
                    tickets.remove(price);
                } else {
                    tickets.put(price, peopleWithPrice - 1);
                }
                out.println(price);
            }
        }

        out.flush();
    }

    static class Parser {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Parser(InputStream in) {
            din = new DataInputStream(in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String nextString(int maxSize) {
            byte[] ch = new byte[maxSize];
            int point = 0;
            byte c = read();
            while (c == ' ' || c == '\n' || c == '\r')
                c = read();
            while (c != ' ' && c != '\n' && c != '\r') {
                ch[point++] = c;
                c = read();
            }
            return new String(ch, 0, point);
        }

        public int nextInt() {
            int ret = 0;
            boolean neg;
            byte c = read();
            while (c <= ' ')
                c = read();
            neg = c == '-';
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
                c = read();
            } while (c > ' ');

            if (neg) return -ret;
            return ret;
        }

        private void fillBuffer() {
            try {
                bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
    }
}
