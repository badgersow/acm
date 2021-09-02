package interview.google;

public class WaterCalculator {

    /**
     * Calculate total amount of water given the array of heights.
     * Works in O(heights.length) time and consumes additional O(heights.length) memory
     */
    public int waterVolume1(int[] heights) {
        int n = heights.length;
        // maxSuffix[i] - maximum on [i..n)
        int[] maxSuffix = new int[n + 1];

        // Fill maxSuffix first, before doing anything else
        maxSuffix[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            maxSuffix[i] = Math.max(maxSuffix[i + 1], heights[i]);
        }

        // This is the maximum of the numbers we have seen so far (to the left of the current value)
        int maxPrefix = 0;
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            int waterLineHeight = Math.min(maxPrefix, maxSuffix[i + 1]);
            int waterHere =
                    Math.max(0,
                            waterLineHeight - heights[i]
                    );
            totalWater += waterHere;
            maxPrefix = Math.max(maxPrefix, heights[i]);
        }

        return totalWater;
    }

    public int waterVolume2(int[] heights) {
        int n = heights.length;
        int left = 0, right = n - 1;
        // Maximum height from leftmost sink to left) and from (right to rightmost sink
        int leftMax = 0, rightMax = 0;
        int total = 0;
        while (left <= right) {
            // Water in the position “left” will flow to the left, because to the right we know the bar is at least same hight
            if (leftMax <= rightMax) {
                total += Math.max(0, leftMax - heights[left]);
                leftMax = Math.max(leftMax, heights[left]);
                left++;
            } else {
                total += Math.max(0, rightMax - heights[right]);
                rightMax = Math.max(rightMax, heights[right]);
                right--;
            }
        }

        return total;
    }


}
