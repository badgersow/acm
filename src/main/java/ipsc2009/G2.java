package ipsc2009;

import java.math.BigInteger;
import java.util.Scanner;

public class G2 {

    int n, k;
    BigInteger dp[][][] = new BigInteger[200][200][200];
    BigInteger[][] C = new BigInteger[200][200];

    public static void main(String[] args) {
        new G2().solve();
    }

    public void solve() {
        final Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        while (T-- > 0) {
            n = in.nextInt();
            k = in.nextInt();

            final BigInteger denominator = BigInteger.valueOf(k).pow(n);
            final BigInteger result = denominator.subtract(noOverflows(n, k, 0));
            final BigInteger gcd = result.gcd(denominator);

            System.out.println(String.format("%s/%s", result.divide(gcd), denominator.divide(gcd)));
        }
    }

    BigInteger noOverflows(int girls, int length, int overflow) {
        if (overflow > length) {
            return BigInteger.ZERO;
        }

        if (length == 0) {
            return girls == 0 ? BigInteger.ONE : BigInteger.ZERO;
        }

        if (dp[girls][length][overflow] != null) {
            return dp[girls][length][overflow];
        }

        BigInteger result = BigInteger.ZERO;

        for (int placeGirls = 0; placeGirls <= girls; placeGirls++) {
            result = result.add(
                    noOverflows(girls - placeGirls,
                            length - 1,
                            Math.max(0, overflow + placeGirls - 1))
                            .multiply(C(girls, placeGirls)));
        }

        return dp[girls][length][overflow] = result;
    }

    BigInteger C(int n, int k) {
        if (k == 0) {
            return BigInteger.ONE;
        }

        if (n == 0) {
            return BigInteger.ZERO;
        }

        if (C[n][k] != null) {
            return C[n][k];
        }

        return C[n][k] = C(n - 1, k).add(C(n - 1, k - 1));
    }

}
