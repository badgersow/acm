package interview.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSquares {
    public Set<List<String>> allWordSquares(List<String> words) {
        if (words.isEmpty()) {
            return Collections.emptySet();
        }

        int n = words.size();
        int k = words.iterator().next().length();

        if (k > n) {
            return Collections.emptySet();
        }

        Set<List<String>> result = new HashSet<>();
        fillResult(n, k, words, new ArrayList<>(), result);

        return result;
    }

    private void fillResult(int n, int k, List<String> words, List<Integer> prefix, Set<List<String>> result) {
        // Edge case. If we have already created the square
        if (prefix.size() == k) {
            addToResult(result, words, prefix);
            return;
        }

        // Try to add one more word
        for (int i = 0; i < n; i++) {
            // O(K), not great
            if (prefix.contains(i)) {
                continue;
            }

            // O(K)
            if (wordFits(words, prefix, i)) {
                // Try to pick this word
                prefix.add(i);
                fillResult(n, k, words, prefix, result);
                prefix.remove(prefix.size() - 1);
            }
        }
    }

    private void addToResult(Set<List<String>> result, List<String> words, List<Integer> prefix) {
        List<String> square = new ArrayList<>();
        for (Integer index : prefix) {
            square.add(words.get(index));
        }
        result.add(square);
    }

    public boolean wordFits(List<String> words, List<Integer> prefix, int newWordIndex) {
        String newWord = words.get(newWordIndex);

        // Now, let’s check
        int insertingRow = prefix.size();
        int charactersToCheck = insertingRow;
        for (int i = 0; i < charactersToCheck; i++) {
            // Comparing the row #insertingRow with the colume #insertingColumn
            char rowChar = newWord.charAt(i);
            char columnChar = words.get(prefix.get(i)).charAt(insertingRow);

            if (rowChar != columnChar) {
                // New word doesn’t fit for sure
                return false;
            }
        }

        return true;
    }

}
