package session5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class C {
    public static void main(String[] args) throws Exception {
        final BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        final PrintWriter out = new PrintWriter("output.txt");
        final char[] c = in.readLine().toCharArray(), t = in.readLine().toCharArray();
        final int[] neededChars = new int['Z' + 1];
        for (char targetChar : t) {
            neededChars[targetChar]++;
        }

        final int[] currentChars = new int['Z' + 1];
        for (char targetChar : c) {
            currentChars[targetChar]++;
        }

        int replacements = 0;
        final StringBuilder result = new StringBuilder();
        for (char current : c) {
            char replacement;
            char lowestExtra = lowestExtra(neededChars, currentChars);

            if (neededChars[current] >= currentChars[current]) {
                // We can keep the char, otherwise there'll be transformation
                replacement = current;
            } else {
                // We can keep or replace it (if we have more than needed)
                if (neededChars[current] == 0 || lowestExtra < current) {
                    // We can replace it with lower char
                    replacement = lowestExtra;
                } else {
                    replacement = current;
                }
            }

            result.append(replacement);
            neededChars[replacement]--;
            currentChars[current]--;
            if (current != replacement) {
                replacements++;
            }
        }

        out.println(replacements);
        out.println(result.toString());
        out.flush();
        out.close();
    }

    private static char lowestExtra(int[] neededChars, int[] currentChars) {
        for (char i = 'A'; i <= 'Z'; i++) {
            if (neededChars[i] > currentChars[i]) {
                return i;
            }
        }

        return 'Z' + 1;
    }

}
