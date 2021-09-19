package leetcode.contest.weekly259;

import java.util.HashMap;
import java.util.Map;

public class DetectSquares {

    private final Map<Point, Integer> countByPoint = new HashMap<>();

    public DetectSquares() {
    }

    public void add(int[] point) {
        countByPoint.compute(new Point(point[0], point[1]), (k, v) -> v == null ? 1 : v + 1);
    }

    public int count(int[] pointArray) {
        Point point = new Point(pointArray[0], pointArray[1]);
        int count = 0;
        for (Map.Entry<Point, Integer> diagonalEntry : countByPoint.entrySet()) {
            Point diagonal = diagonalEntry.getKey();
            int diagonalCount = diagonalEntry.getValue();

            if (diagonal.x == point.x || diagonal.y == point.y) {
                // The area will be zero
                continue;
            }

            if (Math.abs(diagonal.x - point.x) != Math.abs(diagonal.y - point.y)) {
                // This is a rectangle and not a square
                continue;
            }

            Point point2 = new Point(point.x, diagonal.y);
            Point point3 = new Point(diagonal.x, point.y);
            count += diagonalCount *
                    countByPoint.getOrDefault(point2, 0) *
                    countByPoint.getOrDefault(point3, 0);
        }
        return count;
    }

    private static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

}
