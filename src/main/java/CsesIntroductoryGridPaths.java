import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CsesIntroductoryGridPaths {

    public static void main(String[] args) throws Exception {
        new CsesIntroductoryGridPaths().solve();
    }

    final int n = 7;

    public void solve() throws Exception {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        p = in.readLine().toCharArray();
        v = new boolean[n * n];

        System.out.println(ways(0, 0));
    }

    char[] p;
    boolean[] v;
    int pos;

    private long ways(int i, int j) {
        if (pos == p.length) {
            if (i == n - 1 && j == 0) {
                return 1;
            }
            return 0;
        }

        // if I hit the wall and can't proceed
        if ((i == 0 || i == n - 1) && j > 0 && j < n - 1 && !v[i * n + j - 1] && !v[i * n + j + 1] ||
                (j == 0 || j == n - 1) && i > 0 && i < n - 1 && !v[(i - 1) * n + j] && !v[(i + 1) * n + j]) {
            return 0;
        }

        long result = 0;
        char command = p[pos];
        if ((command == 'U' || command == '?') && (i > 0 && !v[(i - 1) * n + j])) {
            v[i * n + j] = true;
            pos++;
            result += ways(i - 1, j);
            pos--;
            v[i * n + j] = false;
        }
        if ((command == 'D' || command == '?') && (i < n - 1 && !v[(i + 1) * n + j])) {
            v[i * n + j] = true;
            pos++;
            result += ways(i + 1, j);
            pos--;
            v[i * n + j] = false;
        }
        if ((command == 'L' || command == '?') && (j > 0 && !v[i * n + j - 1])) {
            v[i * n + j] = true;
            pos++;
            result += ways(i, j - 1);
            pos--;
            v[i * n + j] = false;
        }
        if ((command == 'R' || command == '?') && (j < n - 1 && !v[i * n + j + 1])) {
            v[i * n + j] = true;
            pos++;
            result += ways(i, j + 1);
            pos--;
            v[i * n + j] = false;
        }

        return result;
    }

}
