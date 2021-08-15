package leetcode;

import java.util.Arrays;

public class MinimumTotalSpaceWastedWithKResizingOperations {

    public int minSpaceWastedKResizing(int[] a, int k) {
        if (a.length == 1) {
            return 0;
        }

        this.n = a.length;
        this.a = a;
        this.dp = new int[n][k + 2];
        for (int[] layer : dp) {
            Arrays.fill(layer, -1);
        }

        return waste(0, k + 1);
    }

    private int[] a;

    private int n;

    private int[][] dp;

    // Waste of the interval [index..n) assuming k intervals left
    private int waste(int index, int intervals) {
        if (index == n) {
            return 0;
        }
        if (intervals == 0) {
            return Integer.MAX_VALUE / 2;
        }
        if (dp[index][intervals] >= 0) {
            return dp[index][intervals];
        }

        // Now let's create an interval ending in I inclusive
        int sum = 0;
        int max = -1;
        int result = Integer.MAX_VALUE;
        for (int i = index; i < n; i++) {
            max = Math.max(max, a[i]);
            sum += a[i];

            result = Math.min(result,
                    (i - index + 1) * max - sum + // waste of the current interval
                            waste(i + 1, intervals - 1));
        }

        return (dp[index][intervals] = result);
    }

}
