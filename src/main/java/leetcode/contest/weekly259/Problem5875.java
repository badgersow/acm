package leetcode.contest.weekly259;

public class Problem5875 {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String op : operations) {
            if (op.contains("+")) {
                x++;
            } else {
                x--;
            }
        }
        return x;
    }
}
