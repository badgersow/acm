package leetcode.contest.weekly257;

public class Problem5866 {

    int[] ref = new int[30_001];

    private int get(int a) {
        if (ref[a] == a) {
            return a;
        }

        return (ref[a] = get(ref[a]));
    }

    private void union(int a, int b) {
        if (get(a) == get(b)) {
            return;
        }

        ref[get(a)] = get(b);
    }

    public boolean gcdSort(int[] nums) {
        for (int i = 0; i < ref.length; i++) {
            ref[i] = i;
        }

        // Populate the union-set
        for (int i = 0; i < nums.length; i++) {
            // Factorize each num and put it into the set
            int n = nums[i];
            for (int d = 2; d * d <= n; d++) {
                if (n % d == 0) {
                    // We union the number with all it's prime factors
                    union(n, d);
                    union(n, n / d);
                }
            }
        }

        // Just check inversions
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    if (get(nums[i]) != get(nums[j])) {
                        return false;
                    }
                }
            }
        }

        // Sort each component


        return true;
    }

}
