package leetcode.p1131;

public class Solution {
    public int maxAbsValExpr(int[] a, int[] b) {
        int[] c = new int[a.length];
        for (int i = 0; i < c.length; i++) {
            c[i] = i;
        }

        int result = Integer.MIN_VALUE;
        for (int mask = 0; mask < 8; mask++) {
            int signa = (mask % 2 == 0 ? 1 : -1);
            int signb = ((mask / 2) % 2 == 0 ? 1 : -1);
            int signc = ((mask / 4) % 2 == 0 ? 1 : -1);

            result = Math.max(result, solve(a, signa, b, signb, c, signc));
        }

        return result;
    }

    private int solve(int[] a, int signa, int[] b, int signb, int[] c, int signc) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            int current = signa * a[i] +
                    signb * b[i] +
                    signc * c[i];

            min = Math.min(min, current);
            max = Math.max(max, current);
        }
        return max - min;
    }
}
