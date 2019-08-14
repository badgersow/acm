package session7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class C {
    private static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    private static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws Exception {
        final int n = nextInt();
        final double[] angles = new double[n];
        for (int i = 0; i < n; i++) {
            int x = nextInt(), y = nextInt();
            // Fill angle 1 from [-pi/2 to 3pi/2)
            if (x == 0) {
                if (y > 0) {
                    angles[i] = 90.0;
                } else {
                    angles[i] = -90.0;
                }
            } else {
                double atan = Math.toDegrees(Math.atan((double) y / x));
                if (x < 0) {
                    angles[i] = 180.0 + atan;
                } else {
                    angles[i] = atan;
                }
            }
        }

        Arrays.sort(angles);
        double solution = angles[n - 1] - angles[0];
        for (int i = 0; i < n - 2; i++) {
            solution = Math.min(solution, 360.0 - (angles[i + 1] - angles[i]));
        }

        System.out.println(solution);
    }

    private static double[] minMax(double[] angles) {
        double min = 1000, max = -1000;
        for (double angle : angles) {
            min = Math.min(min, angle);
            max = Math.max(max, angle);
        }

        return new double[]{min, max};
    }

}
