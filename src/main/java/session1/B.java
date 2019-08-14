package session1;

import java.util.Scanner;

public class B {

    public static void main(String[] args) throws Exception {
        final Scanner in = new Scanner(System.in);
        final long a = in.nextLong(), b = in.nextLong();
        final long c = in.nextLong(), d = in.nextLong();

        final long dist1 = a * a + b * b;
        final long dist2 = c * c + d * d;

        if (dist1 < dist2) {
            System.out.println("Russo");
        } else if (dist1 == dist2) {
            System.out.println("Empate");
        } else {
            System.out.println("Wil");
        }
    }

}
