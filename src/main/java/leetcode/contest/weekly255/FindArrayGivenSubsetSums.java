package leetcode.contest.weekly255;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindArrayGivenSubsetSums {
    public int[] recoverArray(int n, int[] sums) {
        // First, let's deal with zeroes
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> maybeZeroCounts = new HashMap<>();

        for (int sum : sums) {
            maybeZeroCounts.put(sum, maybeZeroCounts.getOrDefault(sum, 0) + 1);
        }

        int maxPowerOfTwo = Integer.MAX_VALUE;
        for (Integer count : maybeZeroCounts.values()) {
            maxPowerOfTwo = Math.min(maxPowerOfTwo, powerOfTwo(count));
        }

        for (int i = 0; i < maxPowerOfTwo; i++) {
            result.add(0);
        }

        Map<Integer, Integer> counts = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : maybeZeroCounts.entrySet()) {
            counts.put(entry.getKey(), entry.getValue() >> maxPowerOfTwo);
        }

        Collections.sort(result);
        int[] finalResult = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            finalResult[i] = result.get(i);
        }

        // Now we have nonzero counts. Let's try to add numbers!
        inner:
        for (int i = result.size(); i < n; i++) {
            candidate:
            for (Integer candidate : counts.keySet()) {
                Map<Integer, Integer> hypotheticalCounts = new HashMap<>();
                for (Integer sum : counts.keySet()) {
                    if (counts.getOrDefault(sum, 0) <=
                            counts.getOrDefault(sum - candidate, 0) + counts.getOrDefault(sum + candidate, 0)) {
                        // Only 3 possibilities are possible. Equal, contains +can only, contains -can only
                        if (counts.getOrDefault(sum - candidate, 0).equals(counts.getOrDefault(sum + candidate, 0))) {
                            // Equal. This is fine
                            hypotheticalCounts.put(sum, counts.getOrDefault(sum, 0) / 2);
                        } else if (counts.getOrDefault(sum - candidate, 0) == 0) {
                            // Contains + can only. This means that we need to leave the current sum
                            hypotheticalCounts.put(sum, counts.getOrDefault(sum, 0));
                        } else if (counts.getOrDefault(sum + candidate, 0) == 0) {
                            // Contains - can only. This means we should do nothing
                        } else {
                            // Something went wrong for this candidate. Skipping it.
                            continue candidate;
                        }
                    } else {
                        // Candidate is definitely not okay
                        continue candidate;
                    }
                }
                result.add(candidate);
                counts = hypotheticalCounts;
            }
            throw new AssertionError("All candidates exhausted");
        }


        return finalResult;

    }

    private int powerOfTwo(int number) {
        int n = number;
        int power = 0;
        while (n > 0 && n % 2 == 0) {
            power++;
            n /= 2;
        }
        return power;
    }
}
