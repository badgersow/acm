import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinWeights {

    public static void main(String[] args) {
        // 0 .... 2^20 -> k bits, k weights
        // 0 .... 3^k  -> 0 (-1) 1(0) 2(+1)

        // Iterate weights
        int[] minNumberOfWeights = new int[500];
        Arrays.fill(minNumberOfWeights, Integer.MAX_VALUE);
        final int weightBits = 17;
        int iterations = 0;
        for (int weightsMask = 0; weightsMask < 1 << weightBits; weightsMask++) {
            final List<Integer> weights = new ArrayList<>();
            for (int i = 0; i < weightBits; i++) {
                if ((weightsMask & (1 << i)) != 0) {
                    weights.add(i + 1);
                }
            }
            final int k = weights.size();

            boolean[] coveredNumbers = new boolean[300];
            for (int coefficientMask = 0; coefficientMask < power(3, k); coefficientMask++) {
                int coefficientMaskCopy = coefficientMask;
                int weightIndex = 0;
                int sum = 0;
                for (int i = 0; i < k; i++) {
                    int sign = coefficientMaskCopy % 3;
                    if (sign == 0) {
                        sum += weights.get(i);
                    } else if (sign == 2) {
                        sum -= weights.get(i);
                    }
                    coefficientMaskCopy /= 3;
                }
                coveredNumbers[Math.abs(sum)] = true;
            }

            int coveredRange = 0;
            for (int i = 1; i < coveredNumbers.length; i++) {
                if (coveredNumbers[i]) {
                    coveredRange++;
                } else {
                    break;
                }
            }

            minNumberOfWeights[coveredRange] = Math.min(minNumberOfWeights[coveredRange], k);
            iterations++;
            if (iterations % 100 == 0) {
                System.out.println("Iteration " + iterations + " of " + (1 << weightBits));
            }
        }

        for (int i = 1; i <= 20; i++) {
            System.out.println(i + ": " + minNumberOfWeights[i]);
        }

    }

    static int power(int a, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= a;
        }
        return result;
    }

}
