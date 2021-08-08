package leetcode.contest.weekly253;

public class C {
    public int minSwaps(String s) {
        final char[] a = s.toCharArray();
        int lastOpening = a.length - 1;
        for (; lastOpening >= 0; lastOpening--) {
            if (a[lastOpening] == '[') {
                break;
            }
        }
        int swaps = 0;
        int balance = 0;
        for (int i = 0; i < a.length; i++) {
            if (i >= lastOpening) {
                break;
            }

            if (a[i] == '[') {
                balance++;
            } else {
                balance--;
            }

            if (balance == -1) {
                swaps++;
                // then we need to swap
                a[i] = '[';
                a[lastOpening] = ']';
                for (lastOpening--; lastOpening >= 0; lastOpening--) {
                    if (a[lastOpening] == '[') {
                        break;
                    }
                }
                balance = 1;
            }
        }

        return swaps;
    }
}
