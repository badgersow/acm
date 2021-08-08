package leetcode.contest.weekly253;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class B {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int pile : piles) {
            heap.add(pile);
        }
        int removed = 0;
        for (int i = 0; i < k; i++) {
            final int head = heap.remove();
            removed += (head / 2);
            heap.add((head + 1) / 2);
        }

        return IntStream.of(piles).sum() - removed;
    }
}
