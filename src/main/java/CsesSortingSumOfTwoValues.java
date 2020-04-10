import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.HashSet;
import java.util.Set;

public class CsesSortingSumOfTwoValues {

    public static void main(String[] args) throws Exception {
        new CsesSortingSumOfTwoValues().solve();
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

        final int[] a = new int[n];
        final Set<Integer> once = new HashSet<>();
        final Set<Integer> twice = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int next = nextInt();
            a[i] = next;
            boolean newElement = once.add(next);
            if (!newElement) {
                twice.add(next);
            }
        }

        int firstElement = -1, secondElement = -1;
        for (Integer element : once) {
            if (element + element == x) {
                if (twice.contains(element)) {
                    firstElement = secondElement = element;
                    break;
                }
            } else {
                final int other = x - element;
                if (once.contains(other)) {
                    firstElement = element;
                    secondElement = other;
                    break;
                }
            }
        }

        if (firstElement == -1) {
            out.println("IMPOSSIBLE");
        } else {
            int firstIndex = -1, secondIndex = -1;
            for (int i = 0; i < a.length; i++) {
                if (firstIndex == -1 && a[i] == firstElement) {
                    firstIndex = i + 1;
                } else if (secondIndex == -1 && a[i] == secondElement) {
                    secondIndex = i + 1;
                }
            }
            out.println(firstIndex + " " + secondIndex);
        }

        out.flush();
    }
}
