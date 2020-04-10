import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class CsesSortingApartments {

    public static void main(String[] args) throws Exception {
        new CsesSortingApartments().solve();
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
        final int n = nextInt(), m = nextInt(), k = nextInt();
        final int[] people = new int[n], apartments = new int[m];

        for (int i = 0; i < n; i++) {
            people[i] = nextInt();
        }

        for (int i = 0; i < m; i++) {
            apartments[i] = nextInt();
        }

        Arrays.sort(people);
        Arrays.sort(apartments);

        int peopleIndex = 0, apartmentIndex = 0;
        int result = 0;
        while (peopleIndex < n && apartmentIndex < m) {
            final int expectation = people[peopleIndex];
            final int reality = apartments[apartmentIndex];
            if (expectation + k >= reality &&
                    reality >= expectation - k) {
                // This guy gets an apartment
                result++;
                peopleIndex++;
                apartmentIndex++;
                continue;
            }

            if (expectation + k < reality) {
                // The guy wants a smaller apartment. He is out.
                peopleIndex++;
                continue;
            }

            // The guy wants a larger apartment. Current apartment is shit.
            apartmentIndex++;
        }

        out.println(result);
        out.flush();
    }
}
