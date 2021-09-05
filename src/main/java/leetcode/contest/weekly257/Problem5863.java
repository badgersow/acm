package leetcode.contest.weekly257;

public class Problem5863 {

    public int countQuadruplets(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int p = k + 1; p < nums.length; p++) {
                        if (nums[i] + nums[j] + nums[k] == nums[p]) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }

}
