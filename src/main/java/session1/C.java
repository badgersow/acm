package session1;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(in.nextLine());

        final HashMap<Point, Integer> points = new HashMap<>();
        for (int i = 0; i < n; i++) {
            final String[] line = in.nextLine().split(" ");
            final int x = Integer.parseInt(line[1]);
            final int y = Integer.parseInt(line[2]);
            final int r = Integer.parseInt(line[3]);
            final Point p = new Point(x, y);
            if (line[0].equals("A")) {
                // add
                boolean fit = true;
                for (Map.Entry<Point, Integer> another : points.entrySet()) {
                    if (!fit(another, x, y, r)) {
                        fit = false;
                        break;
                    }
                }

                if (!fit) {
                    out.println("No");
                    continue;
                }

                points.put(p, r);
                out.println("Ok");
            } else {
                // remove
                if (points.containsKey(p) && points.get(p) == r) {
                    points.remove(p);
                    out.println("Ok");
                } else {
                    out.println("No");
                }
            }
        }

        out.flush();
    }

    private static boolean fit(Map.Entry<Point, Integer> another, int x, int y, int r) {
        final Point point = another.getKey();
        final long dist2 = (point.x - x) * (point.x - x) + (point.y - y) * (point.y - y);
        return dist2 >= (another.getValue() + r) * (another.getValue() + r);
    }

    private static class Point {
        final int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
