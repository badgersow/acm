package leetcode.contest.weekly257;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Problem5866 {

    int[] ref = new int[100_001];

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

        // Sort each component
        Map<Integer, List<Integer>> numbersByComponent = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int component = get(nums[i]);
            numbersByComponent.putIfAbsent(component, new ArrayList<>());
            numbersByComponent.get(component).add(nums[i]);
        }

        Map<Integer, Queue<Integer>> queueByComponent = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry : numbersByComponent.entrySet()) {
            int component = entry.getKey();
            List<Integer> numbers = entry.getValue();

            Collections.sort(numbers);
            queueByComponent.put(component, new ArrayDeque<>(numbers));
        }

        List<Integer> sortedResult = new ArrayList<>();
        for (int num : nums) {
            sortedResult.add(queueByComponent.get(get(num)).remove());
        }

        for (int i = 1; i < sortedResult.size(); i++) {
            if (sortedResult.get(i) < sortedResult.get(i - 1)) {
                return false;
            }
        }


        return true;
    }

}
