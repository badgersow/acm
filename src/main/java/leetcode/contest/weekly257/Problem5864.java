package leetcode.contest.weekly257;

import java.util.Arrays;
import java.util.Comparator;

public class Problem5864 {
    public int numberOfWeakCharacters(int[][] a) {
        int n = a.length;
        Arrays.sort(a, Comparator.comparingInt((int[] b) -> b[0]).reversed());

        int maxStrength = Integer.MIN_VALUE;
        int newMaxStrength = Integer.MIN_VALUE;
        int weakChars = 0;
        int index = 0;
        while (true) {
            // First, let's process the batch (while value is the same)
            int group = a[index][0];
            for (; index < n && a[index][0] == group; index++) {
                weakChars += (a[index][1] < maxStrength ? 1 : 0);
                newMaxStrength = Math.max(newMaxStrength, a[index][1]);
            }

            if (index == n) {
                break;
            }

            // Next, let's calculate the new maximum
            maxStrength = newMaxStrength;
        }

        return weakChars;
    }
}
