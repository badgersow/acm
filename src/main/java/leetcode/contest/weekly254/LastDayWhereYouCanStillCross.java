package leetcode.contest.weekly254;

public class LastDayWhereYouCanStillCross {

    public int latestDayToCross(int row, int col, int[][] cells) {
        this.a = new int[row][col];
        for (int i = 0; i < cells.length; i++) {
            a[cells[i][0]][cells[i][1]] = i;
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
        return false;
    }

    int[][] a;

}
