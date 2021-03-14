import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CsesAdditionalMaximumBuilding2 {

    public static void main(String[] args) throws Exception {
        new CsesAdditionalMaximumBuilding2().solve();
    }

    private final FastReader in = new FastReader();

    private final PrintWriter out = new PrintWriter(System.out);


    final int N = 1000;

    char[][] cc = new char[N][N + 1];

    int[][] ll = new int[N][N], rr = new int[N][N], aa = new int[N][N];
    boolean[][] alive = new boolean[N][N];

    static class E {
        int i, j;
    }

    E[][] ee = new E[N + 1][];

    int[] kk = new int[N + 1], pp = new int[N + 1];

    public void solve() throws Exception {
        int n, m, h, i, j, d, l, r;
        E e;

        n = in.nextInt();
        m = in.nextInt();
        for (i = 0; i < n; i++)
            cc[i] = in.readLine().toCharArray();
        for (j = 0; j < m; j++) {
            d = 0;
            for (i = 0; i < n; i++) {
                if (cc[i][j] == '*')
                    d = 0;
                else
                    d++;
                kk[d]++;
            }
        }
        for (d = 0; d <= n; d++) {
            ee[d] = new E[kk[d]];
            for (int i1 = 0; i1 < ee[d].length; i1++) {
                ee[d][i1] = new E();
            }
            kk[d] = 0;
        }
        for (j = 0; j < m; j++) {
            d = 0;
            for (i = 0; i < n; i++) {
                if (cc[i][j] == '*')
                    d = 0;
                else
                    d++;
                e = ee[d][kk[d]++];
                e.i = i;
                e.j = j;
            }
        }
        for (i = 0; i < n; i++)
            for (j = 0; j < m; j++)
                ll[i][j] = rr[i][j] = j;
        for (d = n; d > 0; d--) {
            for (h = 0; h < kk[d]; h++) {
                e = ee[d][h];
                i = e.i;
                j = e.j;
                alive[i][j] = true;
                l = r = j;
                if (j > 0 && alive[i][j - 1]) {
                    l = ll[i][j - 1];
                    pp[j - l]--;
                }
                if (j < m - 1 && alive[i][j + 1]) {
                    r = rr[i][j + 1];
                    pp[r - j]--;
                }
                rr[i][l] = r;
                ll[i][r] = l;
                pp[r - l + 1]++;
            }
            int[] qq = aa[d - 1];
            for (j = 1; j <= m; j++)
                qq[j - 1] = pp[j];
            for (j = m - 2; j >= 0; j--)
                qq[j] += qq[j + 1];
            for (j = m - 2; j >= 0; j--)
                qq[j] += qq[j + 1];
        }
        for (d = 0; d < n; d++) {
            for (j = 0; j < m; j++)
                out.printf("%d ", aa[d][j]);
            out.printf("\n");
        }
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
