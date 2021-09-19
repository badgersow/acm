package leetcode.contest.weekly259;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        int[] first = new int['z' - 'a' + 1];
        Map<Integer, Integer> previous = new HashMap<>();
        for (int i = 0; i < ch.length; i++) {
            if (previous.containsKey(ch[i] - 'a')) {
                next[previous.get(ch[i] - 'a')][ch[i] - 'a'] = i;
            } else {
                first[ch[i] - 'a'] = i;
            }
            previous.put(ch[i] - 'a', i);
        }

        tryPermutations(0, candidates, next, first);

        System.out.println(candidates);
        return "";
    }

    private List<Integer> tryPermutations(int index, List<Integer> candidates, int[][] next, int[] first) {
        if (index == candidates.size()) {

        }

        return null;
    }
}
