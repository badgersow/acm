package session6;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();

        int chest = 0, biceps = 0, back = 0;

        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            if (i % 3 == 0) {
                chest += a;
            } else if (i % 3 == 1) {
                biceps += a;
            } else {
                back += a;
            }
        }

        if (chest > biceps && chest > back) {
            System.out.println("chest");
        }

        if (biceps > chest && biceps > back) {
            System.out.println("biceps");
        }

        if (back > chest && back > biceps) {
            System.out.println("back");
        }
    }
}
