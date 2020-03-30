import java.io.PrintWriter;
import java.util.Scanner;

public class CsesIntroductoryTwoKnights {

    public static void main(String[] args) {
        new CsesIntroductoryTwoKnights().solve();
    }

    public void solve() {
        final Scanner in = new Scanner(System.in);
        final PrintWriter out = new PrintWriter(System.out);
        final int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            out.println(knights(i));
        }

        out.flush();
    }

    private long knights(long n) {
        return (n * n * n * n + 4 * n * n * n - 3 * n * n + 10 * n) / 2;
    }

}
