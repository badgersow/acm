package structures;

import java.util.ArrayList;
import java.util.List;

public class Combinatorics {

    public static List<List<Integer>> permutations(List<Integer> elements) {
        List<List<Integer>> result = new ArrayList<>();
        collectPermutations(0, elements, new ArrayList<>(), result);
        return result;
    }

    private static void collectPermutations(int mask, List<Integer> elements, ArrayList<Integer> prefix, List<List<Integer>> result) {
        int n = elements.size();
        if (mask == (1 << n) - 1) {
            result.add(new ArrayList<>(prefix));
            return;
        }
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0) {
                prefix.add(elements.get(i));
                collectPermutations(mask | (1 << i), elements, prefix, result);
                prefix.remove(prefix.size() - 1);
            }
        }
    }

    public static List<List<Integer>> combinations(List<Integer> elements, int k) {
        if (k > elements.size()) {
            throw new AssertionError("Subset size " + k + " should be no more than the set size " + elements.size());
        }
        List<List<Integer>> result = new ArrayList<>();
        collectCombinations(0, k, elements, new ArrayList<>(), result);
        return result;
    }

    private static void collectCombinations(int index, int k, List<Integer> elements, ArrayList<Integer> prefix, List<List<Integer>> result) {
        int n = elements.size();
        if (prefix.size() == k) {
            result.add(new ArrayList<>(prefix));
            return;
        }
        if (index == n) {
            return;
        }
        prefix.add(elements.get(index));
        // Collect with element
        collectCombinations(index + 1, k, elements, prefix, result);
        prefix.remove(prefix.size() - 1);
        // Collect without element
        collectCombinations(index + 1, k, elements, prefix, result);
    }


}
