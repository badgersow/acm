package session1;

import java.util.Scanner;

public class I {

    public static void main(String[] args) throws Exception {
        final Scanner in = new Scanner(System.in);
        final int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int a = in.nextInt(), b = in.nextInt();
            final int sum = a + b;
            if (Math.abs(a - b) <= 1) {
                System.out.println("Ok");
            } else {
                System.out.println(sum / 2 + " " + (sum + 1) / 2);
            }
        }
    }

}
