import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CsesIntroductoryPalindromeReorder {
    public static void main(String[] args) throws Exception {
        new CsesIntroductoryPalindromeReorder().solve();
    }

    public void solve() throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final char[] chars = in.readLine().toCharArray();

        final int[] counts = new int['Z' + 1];
        for (char character : chars) {
            counts[character]++;
        }

        int odds = 0;
        for (int c = 'A'; c <= 'Z'; c++) {
            if (counts[c] % 2 == 1) {
                odds++;
            }
        }

        if (odds > 1) {
            System.out.println("NO SOLUTION");
            return;
        }

        final StringBuilder result = new StringBuilder();
        for (int c = 'A'; c <= 'Z'; c++) {
            if (counts[c] % 2 == 0) {
                for (int i = 0; i < counts[c] / 2; i++) {
                    result.append((char) c);
                }
            }
        }

        for (int c = 'A'; c <= 'Z'; c++) {
            if (counts[c] % 2 == 1) {
                for (int i = 0; i < counts[c]; i++) {
                    result.append((char) c);
                }
            }
        }

        for (int c = 'Z'; c >= 'A'; c--) {
            if (counts[c] % 2 == 0) {
                for (int i = 0; i < counts[c] / 2; i++) {
                    result.append((char) c);
                }
            }
        }

        System.out.println(result.toString());
    }
}
