package session1;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final long n = in.nextInt(), s = in.nextInt();

        final long[] a = new long[(int) n];

        long sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            final long start = in.nextInt();

            sum += (s - start);
        }

        Arrays.sort(a);

        for (int i = 0; i < a.length; i++) {
            sum += a[i] * (n - i);
        }

        System.out.println(sum);
    }
}
