package leetcode;

public class MaximumProductOfTheLengthOfTwoPalindromicSubstrings {

    private final long P = 1_000_000_007L;

    private final long X = 251L;

    private final long[] Xpow = new long[200_000];

    private final long[] invXpow = new long[200_000];

    public long maxProduct(String s) {
        var n = s.length();
        var input = s.toCharArray();

        var leftHash = new long[n + 1];
        var rightHash = new long[n + 1];

        leftHash[0] = 0L;
        for (int i = 1; i <= n; i++) {
            leftHash[i] = (leftHash[i - 1] * X + input[i - 1]) % P;
        }

        rightHash[n] = 0L;
        for (int i = n - 1; i >= 0; i--) {
            rightHash[i] = (rightHash[i + 1] * X + input[i]) % P;
        }

        var bestLeftPal = new int[n + 1];
        var bestRightPal = new int[n + 1];

        for (int i = 0; i < n; i++) {
            var bestPalDistance = bestPalDistance(i, n, leftHash, rightHash);
            bestLeftPal[i + bestPalDistance + 1] = Math.max(bestLeftPal[i + bestPalDistance + 1], bestPalDistance * 2 + 1);
            bestRightPal[i - bestPalDistance] = Math.max(bestRightPal[i - bestPalDistance], bestPalDistance * 2 + 1);
        }

        var result = 0;
        for (int i = 1; i < n; i++) {
            result = Math.max(result,
                    bestLeftPal[i] * bestRightPal[i]);
        }

        return 0;
    }

    private int bestPalDistance(int center, int n, long[] leftHash, long[] rightHash) {
        var l = 0; // there is certainly a palindrom with the lenght 0
        var r = Math.min(center, n - center - 1); // this is bounded by the position
        if (isPal(center, r, leftHash, rightHash)) {
            return r;
        }

        while (l + 1 < r) {
            var w = (l + r) / 2;
            if (isPal(center, w, leftHash, rightHash)) {
                l = w;
            } else {
                r = w;
            }
        }

        return l;
    }

    private boolean isPal(int center, int r, long[] leftHash, long[] rightHash) {
        return false;
    }

    private long pow(long a, long n) {
//        long r = 1;
//        while (n > 0) {
//            if (n % 2 == 1) {
//                r = (r * a) % P;
//            }
//            a = (a * a)
//        }
        return 0;
    }
}
