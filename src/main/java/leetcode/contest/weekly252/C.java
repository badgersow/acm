package leetcode.contest.weekly252;

public class C {
    public long minimumPerimeter(long neededApples) {
        long l = 0, r = 100_000;
        while (l + 1 < r) {
            long w = (l + r) / 2;
            long apples = 2 * w * (w + 1) * (2 * w + 1);
            if (apples >= neededApples) {
                r = w;
            } else {
                l = w;
            }
        }

        return r * 8;
    }
}
