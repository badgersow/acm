import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class CsesAdditionalCriticalCities {

    public static void main(String[] args) throws Exception {
        new CsesAdditionalCriticalCities().solve();
    }

    private final FastReader in = new FastReader();

    private final PrintWriter out = new PrintWriter(System.out);

    private List[] edges;

    private int[] distS, distT;

    private boolean[] visited;

    public void solve() throws Exception {
        int n = in.nextInt(), m = in.nextInt();

        edges = new List[n];
        visited = new boolean[n];
        distS = new int[n];
        distT = new int[n];

        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt() - 1, v = in.nextInt() - 1;
            edges[u].add(v);
            edges[v].add(u);
        }

        calculateShortestDist(0, distS);
        calculateShortestDist(n - 1, distT);

        int st = distS[n - 1];
        int[] nodesOfDist = new int[n];

        for (int i = 0; i < n; i++) {
            if (distS[i] + distT[i] == st) {
                nodesOfDist[distS[i]]++;
            }
        }

        StringBuilder result = new StringBuilder("1");
        int outputNodes = 1;
        for (int i = 1; i < n; i++) {
            if (nodesOfDist[distS[i]] == 1) {
                outputNodes++;
                result.append(" ").append(i + 1);
            }
        }

        out.println(outputNodes);
        out.println(result.toString());
        out.flush();
    }

    private void calculateShortestDist(int start, int[] dist) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{start, 0});
        Arrays.fill(visited, false);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] q = queue.removeFirst();
            int v = q[0], d = q[1];
            visited[v] = true;
            dist[v] = d;
            for (Object u : edges[v]) {
                if (!visited[(Integer) u]) {
                    queue.addLast(new int[]{(Integer) u, d + 1});
                }
            }
        }

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
