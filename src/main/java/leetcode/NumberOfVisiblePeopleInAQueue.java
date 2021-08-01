package leetcode;

import java.util.ArrayDeque;

public class NumberOfVisiblePeopleInAQueue {

    public int[] canSeePersonsCount(int[] heights) {
        final ArrayDeque<Integer> stack = new ArrayDeque<>();
        final int[] ans = new int[100_001];

        // Process all elements first
        for (int x : heights) {
            while (!stack.isEmpty() && stack.peekLast() < x) {
                ans[stack.peekLast()]++;
                stack.removeLast();
                if (!stack.isEmpty()) {
                    ans[stack.peekLast()]++;
                }
            }
            stack.addLast(x);
        }

        // And now process the rest of the stack
        while (!stack.isEmpty()) {
            stack.removeLast();
            if (!stack.isEmpty()) {
                ans[stack.peekLast()]++;
            }
        }

        final int[] result = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            result[i] = ans[heights[i]];
        }

        return result;
    }

}
