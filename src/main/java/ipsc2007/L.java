package ipsc2007;

import java.util.Scanner;

public class L {

    private static int R, H;

    private static double[][] dp;

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        for (int testCase = in.nextInt(); testCase > 0; testCase--) {
            R = in.nextInt();
            H = in.nextInt();
            final int T = in.nextInt();
            dp = new double[T + 1][R + 1];

            System.out.println(String.format("%.9f", g(T, R)));
        }
    }

    private static double g(int T, int top) {
        if (T == 0) {
            return 0.0;
        }
        if (dp[T][top] > 0.0) {
            return dp[T][top];
        }

        double result = 0.0;

        // If we draw cylinder with ≤ raduis
        for (int drawR = 1; drawR <= top; drawR++) {
            for (int drawH = 1; drawH <= H; drawH++) {
                result += Math.max(
                        // Put it
                        drawH + g(T - 1, drawR),
                        // Return to the bag
                        g(T - 1, top)
                );
            }
        }

        // Normalize on probability of drawing ≤ radius
        result = result / R / H;

        // If we draw cylinder with > radius
        result += g(T - 1, top) * (((double) R - top) / R);

        return dp[T][top] = result;
    }

}
