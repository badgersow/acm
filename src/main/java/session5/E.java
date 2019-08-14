package session5;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class E {

    public static void main(String[] args) throws Exception {
        final Scanner in = new Scanner(System.in);
        final PrintWriter out = new PrintWriter(System.out);

        n = in.nextInt();
        consumption = in.nextInt();
        incomingFood = new int[n];
        final int friends = in.nextInt();
        final List<List<int[]>> friendsByDay = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            friendsByDay.add(new ArrayList<>());
        }

        for (int friend = 0; friend < friends; friend++) {
            final int l = in.nextInt() - 1, r = in.nextInt() - 1, f = in.nextInt();
            for (int day = l; day <= r; day++) {
                friendsByDay.get(day).add(new int[]{f, friend + 1});
            }
        }

        E.friendsByDay = new int[n][][];
        for (int i = 0; i < n; i++) {
            E.friendsByDay[i] = friendsByDay
                    .get(i)
                    .stream()
                    .sorted(Comparator.comparing(k -> k[0]))
                    .toArray(int[][]::new);
        }

        dp = new int[n][401];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        choises = new ArrayList[n][401];
        for (int i = 0; i < choises.length; i++) {

        }

        out.println(solve(0, 0));
        out.flush();
    }

    static int[][] dp;
    static int n, consumption;
    static int[][][] friendsByDay;
    static List[][] choises;
    static int[] incomingFood;

    private static int solve(int position, int oldFood) {
        if (position == n)
            return 0;

        if (dp[position][oldFood] > 0) {
            return dp[position][oldFood];
        }

        int result = Integer.MAX_VALUE;
        int partialSum = 0;
        int partialCount = 0;
        int friendIndex = 0;
        int leftOldFood = 0, leftNewFood = 0;
        List<Integer> takenFriends = new ArrayList<>();
        while (true) {
            final int thisResult = partialCount + solve(position + 1, leftNewFood);
//            if ()

            if (friendsByDay.length == friendIndex)
                break;
        }

        return (dp[position][oldFood] = result);
    }
}
