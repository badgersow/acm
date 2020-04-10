import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class CsesSortingMovieFestival {

    public static void main(String[] args) throws Exception {
        new CsesSortingMovieFestival().solve();
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
        final int n = nextInt();
        final int[][] times = new int[n][2];

        for (int i = 0; i < n; i++) {
            times[i][0] = nextInt();
            times[i][1] = nextInt();
        }

        Arrays.sort(times, Comparator.comparing(arr -> arr[1]));

        int result = 0;
        int endTime = 0;
        for (int[] movie : times) {
            if (movie[0] >= endTime) {
                endTime = movie[1];
                result++;
            }
        }

        out.println(result);
        out.flush();
    }
}
