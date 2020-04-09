import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CsesIntroductoryGridPaths {

    public static void main(String[] args) throws Exception {
        new CsesIntroductoryGridPaths().solve();
    }

    final int n = 7;

    public void solve() throws Exception {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final char[] pattern = in.readLine().toCharArray();
        final long board = 0L;

        System.out.println(ways(pattern, 0, 0, 0, board));
    }

    private long ways(char[] pattern, int position, int I, int J, long board) {
        if (I == n - 1 && J == 0 && position < pattern.length) {
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

        if (I < 0 || I >= n || J < 0 || J >= n || (board & (1L << (I * n + J))) != 0) {
            return 0;
        }

        long newBoard = board | (1L << (I * n + J));

        long result = 0;
        char command = pattern[position];
        if (command == 'U' || command == '?') {
            result += ways(pattern, position + 1, I - 1, J, newBoard);
        }
        if (command == 'D' || command == '?') {
            result += ways(pattern, position + 1, I + 1, J, newBoard);
        }
        if (command == 'L' || command == '?') {
            result += ways(pattern, position + 1, I, J - 1, newBoard);
        }
        if (command == 'R' || command == '?') {
            result += ways(pattern, position + 1, I, J + 1, newBoard);
        }

        return result;
    }

}
