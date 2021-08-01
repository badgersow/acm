package leetcode.contest.weekly252;

import java.util.Arrays;

public class D {

    final long P = 1_000_000_007L;

    public int countSpecialSubsequences(int[] nums) {
        this.a = nums;
        this.n = a.length;
        for (long[] longs : dp) {
            Arrays.fill(longs, -1);
        }
        return (int) f(0, 0);
    }

    long[][] dp = new long[100_001][4]; // 0 1 2 3

    int[] a;

    int n;

    private long f(int index, int firstMandatory) {
        if (index == n && firstMandatory == 3) {
            return 1;
        }

        if (index == n) {
            return 0;
        }

        if (dp[index][firstMandatory] >= 0) {
            return dp[index][firstMandatory];
        }

        long result = 0;
        // There are different options. We can take this element, or we can skip it.
        // If taking the element, it can be last, or not.
        if (a[index] == firstMandatory) {
            // This means we can take the element
            result = (result +
                    f(index + 1, firstMandatory) + // This element is not the last one
                    f(index + 1, firstMandatory + 1) // This was the last one
            ) % P;
        }

        // Skip the element
        result = (result + f(index + 1, firstMandatory)) % P;

        return dp[index][firstMandatory] = result;
    }

}
