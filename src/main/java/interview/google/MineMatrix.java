package interview.google;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MineMatrix {

    public final int[][] matrix;

    // Magic value to represent a mine in the matrix
    private static final int MINE = 9;

    public MineMatrix(int rows, int cols, int mines) {
        // Fail early
        Preconditions.checkState(rows > 0 && cols > 0 && mines >= 0 && mines <= rows * cols);
        matrix = generateMatrix(rows, cols, mines);
    }

    private static int[][] generateMatrix(int rows, int cols, int mines) {
        int[][] matrix = new int[rows][cols];
        List<Point> minePositions = arrangeMines(rows, cols, mines);

        for (Point mine: minePositions) {
            matrix[mine.row][mine.col] = MINE;
        }

        // Now we are filling the rest of the array with the number of adjacent mines
        List<Point> neighbourDiffs = Arrays.asList(
                new Point(-1,-1), new Point(-1,0), new Point(-1,1),
                new Point(0,-1), new Point(0,1),
                new Point(1,-1), new Point(1,0), new Point(1,1));

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == MINE) {
                    // MINE value is already set
                    continue;
                }

                for (Point diff : neighbourDiffs) {
                    Point neighbour = new Point(row + diff.row, col + diff.col);
                    if (neighbour.row < 0 || neighbour.row >= rows || neighbour.col < 0 || neighbour.col >= cols) {
                        // This is the empty square out of border
                        continue;
                    }

                    if (matrix[neighbour.row][neighbour.col] == MINE) {
                        matrix[row][col]++;
                    }
                }
            }
        }

        return matrix;
    }

    // This works in O(MN) time and O(MN) additional memory
    public static List<Point> arrangeMines(int rows, int cols, int mines) {
        List<Point> allPoints = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                allPoints.add(new Point(row, col));
            }
        }

        Collections.shuffle(allPoints);
        // Return the first ‘mines’ elements
        return allPoints.subList(0, mines);
    }


    public int get(int row, int col) {
        return matrix[row][col];
    }

    private static class Point {
        public final int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
