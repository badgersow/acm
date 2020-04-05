import java.util.Scanner;

public class CsesIntroductoryBitStrings {

    public static void main(String[] args) {
        new CsesIntroductoryBitStrings().solve();
    }

    public void solve() {
        final Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(pow(2, n));
    }

    private long pow(long a, long n) {
        final long p = 1_000_000_007;
        long r = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                r = (r * a) % p;
            }
            a = (a * a) % p;
            n /= 2;
        }
        return r;
    }

}
