package session8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class B {
    private static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    private static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws Exception {
        int n = nextInt(), k = nextInt();
        final int[] a = new int[n];
        int sum = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }

        // 1. Flip negative incomes
        for (int i = 0; i < n; i++) {
            if (k > 0 && a[i] < 0) {
                k--;
                a[i] = -a[i];
            }

            sum += a[i];
            min = Math.min(min, a[i]);
        }

        // 2. k %= 2
        k %= 2;

        // 3. Maybe sacrifice smallest number
        System.out.println(k == 0 ? sum : (sum - 2 * min));
    }
}
