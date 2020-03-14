import java.util.Scanner;

public class CsesIntroductoryIncreasingArray {

    public static void main(String[] args) {
        new CsesIntroductoryIncreasingArray().solve();
    }

    void solve() {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        int maximum = in.nextInt();
        long result = 0;

        for (int i = 0; i < (n - 1); i++) {
            final int next = in.nextInt();
            result += Math.max(0, maximum - next);
            maximum = Math.max(next, maximum);
        }

        System.out.println(result);
    }

}
