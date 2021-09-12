package leetcode.contest.weekly258;

public class Problem5867 {
    public String reversePrefix(String wordString, char ch) {
        int charPosition = -1;
        final var word = wordString.toCharArray();

        for (int i = 0; i < word.length; i++) {
            if (word[i] == ch) {
                charPosition = i;
                break;
            }
        }

        if (charPosition == -1) {
            return wordString;
        }

        return new StringBuffer(wordString.substring(0, charPosition + 1)).reverse().toString() +
                wordString.substring(charPosition + 1);
    }

}
