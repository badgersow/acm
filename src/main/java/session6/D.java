package session6;

import java.math.BigInteger;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final long n = in.nextInt(), x = in.nextInt(), y = in.nextInt(), c = in.nextInt();
        final long rx = n - x, ry = n - y;

        long l = 0, r = 1_000_000_000L;
        while (l + 1 < r) {
            long mid = (l + r) / 2;
            if (f(mid, x, y, rx, ry).compareTo(BigInteger.valueOf(c)) >= 0) {
                r = mid;
            } else {
                l = mid;
            }
        }

        if (f(l, x, y, rx, ry).compareTo(BigInteger.valueOf(c)) == 0) {
            System.out.println(l);
        } else {
            System.out.println(r);
        }
    }

    private static BigInteger f(long t, long x, long y, long rx, long ry) {
        return fullArea(t)
                .subtract(
                        BigInteger.ZERO
                                .add(side(t, x - 1))
                                .add(side(t, y - 1))
                                .add(side(t, rx))
                                .add(side(t, ry))
                ).add(
                        BigInteger.ZERO
                                .add(corner(t, x - 1, y - 1))
                                .add(corner(t, x - 1, ry))
                                .add(corner(t, rx, y - 1))
                                .add(corner(t, rx, ry))
                );
    }


    private static BigInteger fullArea(long t) {
        return BigInteger.valueOf(2)
                .multiply(BigInteger.valueOf(t))
                .multiply(BigInteger.valueOf(t))
                .add(
                        BigInteger.valueOf(2).multiply(BigInteger.valueOf(t))
                ).add(
                        BigInteger.ONE
                );
    }

    private static BigInteger side(long t, long diff) {
        final BigInteger side = BigInteger.valueOf(t).subtract(BigInteger.valueOf(diff));
        if (side.compareTo(BigInteger.ZERO) > 0) {
            return BigInteger.valueOf(t - diff)
                    .multiply(BigInteger.valueOf(t - diff));
        }

        return BigInteger.ZERO;
    }

    private static BigInteger corner(long t, long x, long y) {
        final BigInteger side = BigInteger.valueOf(t)
                .subtract(BigInteger.valueOf(x))
                .subtract(BigInteger.valueOf(y));
        if (side.compareTo(BigInteger.ZERO) > 0) {
            return side.multiply(side.subtract(BigInteger.ONE))
                    .divide(BigInteger.valueOf(2));
        }

        return BigInteger.ZERO;
    }
}
