package leetcode.contest.weekly258;

import java.util.HashMap;
import java.util.Map;

public class Problem5868 {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Ratio, Integer> rectanglesByRatio = new HashMap<>();
        long result = 0;
        for (int[] pair : rectangles) {
            final var ratio = new Ratio(pair[0], pair[1]);
            rectanglesByRatio.compute(ratio, (k, v) -> v == null ? 1 : v + 1);
        }
        for (Integer numbers : rectanglesByRatio.values()) {
            result += ((long) numbers) * (numbers - 1L) / 2L;
        }
        return result;
    }

    private static class Ratio {
        private final int num;
        private final int denom;

        public Ratio(int num, int denom) {
            int gcd = gcd(num, denom);
            this.num = num / gcd;
            this.denom = denom / gcd;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Ratio ratio = (Ratio) o;

            if (num != ratio.num) return false;
            return denom == ratio.denom;
        }

        @Override
        public int hashCode() {
            int result = num;
            result = 31 * result + denom;
            return result;
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
