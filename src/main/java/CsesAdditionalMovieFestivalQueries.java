import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CsesAdditionalMovieFestivalQueries {

    public static void main(String[] args) throws Exception {
        new CsesAdditionalMovieFestivalQueries().solve();
    }

    private final FastReader in = new FastReader();

    private final PrintWriter out = new PrintWriter(System.out);

    private static final int MAX_TIME = 1_000_001;

    private static class Movie {
        int start, end;

        Movie(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public void solve() throws Exception {
        final int n = in.nextInt(), q = in.nextInt();

        final Movie[] movies = new Movie[n];
        for (int i = 0; i < n; i++) {
            movies[i] = new Movie(in.nextInt(), in.nextInt());
        }

        Arrays.sort(movies, Comparator.comparingInt(m -> m.end));

        int MAX_H = 0;
        while (1 << MAX_H <= n + 1) {
            MAX_H++;
        }

        // DP[h][b] - the latest a, such that a..b has 2^h movies
        final int[][] dp = new int[MAX_H][MAX_TIME];

        // Let's fill the row # 0
        for (int i = 0, a = 0, b = 0; b < MAX_TIME; b++) {
            while (i < n && movies[i].end <= b) {
                a = Math.max(a, movies[i].start);
                i++;
            }
            dp[0][b] = a;
        }

        // Now fill the rest of DP
        for (int h = 1; h < MAX_H; h++) {
            for (int b = 0; b < MAX_TIME; b++) {
                dp[h][b] = dp[h - 1][dp[h - 1][b]];
            }
        }

        for (int query = 0; query < q; query++) {
            int qstart = in.nextInt();
            int qend = in.nextInt();

            int result = 0;
            for (int h = MAX_H - 1; h >= 0; h--) {
                if (dp[h][qend] >= qstart) {
                    qend = dp[h][qend];
                    result += (1 << h);
                }
            }
            out.println(result);
        }

        out.flush();
    }

    private static class FastReader {

        private final int BUFFER_SIZE = 1 << 22;
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
