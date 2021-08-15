package leetcode.contest.weekly254;

public class MinimumNonZeroProductOfTheArrayElements {

    final long P = 1_000_000_007L;

    public int minNonZeroProduct(int p) {
        return (int) (
                ((1L << p) - 1L) % P *
                        pow((1L << p) - 2, (1L << (p - 1)) - 1) % P);
    }

    private long pow(long a, long n) {
        long r = 1L;
        a %= P;
        while (n > 0) {
            r = r * a % P;
            a = a * a % P;
            n /= 2;
        }
        return r;
    }
}
