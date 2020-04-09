import java.util.Scanner;

public class CsesIntroductoryAppleDivision {

    public static void main(String[] args) {
        new CsesIntroductoryAppleDivision().solve();
    }

    public void solve() {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        long result = Long.MAX_VALUE;
        for (int mask = 0; mask < (1 << n); mask++) {
            long group1 = 0, group2 = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0) {
                    group1 += a[i];
                } else {
                    group2 += a[i];
                }
            }
            result = Math.min(result, Math.abs(group1 - group2));
        }

        System.out.println(result);
    }

}
