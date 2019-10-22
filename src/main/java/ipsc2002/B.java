package ipsc2002;

import java.io.PrintWriter;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final PrintWriter out = new PrintWriter(System.out);

        while (true) {
            final int n = in.nextInt();
            if (n == -1) {
                break;
            }

            // tasks numbers
            long[] a = new long[n];

            // partial sums
            long[] s = new long[n + 1];

            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                s[i] = (i == 0 ? 0 : s[i - 1] + a[i - 1]);
            }
            s[n] = s[n - 1] + a[n - 1];
            final long sum = s[n];

            if (sum % n != 0) {
                // If can't evenly distribute
                out.println(-1);
                continue;
            }


            final long avg = sum / n;

            long solution = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                final long excess = a[i] - avg;
                if (excess <= 0) {
                    continue;
                }

                final long needOnTheLeft = (avg * i) - s[i];
                final long needOnTheRight = excess - needOnTheLeft;

                long stepsToDistributeCurrent = Math.max(needOnTheLeft, needOnTheRight);
                solution = Math.max(solution, stepsToDistributeCurrent);
            }

            out.println(solution);
        }

        out.flush();
    }
}
