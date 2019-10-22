package ipsc2001;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class H {

    private static int n;

    public static void main(String[] args) {
        final PrintWriter out = new PrintWriter(System.out);

        n = 15;
        final List<Set<Integer>> partSets = new ArrayList<>();

        generateSubsets(1, n / 2, new ArrayList<>(), partSets);

        Collections.shuffle(partSets);

        final Set<Set<Integer>> reservedSets = new HashSet<>();
        final Map<Set<Integer>, Integer> cardByPartSet = new HashMap<>();

        boolean foundSolution = assignTheNumbers(0, partSets, reservedSets, cardByPartSet);

        if (!foundSolution) {
            out.println("MAGIC");
        } else {
            for (Map.Entry<Set<Integer>, Integer> entry : cardByPartSet.entrySet()) {
                final Set<Integer> partSet = entry.getKey();
                final Integer number = entry.getValue();

                partSet.forEach(k -> out.print(k + " "));
                out.print(number);
                out.print(" -> ");
                out.println(number);
            }
        }

        out.flush();
    }

    private static boolean assignTheNumbers(int position, List<Set<Integer>> partSets, Set<Set<Integer>> reservedSets, Map<Set<Integer>, Integer> cardByPartSet) {
        if (position == partSets.size()) {
            // Found the solution.
            return true;
        }

        final Set<Integer> currentPartSet = partSets.get(position);
        final Set<Integer> newWholeSet = new HashSet<>(currentPartSet);
        for (int i = 1; i <= n; i++) {
            if (currentPartSet.contains(i)) {
                // Only complement numbers are interesting.
                continue;
            }

            // Let's try to assign to this number.

            newWholeSet.add(i);
            if (reservedSets.contains(newWholeSet)) {
                // Sorry, this is already taken
                newWholeSet.remove(i);
                continue;
            }

            reservedSets.add(newWholeSet);
            cardByPartSet.put(currentPartSet, i);

            boolean result = assignTheNumbers(position + 1, partSets, reservedSets, cardByPartSet);
            if (result) {
                return true;
            }

            reservedSets.remove(newWholeSet);
            cardByPartSet.remove(currentPartSet, i);
            newWholeSet.remove(i);
        }

        return false;
    }

    private static void generateSubsets(int position, int needElements, ArrayList<Integer> taken, List<Set<Integer>> allSets) {
        if (position > n) {
            if (needElements == taken.size()) {
                allSets.add(new HashSet<>(taken));
            }

            // We have reached the end.
            return;
        }

        // 2. Skip current element
        generateSubsets(position + 1, needElements, taken, allSets);

        // 1. Take current element if enough space
        if (needElements > taken.size()) {
            taken.add(position);
            generateSubsets(position + 1, needElements, taken, allSets);
            taken.remove(taken.size() - 1);
        }
    }

}
