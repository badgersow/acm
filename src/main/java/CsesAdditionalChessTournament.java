import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CsesAdditionalChessTournament {

    public static void main(String[] args) throws Exception {
        new CsesAdditionalChessTournament().solve();
    }

    private final FastReader in = new FastReader();

    private final PrintWriter out = new PrintWriter(System.out);

    @SuppressWarnings({"unchecked", "rawtypes"})
    public void solve() throws Exception {
        final int n = in.nextInt();
        final int MAX_DEGREE = 200_000;

        final List[] nodes = new ArrayList[MAX_DEGREE + 1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }

        int sumDegrees = 0;
        int maxDegree = 0;
        for (int i = 1; i <= n; i++) {
            final int degree = in.nextInt();
            // We don't care about degree 0
            if (degree != 0) {
                nodes[degree].add(i);
                sumDegrees += degree;
                maxDegree = Math.max(maxDegree, degree);
            }
        }

        if (sumDegrees % 2 == 1) {
            out.println("IMPOSSIBLE");
            out.flush();
            return;
        }

        StringBuilder result = new StringBuilder();
        result.append(sumDegrees / 2)
                .append(System.lineSeparator());

        while (maxDegree > 0) {
            while (maxDegree > 0 && nodes[maxDegree].isEmpty()) {
                maxDegree--;
            }

            if (maxDegree == 0) {
                break;
            }

            // Let's find the node with the highest degree, otherwise we are done.
            final int nodeWithMaxDegree = removeLast(nodes[maxDegree]);
            final List<int[]> nodesWithDegreesToAdd = new ArrayList<>();

            int nodesLeft = maxDegree;
            int currentDegree = maxDegree;
            while (nodesLeft > 0) {
                if (currentDegree == 0) {
                    out.println("IMPOSSIBLE");
                    out.flush();
                    return;
                }

                if (nodes[currentDegree].isEmpty()) {
                    currentDegree--;
                } else {
                    final int removedNode = removeLast(nodes[currentDegree]);
                    nodesWithDegreesToAdd.add(new int[]{removedNode, currentDegree - 1});
                    nodesLeft--;
                    result
                            .append(nodeWithMaxDegree)
                            .append(" ")
                            .append(removedNode)
                            .append(System.lineSeparator());
                }
            }
            for (int[] nodeWithDegree : nodesWithDegreesToAdd) {
                nodes[nodeWithDegree[1]].add(nodeWithDegree[0]);
            }
        }

        out.print(result);
        out.flush();
    }

    private static int removeLast(List<Integer> list) {
        return list.remove(list.size() - 1);
    }

    private static class FastReader {

        private final int BUFFER_SIZE = 1 << 20;
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
