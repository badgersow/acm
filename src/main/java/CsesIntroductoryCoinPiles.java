import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class CsesIntroductoryCoinPiles {

    public static void main(String[] args) throws Exception {
        new CsesIntroductoryCoinPiles().solve();
    }

    private StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    private PrintWriter out = new PrintWriter(System.out);

    private int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    public void solve() throws Exception {
        int T = nextInt();
        while (T-- > 0) {
            final long a = nextInt(), b = nextInt();
            final long y3 = 2 * a - b;
            if (y3 < 0 || y3 % 3 != 0) {
                out.println("NO");
                continue;
            }

            final long y = y3 / 3;
            final long x = a - 2 * y;

            if (x < 0) {
                out.println("NO");
                continue;
            }

            out.println("YES");
        }
        out.flush();
    }

}
