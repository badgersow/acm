package leetcode.contest.weekly251;

public class A {

    public int getLucky(String s, int k) {
        final char[] chars = s.toCharArray();
        if (k == 0) {
            StringBuilder b = new StringBuilder();
            for (char ch : chars) {
                b.append(charToInt(ch));
            }
            return Integer.parseInt(b.toString());
        }


        long x = 0;
        for (char c : chars) {
            x += charToInt(c);
        }

        for (int i = 0; i < k - 1; i++) {
            x = transform(x);
        }

        return (int) x;
    }

    private int charToInt(char c) {
        return (c - 'a' + 1) / 10 + (c - 'a' + 1) % 10;
    }

    private long transform(long x) {
        long result = 0;
        while (x > 0) {
            result += (x % 10);
            x /= 10;
        }

        return result;
    }


}
