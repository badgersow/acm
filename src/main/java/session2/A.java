package session2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws Exception {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final char[] initial = in.readLine().toCharArray();
        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < initial.length; i++) {
            result.append(initial[i]);
            if (i < initial.length - 2 && isVowel(initial[i]) && initial[i + 1] == 'p' && initial[i] == initial[i + 2]) {
                i += 2;
            }
        }
        System.out.println(result.toString());
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' | c == 'u';
    }
}
