package leetcode.contest.weekly256;

import java.util.Arrays;

public class Problem5857 {

    public int numberOfUniqueGoodSubsequences(String binary) {
        this.input = binary.toCharArray();
        this.n = input.length;

        int first1Position = -1, first0Position = -1;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '0' && first0Position == -1) {
                first0Position = i;
            }
            if (input[i] == '1' && first1Position == -1) {
                first1Position = i;
            }
        }

        // First, trivial cases
        if (first1Position == -1) {
            // The string has only zeros
            return 1;
        }

        if (first0Position == -1) {
            // The string has only ones {
            return n;
        }

        next0 = new int[n];
        next1 = new int[n];
        int nextZero = -1, nextOne = -1;
        for (int i = input.length - 1; i >= 0; i--) {
            next0[i] = nextZero;
            next1[i] = nextOne;
            if (input[i] == '0') {
                nextZero = i;
            } else {
                nextOne = i;
            }
        }

        dp = new int[n];
        Arrays.fill(dp, -1);

        // Single zero plus a subseq starting with one
        return (1 + f(first1Position)) % P;
    }

    // To be honest, not sure if that's going to work
    private int f(int index) {
        if (index == n) {
            throw new AssertionError("This shouldn't happen");
        }

        if (dp[index] >= 0) {
            return dp[index];
        }

        // We can stop here, we can find next one, we can find next zero.
        // Stopping here gives us initial 1
        int result = 1;

        // Let's take next zero;
        if (next0[index] >= 0) {
            result += f(next0[index]);
            result %= P;
        }

        // Let's take next one
        if (next1[index] >= 0) {
            result += f(next1[index]);
            result %= P;
        }

        return dp[index] = result;
    }

    private final int P = 1_000_000_007;

    private int n;

    private char[] input;

    private int[] next0, next1;

    private int[] dp;
}
