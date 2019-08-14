package session2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class B {

    private static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    private static PrintWriter out = new PrintWriter(System.out);

    private static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            final int n = nextInt(), k = nextInt();
            if (n == 0 && k == 0) {
                break;
            }

            final int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }

            final int[][] pre = new int[n + 1][];
            pre[0] = new int[]{0, 0};
            for (int i = 1; i <= n; i++) {
                pre[i] = new int[]{pre[i - 1][0] + a[i - 1], i};
            }

            Arrays.sort(pre, Comparator.comparing(x -> x[0]));

            for (int query = 0; query < k; query++) {
                final int t = nextInt();
                int l = 0, r = 1;
                int min = Integer.MAX_VALUE, ans = -1, ansl = -1, ansr = -1;

                while (r <= n) {
                    final int current = pre[r][0] - pre[l][0];
                    final int diff = Math.abs(t - current);
                    if (diff < min) {
                        min = diff;
                        ans = current;
                        ansl = pre[l][1];
                        ansr = pre[r][1];
                    }

                    if (current < t) {
                        r++;
                    } else if (current > t) {
                        l++;
                    } else {
                        break;
                    }

                    if (l == r) {
                        r++;
                    }
                }

                out.println(ans + " " + Math.min(ansl + 1, ansr + 1) + " " + Math.max(ansl, ansr));
            }
        }

        out.flush();
    }
}
