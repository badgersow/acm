package interview.google;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

public class LongestSubsequenceFinder {
    public Optional<String> findLongestSubseq(String sequence, Set<String> subsequences) {
        // Ordered from the longest
        return subsequences.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .filter(subseq -> isSubsequence(sequence, subseq))
                .findFirst();
    }

    public boolean isSubsequence(String sequence, String subsequence) {
        if (subsequence.isEmpty()) {
            return true;
        }

        if (sequence.isEmpty()) {
            return false;
        }

        // Additional copying, but no check for the index bounds. This maybe can buy some time with the expence of memory.
        char[] seq = sequence.toCharArray();
        char[] subseq = subsequence.toCharArray();

        // For each character of the subsequence, find the next such character in the sequence
        int sequenceIndex = 0;
        for (int i = 0; i < subseq.length; i++) {
            // Let’s move the sequenceIndex to match the next character
            while (sequenceIndex < seq.length) {
                if (subseq[i] == seq[sequenceIndex]) {
                    // Found!
                    break;
                }
                sequenceIndex++;
            }

            if (sequenceIndex == seq.length) {
                // Not found. Hence not the subseq.
                return false;
            }

            // Increment because we need to searh next.
            sequenceIndex++;
        }

        // If we exit from the loop, then all the subseq is processed
        return true;
    }
}
