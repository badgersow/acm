package leetcode;

import java.util.Arrays;

public class Problem395 {

    // a[i][char] = closest j <= i such that a[j] == char
    int[][] prevPositionOf;

    // freq[i]['c'] - the number of character c in the frefix [0,i]
    int[][] freq;

    int k;

    int n;

    char[] ch;

    public int longestSubstring(String s, int k) {
        this.ch = s.toCharArray();
        this.k = k;
        this.n = ch.length;

        freq = new int[n]['z' - 'a' + 1];
        int[] freqVector = new int['z' - 'a' + 1];
        for (int i = 0; i < ch.length; i++) {
            freqVector[ch[i] - 'a']++;
            freq[i] = Arrays.copyOf(freqVector, freqVector.length);
        }

        prevPositionOf = new int[n]['z' - 'a' + 1];
        for (int code = 0; code <= 'z' - 'a'; code++) {
            char c = (char) (code + 'a');
            int prevPosition = -1;
            for (int i = 0; i < n; i++) {
                if (ch[i] == c) {
                    prevPosition = i;
                }
                prevPositionOf[i][code] = prevPosition;
            }
        }

        return solve(0, n);
    }

    // The longest substring where each character
    // has frequency at least k
    private int solve(int from, int to) {
        if (from >= to) {
            return 0;
        }

        char smallestOccurChar = '\0';
        int smallestCount = Integer.MAX_VALUE;
        for (int c = 'a'; c <= 'z'; c++) {
            int code = c - 'a';
            int charFreq = freq[to - 1][code] - (from == 0 ? 0 : freq[from - 1][code]);
            if (charFreq > 0 && charFreq < smallestCount) {
                smallestCount = charFreq;
                smallestOccurChar = (char) c;
            }
        }

        if (smallestCount >= k) {
            return to - from;
        }

        final var positionOfSmallestChar = prevPositionOf[to - 1][smallestOccurChar - 'a'];
        return Math.max(solve(from, prevPositionOf[to - 1][smallestOccurChar - 'a']),
                solve(positionOfSmallestChar + 1, to));
    }
}
