import java.util.Scanner;

public class CsesIntroductoryMissingNumber {

    public static void main(String[] args) {
        new CsesIntroductoryMissingNumber().solve();
    }

    void solve() {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();

        long sum = 0L;
        for (int i = 0; i < n - 1; i++) {
            sum += in.nextLong();
        }

        System.out.println(n * (n + 1L) / 2 - sum);
    }

}
