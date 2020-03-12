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

        dp = new long[11][11][1 << 11][2];
        for (long[][][] layer1 : dp) {
            for (long[][] layer2 : layer1) {
                for (long[] layer3 : layer2) {
                    Arrays.fill(layer3, -1L);
                }
            }
        }

        int T = in.nextInt();
        while (T-- > 0) {
            n = in.nextInt();
            k = in.nextInt();

            final long overflows = overflows(n, 0, false);
            final long total = pow(k, n);
            final long gcd = gcd(overflows, total);

            System.out.println(overflows / gcd + "/" + (total / gcd));
        }
    }

    private int n, k;

    private long[][][][] dp;

    private long overflows(int remaining, int mask, boolean overflow) {
        if (dp[remaining][k][mask][overflow ? 1 : 0] >= 0) {
            return dp[remaining][k][mask][overflow ? 1 : 0];
        }

        if (remaining == 0) {
            return overflow ? 1 : 0;
        }

        long result = 0;
        for (int ticket = 0; ticket < k; ticket++) {
            final int newMask = setNext(mask, ticket);
            if (mask == newMask) { // overflow happened
                result += overflows(remaining - 1, newMask, true);
            } else {
                result += overflows(remaining - 1, newMask, overflow);
            }
        }

        return dp[remaining][k][mask][overflow ? 1 : 0] = result;
    }

    private boolean bit(int mask, int position) {
        return (mask & (1 << position)) > 0;
    }

    private int setNext(int mask, int position) {
        for (int realPosition = position; realPosition < k; realPosition++) {
            if (!bit(mask, realPosition)) {
                return set(mask, realPosition);
            }
        }
        return mask;
    }

    private int set(int mask, int position) {
        return mask | (1 << position);
    }

    private int ones(int mask) {
        int ans = 0;
        for (int position = 0; position < k; position++) {
            ans += bit(mask, position) ? 1 : 0;
        }
        return ans;
    }

}
