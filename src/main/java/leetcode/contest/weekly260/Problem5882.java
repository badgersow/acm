package leetcode.contest.weekly260;

public class Problem5882 {
    public long gridGame(int[][] a) {
        int n = a[0].length;
        // suffix0[i] = sum [0...i]
        long[] suffix0 = new long[n];
        // prefix1[i] = sum [i...n-1]
        long[] prefix1 = new long[n];

        prefix1[0] = a[1][0];
        for (int i = 1; i < n; i++) {
            prefix1[i] = prefix1[i - 1] + a[1][i];
        }

        suffix0[n - 1] = a[0][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix0[i] = suffix0[i + 1] + a[0][i];
        }

        long bestScore2 = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long downScore = (i == 0) ? 0 : prefix1[i - 1];
            long rightScore = (i == n - 1) ? 0 : suffix0[i + 1];

            bestScore2 = Math.min(bestScore2, Math.max(downScore, rightScore));
        }

        return bestScore2;
    }
}
