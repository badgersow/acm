package session7;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int N = in.nextInt(), M = in.nextInt();

        int[] first = emulate(N, M, 0);
        int[] second = emulate(N, M, 1);

        if (first[0] > second[0] || first[1] < second[1]) {
            System.out.println(first[0] + " " + first[1]);
        } else {
            System.out.println(second[0] + " " + second[1]);
        }
    }

    private static int[] emulate(int n, int m, int firstMove) {
        int[] left = new int[]{n, m};
        int[] scores = new int[]{0, 0};
        int last = -1;
        for (int i = 0; i < n + m; i++) {
            if (last == -1) {
                for (int j : (firstMove == 0 ? new int[]{0, 1} : new int[]{1, 0})) {
                    if (left[j] > 0) {
                        left[j]--;
                        last = j;
                        break;
                    }
                }
                continue;
            }

            int move = i % 2;
            // Try to do optimal move
            final int optimal = optimal(move, last);
            if (left[optimal] > 0) {
                left[optimal]--;
                scores[move]++;
            } else {
                left[1 - optimal]--;
                scores[1 - move]++;
            }
        }

        return scores;
    }

    private static int optimal(int move, int last) {
        if (move == 0) {
            return last;
        }

        return 1 - last;
    }
}
