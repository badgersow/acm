import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class CsesIntroductoryCreatingStrings1 {

    public static void main(String[] args) throws Exception {
        new CsesIntroductoryCreatingStrings1().solve();
    }

    private Set<String> all = new LinkedHashSet<>();

    public void solve() throws Exception {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final char[] input = in.readLine().toCharArray();
        Arrays.sort(input);

        fill(input, 0, new StringBuilder());

        System.out.println(all.size());
        System.out.println(String.join("\n", all));
    }

    private void fill(char[] input, int mask, StringBuilder builder) {
        if (mask == (1 << input.length) - 1) {
            // We are done.
            all.add(builder.toString());
            return;
        }

        for (int i = 0; i < input.length; i++) {
            if ((mask & (1 << i)) == 0) {
                builder.append(input[i]);
                fill(input, mask | (1 << i), builder);
                builder.setLength(builder.length() - 1);
            }
        }
    }


}
