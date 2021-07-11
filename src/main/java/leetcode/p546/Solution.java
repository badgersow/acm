package leetcode.p546;

/**
 * DP solution with time complexity O(n^3 * k),
 * where n is the size of the array (100) and k is the max value (100)
 */
public class Solution {

    private final int[][][] dp = new int[101][101][101];

    private int[] boxes;

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        this.boxes = boxes;
        return f(0, boxes.length, 0);
    }

    private int f(int from, int to, int head) {
        // Border case, no boxes to process
        if (from == to - 1) {
            return (head + 1) * (head + 1);
        }

        if (dp[from][to][head] > 0) {
            return dp[from][to][head];
        }

        // Here we have several different options.
        // We can always just consume the current item with the head
        int result = (head + 1) * (head + 1) + f(from + 1, to, 0);

        // We can add the current item to the head, but only if the next item is the same
        if (boxes[from] == boxes[from + 1]) {
            result = Math.max(result, f(from + 1, to, head + 1));
        } else {
            for (int next = from + 2; next < to; next++) {
                if (boxes[from] != boxes[next]) {
                    continue;
                }

                // If the next color is different and somewhere there is our color,
                // we can consume the middle separately
                result = Math.max(result,
                        f(from + 1, next, 0) +   // middle
                                f(next, to, head + 1) // tail
                );
            }
        }

        return dp[from][to][head] = result;
    }
}
