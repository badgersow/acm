import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import static java.util.Comparator.reverseOrder;

public class CsesSortingSlidingMedian {

    public static void main(String[] args) throws Exception {
        new CsesSortingSlidingMedian().solve();
    }

    private final FastReader in = new FastReader();

    private final PrintWriter out = new PrintWriter(System.out);

    public void solve() throws Exception {
        final int n = in.nextInt(), k = in.nextInt();
        final Queue<Integer> queue = new ArrayDeque<>();
        final int[] a = new int[k];
        final Set<Integer> topSet = new HashSet<>();
        final PriorityQueue<Integer> topHalf = new PriorityQueue<>();
        final Set<Integer> bottomSet = new HashSet<>();
        final PriorityQueue<Integer> bottomHalf = new PriorityQueue<>(reverseOrder());

        for (int i = 0; i < k; i++) {
            final int next = in.nextInt();
            a[i] = next;
            queue.add(next);
        }

        Arrays.sort(a);
        for (int i = 0; i < (k + 1) / 2; i++) {
            bottomHalf.add(a[i]);
            bottomSet.add(a[i]);
        }
        for (int i = (k + 1) / 2; i < k; i++) {
            topHalf.add(a[i]);
            topSet.add(a[i]);
        }

        out.print(bottomHalf.peek());
        out.print(" ");

        for (int i = k; i < n; i++) {
            final int next = in.nextInt();

            // Remove last element
            final Integer last = queue.remove();
            queue.add(next);

            if (bottomSet.contains(last) && next <= bottomHalf.peek()) {
                bottomHalf.remove(last);
                bottomSet.remove(last);
                bottomHalf.add(next);
                bottomSet.add(next);
            } else if (topSet.contains(last) && next >= topHalf.peek()) {
                topHalf.remove(last);
                topSet.remove(last);
                topHalf.add(next);
                topSet.add(next);
            } else if (bottomSet.contains(last)) {
                bottomHalf.remove(last);
                bottomSet.remove(last);
                topHalf.add(next);
                topSet.add(next);
                final Integer reminder = topHalf.remove();
                topSet.remove(reminder);
                bottomHalf.add(reminder);
                bottomSet.add(reminder);
            } else {
                topHalf.remove(last);
                topSet.remove(last);
                bottomHalf.add(next);
                bottomSet.add(next);
                final Integer reminder = bottomHalf.remove();
                bottomSet.remove(reminder);
                topHalf.add(reminder);
                topSet.add(reminder);
            }

            out.print(bottomHalf.peek());
            out.print(" ");
        }

        out.println();
        out.flush();
    }

    private static class FastReader {

        private final int BUFFER_SIZE = 1 << 24;
        private final DataInputStream din;
        private final byte[] buffer;
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
