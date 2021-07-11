package leetcode.p546;

import java.util.Arrays;

public class Solution {

    private int[][][] dp = new int[101][101][101];

    private int[] boxes;

    private int n;

    private int[] nextOfSameColor;

    public int removeBoxes(int[] boxes) {
        n = boxes.length;
        this.boxes = boxes;
        nextOfSameColor = new int[n];
        Arrays.fill(nextOfSameColor, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (boxes[i] == boxes[j]) {
                    nextOfSameColor[i] = j;
                    break;
                }
            }
        }

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

        final int next = nextOfSameColor[from]; // this is the position of the next digit

        // Here we have several different options.
        // We can always just consume the current item with the head
        int result = (head + 1) * (head + 1) + f(from + 1, to, 0);

        // We can add the current item to the head, but only if the next item is the same
        if (from < n - 1 && boxes[from] == boxes[from + 1]) {
            result = Math.max(result, f(from + 1, to, head + 1));
        } else if (from < n - 1 && next > 0 && next < to) {
            // If the next color is different and somewhere there is our color,
            // we can consume the middle separately
            result = Math.max(result,
                    f(from + 1, next, 0) + // middle
                            f(next, to, head + 1) // tail
            );
        }

        return dp[from][to][head] = result;
    }
}
