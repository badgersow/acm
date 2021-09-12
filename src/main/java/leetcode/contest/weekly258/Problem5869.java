package leetcode.contest.weekly258;

import java.math.BigInteger;

public class Problem5869 {
    public int maxProduct(String s) {
        int n = s.length();
        final var chars = s.toCharArray();
        int[] maxPalinMyMask = new int[(1 << n)];
        char[] maskChars = new char[n];
        for (int mask = 0; mask < (1 << n); mask++) {
            int subseqIndex = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) > 0) {
                    maskChars[subseqIndex++] = chars[i];
                }
            }
            maxPalinMyMask[mask] = maxPalindrom(maskChars, subseqIndex);
        }

        int result = 0;
        int pow3 = BigInteger.valueOf(3).pow(n).intValue();
        for (int mask3 = 0; mask3 < pow3; mask3++) {
            int mask1 = 0;
            int mask2 = 0;

            int mask3Copy = mask3;
            for (int i = 0; i < n; i++) {
                int remainder = mask3Copy % 3;
                if (remainder == 0) {
                    // No mask gets anything
                } else if (remainder == 1) {
                    mask1 |= (1 << i);
                } else {
                    mask2 |= (1 << i);
                }
                mask3Copy /= 3;
            }

            result = Math.max(result, maxPalinMyMask[mask1] * maxPalinMyMask[mask2]);
        }

        return result;
    }

    public int maxPalindrom(char[] chars, int length) {
        if (length == 0) {
            return 0;
        }
        int maxOddPalindrom = 1;
        for (int center = 0; center < length; center++) {
            for (int diff = 1; center - diff >= 0 && center + diff < length; diff++) {
                if (chars[center - diff] == chars[center + diff]) {
                    maxOddPalindrom = Math.max(maxOddPalindrom, diff * 2 + 1);
                } else {
                    break;
                }
            }
        }
        int maxEvenPalindrom = 0;
        for (int center = 0; center < length; center++) {
            for (int diff = 0; center - diff >= 0 && center + diff + 1 < length; diff++) {
                if (chars[center - diff] == chars[center + diff + 1]) {
                    maxEvenPalindrom = Math.max(maxEvenPalindrom, (diff + 1) * 2);
                } else {
                    break;
                }
            }
        }
        return Math.max(maxOddPalindrom, maxEvenPalindrom);
    }
}
