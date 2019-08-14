package session1;

import java.util.Scanner;

public class H {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        int low = 1, hi = 1_000_000_001;
        while (true) {
            int mid = (low + hi) / 2;
            System.out.println("Q " + mid);
            System.out.flush();

            String ans = in.nextLine();
            if ("=".equals(ans)) {
                return;
            } else if (">".equals(ans)) {
                low = mid;
            } else {
                hi = mid;
            }
        }
    }
}
