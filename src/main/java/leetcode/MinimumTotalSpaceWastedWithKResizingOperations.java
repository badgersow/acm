package leetcode;

import java.util.Arrays;

public class MinimumTotalSpaceWastedWithKResizingOperations {

    public int minSpaceWastedKResizing(int[] a, int k) {
        if (a.length == 1) {
            return 0;
        }

        this.n = a.length;
        this.a = a;
        this.dp = new int[n][k + 1][n];
        for (int[][] ints : dp) {
            for (int[] ints2 : ints) {
                Arrays.fill(ints2, -1);
            }
        }

        return waste(1, k, 0);
    }

    private int[][][] dp;

    private int[] a;

    private int n;

    private int waste(int index, int changes, int prevIndex) {
        if (index == n) {
            return 0;
        }

        if (dp[index][changes][prevIndex] >= 0) {
            return dp[index][changes][prevIndex];
        }

        int result = Integer.MAX_VALUE;

        // If we have K, we can always resize to the current number.
        // Waste of the current element is going to be 0.
        if (changes > 0) {
            result = Math.min(result,
                    waste(index + 1, changes - 1, index));
        }

        // We can also resize from the previous number, but ONLY if
        // the previous number is <= the current.
        if (a[prevIndex] <= a[index]) {
            result = Math.min(result,
                    (index - prevIndex) * (a[index] - a[prevIndex]) +
                            waste(index + 1, changes, index));
        }

        // Finally, we can just continue, but only if the previous number is OK
        if (a[index] <= a[prevIndex]) {
            result = Math.min(result,
                    (a[prevIndex] - a[index]) +
                            waste(index + 1, changes, prevIndex));
        }

        return (dp[index][changes][prevIndex] = result);
    }
}
