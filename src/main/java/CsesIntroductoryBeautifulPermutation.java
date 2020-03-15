import java.io.PrintWriter;
import java.util.Scanner;

public class CsesIntroductoryBeautifulPermutation {

    public static void main(String[] args) {
        new CsesIntroductoryBeautifulPermutation().solve();
    }

    void solve() {
        final Scanner in = new Scanner(System.in);
        final PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();

        if (n == 1) {
            out.println("1");
            out.flush();
            return;
        }

        if (n <= 3) {
            out.println("NO SOLUTION");
            out.flush();
            return;
        }

        for (int i = 2; i <= n; i += 2) {
            out.print(i);
            out.print(" ");
        }

        for (int i = 1; i <= n; i += 2) {
            out.print(i);
            out.print(" ");
        }

        out.println();
        out.flush();
    }

}
