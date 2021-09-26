package leetcode.contest.weekly260;

public class Problem5881 {
    public int maximumDifference(int[] a) {
        int maxDiff = -1;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] > a[i]) {
                    maxDiff = Math.max(maxDiff, a[j] - a[i]);
                }
            }
        }

        return maxDiff;
    }
}
