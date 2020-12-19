package usaco.y2020.gold;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Springboards {

    public static void main(String[] args) throws Exception {
        new Springboards().solve();
    }

    private final FastReader in = new FastReader();

    private final PrintWriter out = new PrintWriter(System.out);

    final int MAX_COORDINATES = 400_004;

    public void solve() throws Exception {
        final int n = in.nextInt();
        final int P = in.nextInt();

        final Map<Integer, Integer> compressedByReal = new HashMap<>();
        final int[] realByCompressed = new int[MAX_COORDINATES];
        final SortedSet<Integer> coordinates = new TreeSet<>();

        int[][] boards = new int[P][];
        for (int i = 0; i < P; i++) {
            final int startX = in.nextInt();
            final int startY = in.nextInt();
            final int endX = in.nextInt();
            final int endY = in.nextInt();

            boards[i] = new int[]{startX, startY, endX, endY};
            coordinates.addAll(Arrays.asList(startX, startY, endX, endY));
        }

        int index = 0;
        for (Integer coordinate : coordinates) {
            realByCompressed[index] = coordinate;
            compressedByReal.put(coordinate, index);
            index++;
        }

        Arrays.sort(boards, Comparator.comparingInt((int[] arr) -> arr[0]).thenComparingInt(arr -> arr[1]));
        for (int i = 0; i < P; i++) {
            boards[i] = new int[]{compressedByReal.get(boards[i][0]),
                    compressedByReal.get(boards[i][1]),
                    compressedByReal.get(boards[i][2]),
                    compressedByReal.get(boards[i][3])};
        }

        Arrays.fill(tree, Long.MAX_VALUE);
        long[] dp = new long[P];
        List<long[]>[] pendingValues = new ArrayList[MAX_COORDINATES];
        for (int i = 0; i < MAX_COORDINATES; i++) {
            pendingValues[i] = new ArrayList<>();
        }
        int lastPendingAdded = 0;
        for (int i = 0; i < P; i++) {
            // Add pending boards to the row i

            final int[] currentBoard = boards[i];
            final int startXCompressed = currentBoard[0],
                    startYCompressed = currentBoard[1],
                    endXCompressed = currentBoard[2],
                    endYCompressed = currentBoard[3];
            final int startXReal = realByCompressed[startXCompressed],
                    startYReal = realByCompressed[startYCompressed],
                    endXReal = realByCompressed[endXCompressed],
                    endYReal = realByCompressed[endYCompressed];

            for (int x = lastPendingAdded; x <= startXCompressed; x++) {
                for (long[] pendingValue : pendingValues[x]) {
                    treeAdd((int) pendingValue[0], pendingValue[1]);
                }
                pendingValues[x].clear();
            }
            lastPendingAdded = startXCompressed;

            final long directCost = startXReal + startYReal;
            final long treeValue = treeGet(0, startYCompressed);
            final long optimalCost = (treeValue == Long.MAX_VALUE) ? directCost : Math.min(directCost, treeValue + startXReal + startYReal);

            dp[i] = optimalCost;

            if (endXCompressed == startXCompressed) {
                // We can add this directly to the tree
                treeAdd(endYCompressed, optimalCost - endXReal - endYReal);
            } else {
                // Add to the pending list
                pendingValues[endXCompressed].add(new long[]{endYCompressed, optimalCost - endXReal - endYReal});
            }
        }

        // Now we can calculate the result using all springboards
        long result = 2L * (n + 1);
        for (int i = 0; i < P; i++) {
            result = Math.min(result, dp[i] +
                    (n - realByCompressed[boards[i][2]]) +
                    (n - realByCompressed[boards[i][3]]));
        }

        out.println(result);
        out.flush();
    }

    int treeBase = 1 << 19;
    long[] tree = new long[2 * treeBase + 1];

    private void treeAdd(int key, long value) {
        doAdd(treeBase + key, value);
    }

    private void doAdd(int position, long value) {
        if (position == 0) {
            return;
        }
        tree[position] = Math.min(tree[position], value);
        doAdd(position / 2, value);
    }

    private long treeGet(int from, int to) {
        return doGet(treeBase + from, treeBase + to);
    }

    private long doGet(int from, int to) {
        if (from == to) {
            return tree[from];
        }

        if (from + 1 == to) {
            return Math.min(tree[from], tree[to]);
        }

        final int fromParent = isLeft(from) ? from / 2 : from / 2 + 1;
        final int toParent = isRight(from) ? to / 2 : to / 2 - 1;

        return Math.min(tree[from], Math.min(tree[to], doGet(fromParent, toParent)));
    }

    private boolean isLeft(int node) {
        return node % 2 == 0;
    }

    private boolean isRight(int node) {
        return node % 2 == 1;
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
