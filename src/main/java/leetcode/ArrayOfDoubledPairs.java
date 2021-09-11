package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ArrayOfDoubledPairs {
    // Time: 7:36:17 pm
// Questions: upper bound on the size of the array
// Range of element values
// O(n log n) time
// O(n) additional memory

        public boolean canReorderDoubled(int[] arr) {
            // Let's process positives, negatives and zeros separately.
            List<Integer> positives = new ArrayList<>();
            List<Integer> negatedNegatives = new ArrayList<>();
            int zeroCount = 0;

            for (int number : arr) {
                if (number == 0) {
                    zeroCount++;
                } else if (number > 0) {
                    positives.add(number);
                } else {
                    negatedNegatives.add(-number);
                }
            }

            return zeroCount % 2 == 0 && // Short circuit if the number of zeros is not suitable
                    canReorderDoubledPositives(positives) &&
                    canReorderDoubledPositives(negatedNegatives);
        }

        // numbers = [1,2,4,4,8,16]
        // indexesByValue = {1: [0], 2: [1], 4: [2,3], 8: [4], 16: [5]}
        // used = [false, false, false, false, false, false]
        public boolean canReorderDoubledPositives(List<Integer> numbers) {
            Collections.sort(numbers);
            Map<Integer, Queue<Integer>> indexesByValue = new HashMap<>();
            boolean[] used = new boolean[numbers.size()];

            for (int i = 0; i < numbers.size(); i++) {
                int value = numbers.get(i);
                indexesByValue.computeIfAbsent(value, ArrayDeque::new);
                indexesByValue.get(value).add(i);
            }

            // Let's go from biggest to smallest and eliminate pairs
            for (int i = numbers.size() - 1; i >= 0; i--) {
                if (used[i]) {
                    continue;
                }
                // Let's find a pair to this element!
                int value = numbers.get(i);
                if (value % 2 == 1) {
                    // If the largest number is odd, then can't arrange!
                    return false;
                }
                used[i] = true;

                // Remove the current value from all structures
                indexesByValue.get(value).remove();
                if (indexesByValue.get(value).isEmpty()) {
                    indexesByValue.remove(value);
                }

                int pair = value / 2;
                if (indexesByValue.containsKey(pair)) {
                    int lastPairIndex = indexesByValue.get(pair).remove();
                    used[lastPairIndex] = true;
                    if (indexesByValue.get(pair).isEmpty()) {
                        indexesByValue.remove(pair);
                    }
                } else {
                    return false;
                }
            }

            return true;
        }
}
