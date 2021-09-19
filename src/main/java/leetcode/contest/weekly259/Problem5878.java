package leetcode.contest.weekly259;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem5878 {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int n = s.length();
        char[] ch = s.toCharArray();
        int[] freq = new int['z' + 1];

        for (char c : ch) {
            freq[c]++;
        }

        List<Integer> candidates = new ArrayList<>();
        for (int i = 'z'; i >= 'a'; i--) {
            for (int j = 0; j < freq[i] / k; j++) {
                candidates.add(i);
            }
        }

        int[][] next = new int[n]['z' - 'a' + 1];
        for (int[] ints : next) {
            Arrays.fill(ints, -1);
        }
        int[] first = new int['z' - 'a' + 1];
        Arrays.fill(first, -1);
        for (int i = 0; i < ch.length; i++) {
            // For each of the last characters I set the current character as the next
            int code = ch[i] - 'a';
            for (int j = i - 1; j >= 0; j--) {
                if (next[j][code] == -1) {
                    next[j][code] = i;
                }
            }
            if (first[code] == -1) {
                first[code] = i;
            }
        }

        Set<String> uniqueSubsequences = new HashSet<>();
        for (int length = 0; length <= candidates.size(); length++) {
            for (List<Integer> combination : combinations(candidates, length)) {
                for (List<Integer> permutation : permutations(combination)) {
                    StringBuilder newString = new StringBuilder();
                    for (Integer code : permutation) {
                        newString.append((char) code.intValue());
                    }
                    uniqueSubsequences.add(newString.toString());
                }
            }
        }

        List<String> subsequences = uniqueSubsequences.stream().sorted(Comparator.comparingInt(String::length).reversed().thenComparing(Comparator.reverseOrder()))
                .collect(Collectors.toList());
        for (String subsequence : subsequences) {
            if (canForm(subsequence.toCharArray(), first, next, k)) {
                return subsequence;
            }
        }
        return "";
    }

    private boolean canForm(char[] subsequence, int[] first, int[][] next, int k) {
        int index = -1;
        for (int repetition = 0; repetition < k; repetition++) {
            for (int i = 0; i < subsequence.length; i++) {
                if (index == -1) {
                    // First character
                    index = first[subsequence[i] - 'a'];
                } else {
                    index = next[index][subsequence[i] - 'a'];
                }
                if (index == -1) {
                    // Not found
                    return false;
                }
            }
        }
        return true;
    }

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
