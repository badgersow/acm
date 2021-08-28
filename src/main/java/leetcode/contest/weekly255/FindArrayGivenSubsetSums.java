package leetcode.contest.weekly255;

import java.util.*;

public class FindArrayGivenSubsetSums {
    public int[] recoverArray(int n, int[] sums) {
        var subsets = Arrays.copyOf(sums, sums.length);
        Arrays.sort(subsets);
        var original = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            var candidate = subsets[0] - subsets[1];
            var remaining = tryExtract(subsets, candidate);
            if (remaining == null) {
                remaining = tryExtract(subsets, -candidate);
                original.add(-candidate);
            } else {
                original.add(candidate);
            }
            subsets = remaining;
        }

        return original.stream().mapToInt(x -> x).sorted().toArray();
    }

    /**
     * Splits the array a to 2 arrays: B and B+x.
     * Returns the array B.
     * If the split is not possible, returns null.
     * Example:
     * tryExtract([1,2,3,4], 2) = [1,2]
     */
    private int[] tryExtract(int[] a, int x) {

        var countByNum = new TreeMap<Integer, Integer>(x >= 0 ? Comparator.naturalOrder() : Comparator.reverseOrder());
        for (int number : a) {
            countByNum.compute(number, (k, v) -> v == null ? 1 : v + 1);
        }

        var result = new ArrayList<Integer>();
        while (!countByNum.isEmpty()) {
            var extremum = countByNum.lastKey();
            if (!countByNum.containsKey(extremum - x)) {
                return null;
            }
            countByNum.compute(extremum, (k, v) -> v == 1 ? null : v - 1);
            countByNum.compute(extremum - x, (k, v) -> v == 1 ? null : v - 1);

            result.add(extremum - x);
        }

        if (result.contains(0)) {
            return result.stream().mapToInt(Integer::intValue).sorted().toArray();
        }
        return null;
    }

}
