package session7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class D {

    private static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    private static PrintWriter out = new PrintWriter(System.out);

    private static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws Exception {
        int n = nextInt();
        int[] a = new int[n];
        int[] sum = new int[n];
        boolean[] sign = new boolean[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }

        sum[n - 1] = a[n - 1];
        sign[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] >= sum[i + 1]) {
                // ai - sum
                sum[i] = a[i] - sum[i + 1];
                sign[i] = true;
            } else {
                // -ai + sum
                sum[i] = -a[i] + sum[i + 1];
                sign[i] = false;
            }
        }

        final StringBuilder result = new StringBuilder();
        boolean currentSign = true; // +
        for (int i = 0; i < n; i++) {
            result.append(sign[i] ^ currentSign ? '-' : '+');
            currentSign ^= sign[i];
        }

        System.out.println(result.toString());
    }

}
