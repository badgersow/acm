package session1;

import java.util.Scanner;

public class L {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int n = in.nextInt();


        int minOdd = Integer.MAX_VALUE;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int next = in.nextInt();
            ans += next;
            if (next % 2 == 1) {
                if (next < minOdd) {
                    minOdd = next;
                }
            }
        }

        System.out.println(ans % 2 == 0 ? ans : ans - minOdd);
    }
}
