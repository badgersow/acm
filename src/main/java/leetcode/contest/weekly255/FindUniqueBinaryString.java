package leetcode.contest.weekly255;

import java.util.HashSet;
import java.util.Set;

public class FindUniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> existingNumbers = new HashSet<>();

        int n = nums.length;
        for (String s : nums) {
            existingNumbers.add(toNumber(n, s));
        }

        for (int i = 0; i < (1 << n); i++) {
            if (!existingNumbers.contains(i)) {
                return toString(n, i);
            }
        }

        return "This shouldn't happen";
    }

    int toNumber(int n, String s) {
        final char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result *= 2;
            result += (chars[i] - '0');
        }
        return result;
    }

    String toString(int n, int a) {
        final StringBuilder b = new StringBuilder();
        for (int i = 0; i < n; i++) {
            b.append((char) ((a % 2) + '0'));
            a /= 2;
        }
        return b.reverse().toString();
    }
}
