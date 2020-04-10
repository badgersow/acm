import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CsesIntroductoryGridPaths {

    public static void main(String[] args) throws Exception {
        new CsesIntroductoryGridPaths().solve();
    }

    final int n = 7;

    public void solve() throws Exception {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        pattern = in.readLine().toCharArray();
        final long board = 0L;

        System.out.println(ways(0, 0, 0, board));
    }

    char[] pattern;

    private long ways(int position, int I, int J, long board) {
        // If we are out of bounds or on illegal step
        if (I < 0 || I >= n || J < 0 || J >= n || (board & (1L << (I * n + J))) != 0) {
            return 0;
        }

        // If we don't have enough steps to reach the target
        if (J + (n - 1 - I) > (pattern.length - position)) {
            return 0;
        }

        // Check if we can't reach the target
        if (position < pattern.length - 1
                && (((board & (1L << (n * (n - 1)))) != 0) ||
                (((board & (1L << (n * (n - 2)))) != 0) &&
                        ((board & (1L << (n * (n - 1) + 1))) != 0)))) {
            return 0;
        }

        // Reached the target ahead of time
        if (position < pattern.length && I == n - 1 && J == 0) {
            return 0;
        }

        if (position == pattern.length) {
            if (I != n - 1 || J != 0) {
                return 0;
            }

            if (board != ((1L << (n * n)) - 1) - (1L << (n * (n - 1)))) {
                return 0;
            }

            return 1;
        }


        long newBoard = board | (1L << (I * n + J));

        long result = 0;
        char command = pattern[position];
        if (command == 'U' || command == '?') {
            result += ways(position + 1, I - 1, J, newBoard);
        }
        if (command == 'D' || command == '?') {
            result += ways(position + 1, I + 1, J, newBoard);
        }
        if (command == 'L' || command == '?') {
            result += ways(position + 1, I, J - 1, newBoard);
        }
        if (command == 'R' || command == '?') {
            result += ways(position + 1, I, J + 1, newBoard);
        }

        return result;
    }

}
