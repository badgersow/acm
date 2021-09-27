package leetcode.contest.weekly260;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Problem5884 {

    int BOUND = 1000;

    Set<Integer>[][] dp = new Set[32][32];

    char[] ch;

    public int scoreOfStudents(String expression, int[] answers) {
        ch = expression.toCharArray();
        Set<Integer> possible = possibleValues(0, ch.length);
        System.out.println(possible);

        int realAnswer = real(0, ch.length);

        int sum = 0;
        for (int answer : answers) {
            if (answer == realAnswer) {
                sum += 5;
            } else if (possible.contains(answer)) {
                sum += 2;
            }
        }

        return sum;
    }

    private int real(int from, int to) {
        if (from + 1 == to) {
            return ch[from] - '0';
        }

        // Looking for '+'
        for (int i = from + 1; i < to; i += 2) {
            if (ch[i] == '+') {
                return real(from, i) + real(i + 1, to);
            }
        }

        // Else, there are no +. Multiply everything.
        int result = 1;
        for (int i = from; i < to; i += 2) {
            result *= (ch[i] - '0');
        }

        return result;
    }

    private Set<Integer> possibleValues(int from, int to) {
        if (from + 1 == to) {
            return Collections.singleton(ch[from] - '0');
        }

        if (dp[from][to] != null) {
            return dp[from][to];
        }

        Set<Integer> values = new HashSet<>();
        for (int i = from + 1; i < to; i += 2) {
            Set<Integer> leftHalf = possibleValues(from, i);
            Set<Integer> rightHalf = possibleValues(i + 1, to);
            char sign = ch[i];

            for (Integer left : leftHalf) {
                for (Integer right : rightHalf) {
                    final var value = sign == '+' ? left + right : left * right;
                    if (value <= BOUND) {
                        values.add(value);
                    }
                }
            }
        }

        return dp[from][to] = values;
    }
}