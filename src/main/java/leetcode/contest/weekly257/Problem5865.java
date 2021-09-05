package leetcode.contest.weekly257;

public class Problem5865 {
    public int firstDayBeenInAllRooms(int[] a) {
        int P = 1_000_000_007;
        int n = a.length;
        int[] f = new int[a.length];
        f[0] = 0;

        for (int i = 1; i < n; i++) {
            f[i] = ((
                    (2 * f[i - 1]) % P
                            + P - f[a[i - 1]]) % P + 2) % P;
        }

        return f[n - 1];
    }
}
