package leetcode.contest.weekly253;

public class A {
    public boolean isPrefixString(String s, String[] words) {
        int k = 0;
        String sModified = s;
        for (k = 0; k < words.length; k++) {
            if (words[k].length() > sModified.length()) {
                break;
            }
            if (sModified.startsWith(words[k])) {
                sModified = sModified.substring(words[k].length());
            } else {
                break;
            }
        }

        return k > 0 && sModified.isEmpty();
    }
}

