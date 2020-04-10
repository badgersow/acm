import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class CsesSortingFerrisWheel {

    public static void main(String[] args) throws Exception {
        new CsesSortingFerrisWheel().solve();
    }

    private StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    private PrintWriter out = new PrintWriter(System.out);

    private int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    private String nextString() throws Exception {
        in.nextToken();
        return in.sval;
    }

    public void solve() throws Exception {
        final int n = nextInt(), x = nextInt();
        final Integer[] a = new Integer[n];

        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }

        Arrays.sort(a);

        int result = 0;
        int left = 0, right = n - 1;
        while (left <= right) {
            if (left == right) {
                // We have one kid left who goes to separate Goldola
                result++;
                break;
            }

            if (a[left] + a[right] <= x) {
                // Those kids can go together
                result++;
                left++;
                right--;
                continue;
            }

            // Our friend is too fat.
            result++;
            right--;
        }

        out.println(result);
        out.flush();
    }
}
