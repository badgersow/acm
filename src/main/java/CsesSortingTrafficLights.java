import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CsesSortingTrafficLights {

    public static void main(String[] args) throws Exception {
        new CsesSortingTrafficLights().solve();
    }

    private final FastReader in = new FastReader();

    private final PrintWriter out = new PrintWriter(System.out);

    public void solve() throws Exception {
        final int x = in.nextInt(), n = in.nextInt();
        final TreeSet<Integer> lights = new TreeSet<>();
        lights.add(0);
        lights.add(x);

        final HashMap<Integer, Integer> countByLength = new HashMap<>();
        final TreeSet<Integer> counts = new TreeSet<>(Comparator.reverseOrder());
        increment(countByLength, counts, x);

        for (int i = 0; i < n; i++) {
            final int current = in.nextInt();
            final int previous = lights.floor(current),
                    next = lights.ceiling(current);

            lights.add(current);
            decrement(countByLength, counts, next - previous);
            increment(countByLength, counts, current - previous);
            increment(countByLength, counts, next - current);

            out.print(counts.first());
            if (i < n - 1) {
                out.print(' ');
            }
        }

        out.flush();
    }

    private static void decrement(Map<Integer, Integer> map, Set<Integer> set, int length) {
        final Integer currentValue = map.get(length);
        if (currentValue == 1) {
            map.remove(length);
            set.remove(length);
        } else {
            map.put(length, currentValue - 1);
        }
    }

    private static void increment(Map<Integer, Integer> map, Set<Integer> set, int length) {
        final Integer currentValue = map.get(length);
        //noinspection Java8MapApi
        if (currentValue == null) {
            map.put(length, 1);
            set.add(length);
        } else {
            map.put(length, currentValue + 1);
        }
    }

    private static class FastReader {

        private final int BUFFER_SIZE = 1 << 20;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastReader(String fileName) {
            try {
                din = new DataInputStream(new FileInputStream(fileName));
                buffer = new byte[BUFFER_SIZE];
                bufferPointer = bytesRead = 0;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public String readLine() {
            byte[] buf = new byte[1001]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() {
            try {
                bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
                if (bytesRead == -1)
                    buffer[0] = -1;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private byte read() {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() {
            try {
                if (din == null)
                    return;
                din.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int[] fillIntegerArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++)
                array[i] = nextInt();
            return array;
        }

        public long[] fillLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; i++)
                array[i] = nextLong();
            return array;
        }

        public <T extends List<Long>> T fillList(T list, int n) {
            for (int i = 0; i < n; i++)
                list.add(nextLong());
            return list;
        }
    }
}
