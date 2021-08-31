package interview.google;

import com.google.common.base.Preconditions;

public class StringExpander {

    public String expandString(String input) {
        return expandString(input, 0, input.length());
    }

    /**
     * Expand the string input from index (inclusive) to end (exclusive)
     */
    public String expandString(String input, int index, int end) {
        if (index == end) {
            return "";
        }

        int currentIndex = index;
        StringBuilder result = new StringBuilder();

        // In general string format is abc42[XXX]XXX
        // Read characters to string
        while (currentIndex < end && isLetter(input.charAt(currentIndex))) {
            result.append(input.charAt(currentIndex));
            currentIndex++;
        }

        if (currentIndex == end) {
            return result.toString();
        }

        // Read and populate the multiplier
        int multiplier = 0;
        while (currentIndex < end && isDigit(input.charAt(currentIndex))) {
            multiplier = (multiplier * 10) + (input.charAt(currentIndex) - '0');
            currentIndex++;
        }

        Preconditions.checkArgument(input.charAt(currentIndex) == '[');

        int matchingBracketIndex = findMatchingBracket(input, currentIndex);

        String bracketContent = expandString(input, currentIndex + 1, matchingBracketIndex);

        for (int i = 0; i < multiplier; i++) {
            result.append(bracketContent);
        }

        // ‘result’ contains the result of abc42[XXX]
        // Now append the rest

        result.append(

                expandString(input, matchingBracketIndex + 1, end));
        return result.toString();
    }

    public boolean isLetter(char c) {
        return c >= 'a' &&c <= 'z';
    }

    public boolean isDigit(char c) {
        return c >= '0' &&c <= '9';
    }

    public int findMatchingBracket(String input, int openBracketPosition) {
        int nestedness = 0;
        for (int i = openBracketPosition; i < input.length(); i++) {
            if (input.charAt(i) == '['){
                nestedness++;
            } else if (input.charAt(i) == ']'){
                nestedness--;
            }
            if (nestedness == 0) {
                return i;
            }
        }

        throw new IllegalArgumentException("No matching brace found");

    }


}
