package session3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class A {

    private static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    private static PrintWriter out = new PrintWriter(System.out);

    private static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws Exception {
        final int n = nextInt(), d = nextInt();
        final int[] a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        a[n] = Integer.MAX_VALUE;

        long ans = 0;
        for (int firstPoint = 0; firstPoint < n - 1; firstPoint++) {
            final int threshold = a[firstPoint] + d;
            int l = firstPoint + 1, h = n;
            while (l + 1 < h) {
                int mid = (l + h) / 2;
                if (a[mid] > threshold) {
                    h = mid;
                } else {
                    l = mid;
                }
            }

            if (a[l] <= threshold) {
                ans += choises(l - firstPoint + 1);
            }
        }

        out.println(ans);
        out.flush();
    }

    private static long choises(int points) {
        if (points < 3) {
            return 0;
        }

        return (points - 1L) * (points - 2L) / 2;
    }

}
