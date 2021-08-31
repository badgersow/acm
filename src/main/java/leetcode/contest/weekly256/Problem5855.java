package leetcode.contest.weekly256;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Problem5855 {
    public String kthLargestNumber(String[] nums, int k) {
        var numbers = new ArrayList<BigInteger>();
        for (String num : nums) {
            numbers.add(new BigInteger(num));
        }
        Collections.sort(numbers);
        return numbers.get(numbers.size() - k).toString();
    }
}
