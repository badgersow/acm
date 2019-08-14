package session1;

import java.util.Scanner;

public class F {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();

        long s = 0;
        for (int i = 0; i < n; i++) {
            s += in.nextInt();
        }

        System.out.println((s + 4) / 5);
    }
}
