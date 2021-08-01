package leetcode.contest.weekly252;

public class A {
    public boolean isThree(int n) {
        if (n == 1) {
            return false;
        }

        int d = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                d++;
            }
        }

        return d == 3;
    }
}
