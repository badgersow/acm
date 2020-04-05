import java.io.PrintWriter;
import java.util.Scanner;

public class CsesIntroductoryNumberSpiral {

    public static void main(String[] args) {
        new CsesIntroductoryNumberSpiral().solve();
    }

    public void solve() {
        final Scanner in = new Scanner(System.in);
        final PrintWriter out = new PrintWriter(System.out);

        final int T = in.nextInt();
        for (int testCase = 0; testCase < T; testCase++) {
            final long a = in.nextLong(), b = in.nextLong();
            final long min = Math.min(a, b), max = Math.max(a, b);

            final long from = (max - 1) * (max - 1) + 1, to = max * max;
            final boolean firstHalf = (a == max) ^ (max % 2 == 0);

            final long result = firstHalf ? from + min - 1 : (from + to) / 2 + (max - min);
            out.println(result);
        }

        out.flush();
    }

}
