package session3;

import java.util.Arrays;
import java.util.Scanner;

public class B {

    static int[] tmp;

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        int[] q = new int[n + 1], s = new int[n + 1], p = new int[n + 1];
        tmp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            q[i] = in.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            s[i] = in.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }

        final int m = findM(q, s, p, k);
        final int[] qinv = inv(q);
        final int minv = findM(qinv, s, p, k);
        if (m <= 0 && minv <= 0) {
            System.out.println("NO");
            return;
        }

        if (Arrays.equals(q, qinv)) {
            if (m == k) {
                System.out.println("YES");
                return;
            } else {
                System.out.println("NO");
                return;
            }
        }

        if (m > 0 && (k - m) % 2 == 0
                || minv > 0 && (k - minv) % 2 == 0) {
            System.out.println("YES");
            return;
        }

        System.out.println("NO");
    }

    private static int findM(int[] q, int[] s, int[] p, int k) {
        if (Arrays.equals(p, s)) {
            return 0;
        }

        int[] newp = new int[p.length];
        System.arraycopy(p, 0, newp, 0, p.length);
        int m = 1;
        while (m <= k) {
            apply(newp, q);
            if (Arrays.equals(newp, s))
                return m;

            m++;
        }

        return -1;
    }

    private static void apply(int[] p, int[] q) {
        for (int i = 1; i < p.length; i++) {
            tmp[i] = p[q[i]];
        }
        System.arraycopy(tmp, 0, p, 0, p.length);
    }

    private static int[] inv(int[] q) {
        int[] qinv = new int[q.length];
        for (int i = 1; i < q.length; i++) {
            qinv[q[i]] = i;
        }
        return qinv;
    }


}
