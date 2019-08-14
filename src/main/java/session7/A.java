package session7;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        Arrays.sort(a);

        int filtersNeeded = 0;
        int sockets = k;

        if (sockets >= m) {
            System.out.println(0);
            return;
        }

        for (int i = a.length - 1; i >= 0; i--) {
            filtersNeeded++;
            sockets += a[i] - 1;
            if (sockets >= m) {
                System.out.println(filtersNeeded);
                return;
            }
        }

        System.out.println(-1);
    }
}
