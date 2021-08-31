package leetcode.contest.weekly256;

import java.util.Arrays;

public class Problem5856 {
    public int minSessions(int[] tasks, int sessionTime) {
        this.tasks = tasks;
        this.n = tasks.length;
        this.sessionTime = sessionTime;

        for (int[] layer : dp) {
            Arrays.fill(layer, -1);
        }

        return f(0, 0);
    }

    int n;

    int sessionTime;

    int[][] dp = new int[1 << 14][16];

    int[] tasks;

    private int f(int mask, int consumed) {
        if (mask == (1 << n) - 1) {
            if (consumed == 0) {
                return 0;
            }
            return 1;
        }

        if (dp[mask][consumed] >= 0) {
            return dp[mask][consumed];
        }

        int result = Integer.MAX_VALUE;

        // Let's finish the current session (if that makes sense)
        if (consumed > 0) {
            result = Math.min(result,
                    1 + f(mask, 0));
        }

        // Let's find some other task to add
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0 && consumed + tasks[i] <= sessionTime) {
                // Try to add task #i
                result = Math.min(result, f(mask | (1 << i), consumed + tasks[i]));
            }
        }

        return dp[mask][consumed] = result;
    }
}
