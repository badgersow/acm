import java.util.Scanner;

public class CsesIntroductoryTrailingZeros {

    public static void main(String[] args) {
        new CsesIntroductoryTrailingZeros().solve();
    }

    public void solve() {
        final Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = 0;

        while (n > 0) {
            result += n / 5;
            n /= 5;
        }

        System.out.println(result);
    }

}
