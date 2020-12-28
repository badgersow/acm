import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class CsesAdditionalEmptyString {

    public static void main(String[] args) throws Exception {
        new CsesAdditionalEmptyString().solve();
    }

    private final FastReader in = new FastReader();

    private final PrintWriter out = new PrintWriter(System.out);

    public void solve() throws Exception {
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int n = 0; n < C.length; n++) {
            for (int k = 0; k <= n; k++) {
                if (n == 0 || k == 0) {
                    C[n][k] = 1;
                } else {
                    C[n][k] = (C[n - 1][k] + C[n - 1][k - 1]) % P;
                }
            }
        }
        string = in.readLine().toCharArray();
        out.println(f(0, string.length));
        out.flush();
    }

    private char[] string;

    private static final int P = 1_000_000_007;

    private int[][] dp = new int[501][501];

    private int[][] C = new int[501][501];

    private int f(int from, int to) {
        if (from == to) {
            return 1;
        }

        if ((to - from) % 2 == 1) {
            return 0;
        }

        if (dp[from][to] >= 0) {
            return dp[from][to];
        }

        final int totalSteps = (to - from) / 2;
        final char first = string[from];
        int result = 0;
        for (int split = from + 1; split < to; split += 2) {
            if (first == string[split]) {
                final int leftSteps = (split - from - 1) / 2;
                final int leftWays = f(from + 1, split);
                final int rightWays = f(split + 1, to);

                for (int positionOfThisRemoval = leftSteps; positionOfThisRemoval < totalSteps; positionOfThisRemoval++) {
                    result = (int) (result +
                            (long) C[positionOfThisRemoval][leftSteps] * // Let's arrange left removals before this removal. All other positions are right steps
                                    leftWays % P *
                                    rightWays % P) % P;
                }
            }
        }

        return (dp[from][to] = (int) result);
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
