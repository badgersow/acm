package ipsc2009;

import java.util.Arrays;
import java.util.Scanner;

import static com.google.common.math.LongMath.gcd;
import static com.google.common.math.LongMath.pow;

public class G {

    public static void main(String[] args) {
        new G().solve();
    }

    void solve() {
        final Scanner in = new Scanner(System.in);

        dp = new long[11][11][1 << 11];
        for (long[][] layer1 : dp) {
            for (long[] layer2 : layer1) {
                Arrays.fill(layer2, -1L);
            }
        }

        int T = in.nextInt();
        while (T-- > 0) {
            final int n = in.nextInt(), k = in.nextInt();

            final long overflows = overflows(n, 0);
            final long total = pow(k, n);
            final long gcd = gcd(overflows, total);

            System.out.println(overflows / gcd + "/" + (total / gcd));
        }
    }

    private int n, k;

    private long[][][] dp;

    private long overflows(int remaining, int mask) {
        if (dp[remaining][k][mask] >= 0) {
            return dp[remaining][k][mask];
        }

//        if (remaining == 0) {
//            remaining
//        }
        return 0;
    }

    private boolean bit(int mask, int position) {
        return (mask << position) > 0;
    }

    private int set(int mask, int position) {
        return mask & (1 << position);
    }

    private int ones(int mask) {
        int ans = 0;
        for (int position = 0; position < k; position++) {
            ans += bit(mask, position) ? 1 : 0;
        }
        return ans;
    }

}
