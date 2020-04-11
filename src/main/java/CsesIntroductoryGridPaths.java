import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class CsesIntroductoryGridPaths {

    public static void main(String[] args) throws Exception {
        new CsesIntroductoryGridPaths().solve();
    }

    final int n = 7;
    final int length = 48;

    public void solve() throws Exception {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final String pattern = in.readLine();

        final char[] part1 = pattern.substring(0, length / 2).toCharArray();
        final char[] part2Rev = new StringBuffer(pattern.substring(length / 2)).reverse().toString().toCharArray();

        final Set<Long> middle1 = new HashSet<>();

        fillMiddle(part1, middle1, code(0, 0, 0, 0), n - 1, 0);

        System.out.println(middle1.size());
    }

    private void fillMiddle(char[] pattern, Set<Long> middle, long code, int illegalI, int illegalJ) {
        final long mask = mask(code);
        final int I = i(code), J = j(code), position = position(code);

        // If we are out of bounds or on illegal step
        if (I < 0 || I >= n || J < 0 || J >= n ||
                (mask & (1L << (I * n + J))) != 0 ||
                (I == illegalI && J == illegalJ)) {
            return;
        }

        if (position == pattern.length) {
            middle.add(code);
            return;
        }

        long newMask = mask | (1L << (I * n + J));

        char command = pattern[position];
        if (command == 'U' || command == '?') {
            fillMiddle(pattern, middle, code(newMask, I - 1, J, position + 1), illegalI, illegalJ);
        }
        if (command == 'D' || command == '?') {
            fillMiddle(pattern, middle, code(newMask, I + 1, J, position + 1), illegalI, illegalJ);
        }
        if (command == 'L' || command == '?') {
            fillMiddle(pattern, middle, code(newMask, I, J - 1, position + 1), illegalI, illegalJ);
        }
        if (command == 'R' || command == '?') {
            fillMiddle(pattern, middle, code(newMask, I, J + 1, position + 1), illegalI, illegalJ);
        }
    }

    long code(long mask, long i, long j, long position) {
        return mask | // First 49 bits
                (i << 49) | // Next 3 bits
                (j << 52) | // Next 3 bits
                (position << 55); // Next 6 bits
    }

    long mask(long code) {
        return code & ((1L << 49) - 1);
    }

    int i(long code) {
        return (int) ((code >> 49) & 7);
    }

    int j(long code) {
        return (int) ((code >> 52) & 7);
    }

    int position(long code) {
        return (int) ((code >> 55) & 63);
    }

}
