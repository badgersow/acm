package leetcode.contest.weekly258;

public class Problem5869 {
    public int maxProduct(String s) {
        int n = s.length();
        final var chars = s.toCharArray();
        int[] maxPalinInMask = new int[(1 << n)];
        char[] maskChars = new char[n];
        for (int mask = 0; mask < (1 << n); mask++) {
            int subseqIndex = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) > 0) {
                    maskChars[subseqIndex++] = chars[i];
                }
            }
            maxPalinInMask[mask] = maxPalindrom(maskChars, subseqIndex);
        }

        int[] maxPalinInMaskSubseq = new int[1 << n];
        for (int mask = 0; mask < (1 << n); mask++) {
            maxPalinInMaskSubseq[mask] = maxPalinInMask[mask];
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0) {
                    continue;
                }
                int subMask = mask - (1 << i);
                maxPalinInMaskSubseq[mask] = Math.max(maxPalinInMaskSubseq[mask], maxPalinInMask[subMask]);
                maxPalinInMaskSubseq[mask] = Math.max(maxPalinInMaskSubseq[mask], maxPalinInMaskSubseq[subMask]);
            }
        }

        int result = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            result = Math.max(result,
                    maxPalinInMask[mask] *
                            maxPalinInMaskSubseq[(1 << n) - 1 - mask]);
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
