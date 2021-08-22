package leetcode.contest.weekly255;

import java.util.Arrays;

public class MinimizeTheDifferenceBetweenTargetAndChosenElements {
    public int minimizeTheDifference(int[][] mat, int target) {
        this.mat = mat;
        this.rows = mat.length;
        this.columns = mat[0].length;
        this.dp = new int[rows][70 * 70 * 2];
        for (int[] layer : dp) {
            Arrays.fill(layer, -1);
        }
        this.target = target;
        return f(0, 0);
    }

    private int[][] mat;

    private int[][] dp;

    private int rows, columns, target;

    private int f(int row, int sum) {
        if (row == rows) {
            return Math.abs(sum - target);
        }

        if (dp[row][sum] >= 0) {
            return dp[row][sum];
        }

        int result = Integer.MAX_VALUE;
        for (int j = 0; j < columns; j++) {
            result = Math.min(result,
                    f(row + 1, sum + mat[row][j]));
        }

        return (dp[row][sum] = result);
    }
}
