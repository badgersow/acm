package session8;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int n = in.nextInt(), k = in.nextInt();
        int result = 0;
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int currentDigits = 0;
            while (a > 0) {
                int d = a % 10;
                if (d == 4 || d == 7) {
                    currentDigits++;
                }
                a /= 10;
            }
            if (currentDigits <= k) {
                result++;
            }
        }

        System.out.println(result);
    }
}
