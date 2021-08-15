package leetcode.contest.weekly254;

import java.util.Arrays;

public class ArrayWithElementsNotEqualToAverageOfNeighbors {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        final int[] result = new int[nums.length];

        for (int i = 0; i < result.length; i++) {
            if (i % 2 == 0) {
                // Putting min first
                result[i] = nums[i / 2];
            } else {
                // Putting max
                result[i] = nums[result.length - i / 2 - 1];
            }
        }

        return result;
    }
}
