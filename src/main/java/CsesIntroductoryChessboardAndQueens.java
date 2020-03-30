import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CsesIntroductoryChessboardAndQueens {

    public static void main(String[] args) throws Exception {
        new CsesIntroductoryChessboardAndQueens().solve();
    }

    public void solve() throws Exception {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        grid = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            final char[] line = in.readLine().toCharArray();
            for (int j = 0; j < line.length; j++) {
                grid[i][j] = (line[j] == '.');
            }
        }

        System.out.println(f(0, 0));
    }


    private int N = 8;

    private boolean[][] grid = new boolean[N][N];

    private int[] queenExtraction = new int[N];

    private long f(int line, long queensCode) {
        if (line == N) {
            // We did it
            return 1;
        }

        long result = 0L;
        for (int position = 0; position < N; position++) {
            int[] queens = extractQueens(queensCode);
            if (grid[line][position] && canPutQueen(line, position, queens)) {
                queens = extractQueens(queensCode);
                queens[line] = position;
                final long newCode = codeQueens(queens);
                result += f(line + 1, newCode);
            }
        }

        return result;
    }

    public long codeQueens(int[] queens) {
        long code = 0;
        for (int i = 0; i < N; i++) {
            code = code * N + queens[i];
        }
        return code;
    }

    public int[] extractQueens(long queensCode) {
        for (int i = queenExtraction.length - 1; i >= 0; i--) {
            queenExtraction[i] = (int) (queensCode % N);
            queensCode = queensCode / N;
        }
        return queenExtraction;
    }

    public boolean canPutQueen(int line, int position, int[] previousQueens) {
        for (int i = 0; i < line; i++) {
            // Same line
            if (previousQueens[i] == position) {
                return false;
            }

            // Diagonal
            if (Math.abs(previousQueens[i] - position) == Math.abs(i - line)) {
                return false;
            }
        }

        return true;
    }

}
