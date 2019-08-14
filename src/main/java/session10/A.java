package session10;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt(), s = in.nextInt();
        int best = -1;
        for (int i = 0; i < n; i++) {
            int dollars = in.nextInt(), cents = in.nextInt();
            if (dollars + (cents == 0 ? 0 : 1) <= s) {
                best = Math.max(best, (cents == 0 ? 0 : 100 - cents));
            }
        }

        System.out.println(best);
    }
}
