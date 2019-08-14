package leetcode.p42;

public class Solution {
    public int trap(int[] height) {
        final int n = height.length;
        final int[] maxLeft = new int[n], maxRight = new int[n];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            final int level = Math.min(maxLeft[i], maxRight[i]);
            result += Math.max(0, level - height[i]);
        }

        return result;
    }
}
