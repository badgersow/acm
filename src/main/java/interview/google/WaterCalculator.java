package interview.google;

public class WaterCalculator {

    /**
     * Calculate total amount of water given the array of heights.
     * Works in O(heights.length) time and consumes additional O(heights.length) memory
     */
    public int waterVolume(int[] heights) {
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
}
