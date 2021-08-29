package leetcode.contest.weekly256;

import java.util.Arrays;

public class Problem5854 {
    public int minimumDifference(int[] nums, int k) {
        int bestDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i + k - 1 < nums.length; i++) {
            bestDiff = Math.min(
                    bestDiff,
                    nums[i + k - 1] - nums[i]
            );
        }

        return bestDiff;
    }
}
