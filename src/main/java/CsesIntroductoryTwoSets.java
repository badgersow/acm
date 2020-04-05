import java.io.PrintWriter;
import java.util.Scanner;

public class CsesIntroductoryTwoSets {

    public static void main(String[] args) {
        new CsesIntroductoryTwoSets().solve();
    }

    public void solve() {
        final Scanner in = new Scanner(System.in);
        final PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();

        if (n % 4 != 0 && (n + 1) % 4 != 0) {
            out.println("NO");
            out.flush();
            return;
        }

        out.println("YES");
        if (n % 4 == 0) {
            out.println(n / 2);
            for (int i = 1; i <= n / 4; i++) {
                out.print(i + " " + (n - i + 1) + " ");
            }
            out.println();
            out.println(n / 2);
            for (int i = n / 4 + 1; i <= n / 2; i++) {
                out.print(i + " " + (n - i + 1) + " ");
            }
            out.println();
        } else {
            n += 1;
            out.println(n / 2);
            out.print("1 " + n / 2 + " ");
            for (int i = 2; i <= n / 4; i++) {
                out.print(i + " " + (n - i + 1) + " ");
            }
            out.println();
            out.println(n / 2 - 1);
            for (int i = n / 4 + 1; i < n / 2; i++) {
                out.print(i + " " + (n - i + 1) + " ");
            }
            out.println(n / 2 + 1);
        }
        out.flush();
    }

}
