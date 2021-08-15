package leetcode.contest.weekly254;

import java.util.Arrays;

public class LastDayWhereYouCanStillCross {

    public int latestDayToCross(int row, int col, int[][] cells) {
        this.a = new int[row][col];
        this.visited = new boolean[row][col];
        this.I = row;
        this.J = col;
        for (int i = 0; i < cells.length; i++) {
            a[cells[i][0] - 1][cells[i][1] - 1] = i;
        }

        // Let's start the binary search
        int l = 0; // Can definitely cross
        int r = row * col; // Can't cross, everything is water
        while (l + 1 < r) {
            int w = (l + r) / 2;
            if (canCross(w)) {
                l = w;
            } else {
                r = w;
            }
        }

        return l;
    }

    private boolean canCross(int day) {
        for (boolean[] layer : visited) {
            Arrays.fill(layer, false);
        }

        for (int j = 0; j < J; j++) {
            if (a[0][j] >= day && canReachBottom(0, j, day)) {
                return true;
            }
        }

        return false;
    }

    private boolean canReachBottom(int i, int j, int day) {
        if (i == I - 1) {
            // This is the last row
            return true;
        }
        visited[i][j] = true;

        for (int[] diff : d) {
            int newI = i + diff[0];
            int newJ = j + diff[1];

            if (newI < 0 || newI >= I || newJ < 0 || newJ >= J) {
                continue;
            }

            if (visited[newI][newJ] || a[newI][newJ] < day) {
                continue;
            }

            if (canReachBottom(newI, newJ, day)) {
                return true;
            }
        }

        return false;
    }

    int[][] a;

    boolean[][] visited;

    int I, J;

    int[][] d = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
}
