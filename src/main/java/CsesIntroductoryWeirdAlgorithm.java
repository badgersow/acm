import java.util.Scanner;

public class CsesIntroductoryWeirdAlgorithm {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        long n = in.nextLong();

        if (n == 1) {
            System.out.println(n);
            return;
        }

        do {
            System.out.print(n + " ");
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
        } while (n != 1);

        System.out.println(n);
    }

}
