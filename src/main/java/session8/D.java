package session8;

import java.util.Arrays;
import java.util.Scanner;

public class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        n = in.nextInt();
        a = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            sum += a[i];
        }

        p = in.nextInt();

        for (double[][][] doubles : dp) {
            for (double[][] aDouble : doubles) {
                for (double[] doubles1 : aDouble) {
                    Arrays.fill(doubles1, -1.0);
                }
            }
        }

        // What if we don't have last guest?
        if (sum <= p) {
            System.out.println(n);
        } else {
            // What if there's a last guest?
            double result = 0;
            for (int guests = 0; guests < n; guests++) {
                result += solve(guests) * guests;
            }

            System.out.println(result);
        }
    }

    private static int n, p;
    private static int[] a;

    /**
     * Probability of getting exactly G guests
     */
    private static double solve(int guests) {
        return f(0, p, guests, 0);
    }

    private static double[][][][] dp = new double[51][51][51][51];

    // Last guest ALWAYS exist
    private static double f(int pos, int leftLen, int leftGuests, int chosenLast) {
        // If we finished choosing
        if (leftGuests == 0 && chosenLast > 0) {
            // Last guest is chosen and it is more than difference
            if (chosenLast > leftLen) {
                return 1;
            }

            // Condition is failed. Last guest is not what we want.
            return 0;
        }

        if (pos == n) {
            return 0;
        }

        // We don't have enough slots to get all people we need
        if (n - pos < (leftGuests + (chosenLast > 0 ? 0 : 1))) {
            return 0;
        }

        if (dp[pos][leftLen][leftGuests][chosenLast] >= 0) {
            return dp[pos][leftLen][leftGuests][chosenLast];
        }

        double result = 0;

        // Choose the last guest as this one
        if (chosenLast == 0) {
            result += (1.0 / (n - pos)) * f(pos + 1, leftLen, leftGuests, a[pos]);
        }

        // Get this guest as a regular guest
        if (leftGuests > 0 && a[pos] <= leftLen) {
            result += ((double) leftGuests / (n - pos)) *
                    f(pos + 1, leftLen - a[pos], leftGuests - 1, chosenLast);
        }

        // Also we can skip the guest
        result += ((double) (n - pos - leftGuests - (chosenLast > 0 ? 0 : 1)) / (n - pos)) *
                f(pos + 1, leftLen, leftGuests, chosenLast);

        return dp[pos][leftLen][leftGuests][chosenLast] = result;
    }
}
