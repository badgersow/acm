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
        final boolean[][] board = new boolean[n][n];

        System.out.println(ways(pattern, 0, 0, 0, board));
    }

    private long ways(char[] pattern, int position, int I, int J, boolean[][] board) {
        if (I == n - 1 && J == 0 && position < pattern.length) {
            return 0;
        }

        if (position == pattern.length) {
            if (I != n - 1 || J != 0) {
                return 0;
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (i == n - 1 && j == 0) {
                        continue;
                    }
                    if (!board[i][j]) {
                        return 0;
                    }
                }
            }

            return 1;
        }

        if (I < 0 || I >= n || J < 0 || J >= n || board[I][J]) {
            return 0;
        }

        board[I][J] = true;


        long result = 0;
        char command = pattern[position];
        if (command == 'U' || command == '?') {
            result += ways(pattern, position + 1, I - 1, J, board);
        }
        if (command == 'D' || command == '?') {
            result += ways(pattern, position + 1, I + 1, J, board);
        }
        if (command == 'L' || command == '?') {
            result += ways(pattern, position + 1, I, J - 1, board);
        }
        if (command == 'R' || command == '?') {
            result += ways(pattern, position + 1, I, J + 1, board);
        }

        board[I][J] = false;
        return result;
    }

}
