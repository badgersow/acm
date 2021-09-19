package leetcode.contest.weekly259;

public class Problem5876 {
    public int sumOfBeauties(int[] a) {
        int n = a.length;
        int[] maxPrefix = new int[n];
        maxPrefix[0] = a[0];
        for (int i = 1; i < n; i++) {
            maxPrefix[i] = Math.max(maxPrefix[i - 1], a[i]);
        }

        int[] minSuffix = new int[n];
        minSuffix[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minSuffix[i] = Math.min(minSuffix[i + 1], a[i]);
        }

        int beauty = 0;
        for (int i = 1; i < n - 1; i++) {
            if (a[i] > maxPrefix[i - 1] && a[i] < minSuffix[i + 1]) {
                beauty += 2;
            } else if (a[i] > a[i - 1] && a[i] < a[i + 1]) {
                beauty++;
            }
        }

        return beauty;
    }
}
