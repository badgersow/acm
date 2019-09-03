package ipsc2000;

import com.google.common.base.Preconditions;
import org.checkerframework.framework.qual.PreconditionAnnotation;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

import static java.lang.Math.abs;

public class B {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int n = in.nextInt();
        final Set<Line> lines = new HashSet<>();

        long result = 1;
        for (int i = 0; i < n; i++) {
            final Line current = new Line(
                    new Point(in.nextLong(), in.nextLong()),
                    new Point(in.nextLong(), in.nextLong()));

            if (lines.contains(current))
                continue;

            Set<PointF> intersections = new HashSet<>();
            for (Line previous : lines) {
                if (current.isParallel(previous))
                    continue;

                intersections.add(current.intersection(previous));
            }

            result += intersections.size() + 1;
            lines.add(current);
        }

        System.out.println(result);
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    static class Line {

        final long a, b, c;

        public Line(Point first, Point second) {
            final long a = second.y - first.y;
            final long b = first.x - second.x;
            final long c = first.x * (second.y - first.y) +
                    first.y * (first.x - second.x);

            final long g = gcd(abs(a), gcd(abs(b), abs(c)));
            if (a >= 0) {
                this.a = a / g;
                this.b = b / g;
                this.c = c / g;
            } else {
                this.a = -a / g;
                this.b = -b / g;
                this.c = -c / g;
            }
        }

        public boolean isParallel(Line other) {
            return det(a, b, other.a, other.b) == 0;
        }

        public PointF intersection(Line other) {
            long delta = det(a, b, other.a, other.b);
            long deltaX = det(c, b, other.c, other.b);
            long deltaY = det(c, b, other.c, other.b);

            return new PointF(
                    new Fraction(deltaX, delta),
                    new Fraction(deltaY, delta));
        }

        public long det(long a1, long a2, long b1, long b2) {
            return a1 * b2 - a2 * b1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Line line = (Line) o;
            return a == line.a &&
                    b == line.b &&
                    c == line.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }
    }

    static class Point {
        final long x;
        final long y;

        Point(long x, long y) {
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

    static class PointF {
        final Fraction x;
        final Fraction y;

        public PointF(Fraction x, Fraction y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PointF pointF = (PointF) o;
            return x.equals(pointF.x) &&
                    y.equals(pointF.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class Fraction {

        final long numerator;
        final long denominator;

        public Fraction(int n) {
            this(n, 1L);
        }

        public Fraction(long numerator, long denominator) {
            Preconditions.checkArgument(denominator != 0);

            final long gcd = gcd(abs(numerator), abs(denominator));
            if (denominator > 0) {
                this.numerator = numerator / gcd;
                this.denominator = denominator / gcd;
            } else {
                this.numerator = -numerator / gcd;
                this.denominator = -denominator / gcd;
            }
        }

        public Fraction plus(Fraction other) {
            return new Fraction(numerator * other.denominator + other.numerator * denominator,
                    denominator * other.denominator);
        }

        public Fraction minus(Fraction other) {
            return new Fraction(numerator * other.denominator - other.numerator * denominator,
                    denominator * other.denominator);
        }

        public Fraction mul(Fraction other) {
            return new Fraction(numerator * other.numerator,
                    denominator * other.denominator);
        }

        public Fraction div(Fraction other) {
            return new Fraction(numerator * other.denominator,
                    denominator * other.numerator);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Fraction fraction = (Fraction) o;
            return numerator == fraction.numerator &&
                    denominator == fraction.denominator;
        }

        @Override
        public int hashCode() {
            return Objects.hash(numerator, denominator);
        }
    }

}
