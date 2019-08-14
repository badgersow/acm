package session6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args) throws Exception {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final char[] c = in.readLine().toCharArray();
        int x = 0, y = 0;

        for (char letter : c) {
            if (letter == 'x') {
                x++;
            } else {
                y++;
            }
        }

        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < Math.abs(x - y); i++) {
            result.append(x > y ? 'x' : 'y');
        }

        System.out.println(result.toString());
    }
}
