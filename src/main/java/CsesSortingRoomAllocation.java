import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class CsesSortingRoomAllocation {

    public static void main(String[] args) throws Exception {
        new CsesSortingRoomAllocation().solve();
    }

    private final FastReader in = new FastReader();

    private final PrintWriter out = new PrintWriter(System.out);

    public void solve() throws Exception {
        final int n = in.nextInt();
        int rooms = 0;
        final int[] roomByCustomer = new int[n];
        final TreeSet<Integer> freeRooms = new TreeSet<>();
        final long[] codes = new long[2 * n];

        for (int i = 0; i < n; i++) {
            final int arrival = in.nextInt(), departure = in.nextInt();
            codes[i] = encode(true, i, arrival);
            codes[n + i] = encode(false, i, departure);
        }

        Arrays.sort(codes);

        for (final long code : codes) {
            final int position = position(code);
            if (!isArrival(code)) {
                // Departure
                freeRooms.add(roomByCustomer[position]);
            } else {
                // Arrival
                if (freeRooms.isEmpty()) {
                    freeRooms.add(++rooms);
                }
                final int availableRoom = freeRooms.first();
                freeRooms.remove(availableRoom);
                roomByCustomer[position] = availableRoom;
            }
        }

        out.println(rooms);
        out.print(roomByCustomer[0]);
        for (int i = 1; i < roomByCustomer.length; i++) {
            out.print(" ");
            out.print(roomByCustomer[i]);
        }
        out.println();
        out.flush();
    }

    public static long encode(boolean isArrival, long position, long time) {

        return position |
                (isArrival ? 0L : 1L) << 31 |
                time << 32;
    }

    public static boolean isArrival(long code) {
        return ((code >> 31) & 1) == 0;
    }

    public static int position(long code) {
        return (int) (code & ((1L << 30) - 1));
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
