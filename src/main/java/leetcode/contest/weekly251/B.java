package leetcode.contest.weekly251;

public class B {

    public String maximumNumber(String num, int[] change) {
        final int[] orig = new int[num.length()];
        for (int i = 0; i < orig.length; i++) {
            orig[i] = num.charAt(i) - '0';
        }

        int firstIndexToReplace = -1;
        // Find first char to be bigger
        for (int i = 0; i < orig.length; i++) {
            if (change[orig[i]] > orig[i]) {
                // This is the first one that should be replaced
                firstIndexToReplace = i;
                break;
            }
        }

        if (firstIndexToReplace != -1) {
            orig[firstIndexToReplace] = change[orig[firstIndexToReplace]];
            // Now we start with the next character and replace continuously until it doesn't make sense;
            for (int i = firstIndexToReplace + 1; i < orig.length; i++) {
                if (change[orig[i]] < orig[i]) {
                    // This means we have to stop
                    break;
                }

                // Otherwise replace and move forward
                orig[i] = change[orig[i]];
            }
        }

        int nonZeroIndex = 0;
        for (int i = 0; i < orig.length; i++) {
            if (orig[i] != 0) {
                nonZeroIndex = i;
                break;
            }
        }

        final StringBuilder resultBuilder = new StringBuilder();
        for (int i = nonZeroIndex; i < orig.length; i++) {
            resultBuilder.append(orig[i]);
        }

        final String result = resultBuilder.toString();
        return (result.isEmpty() ? "0" : result);
    }


}
