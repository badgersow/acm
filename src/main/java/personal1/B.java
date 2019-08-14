package personal1;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class B {

    private static final Factorisation[] precalculatedNumbers = new Factorisation[1001];

    private static final Factorisation[] precalculatedFactorials = new Factorisation[1001];

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final PrintWriter out = new PrintWriter(System.out);

        precalcNumbers();

        int T = in.nextInt();
        while (T-- > 0) {
            final int n = in.nextInt();
            System.out.println(solve(n));
        }

        out.flush();
    }

    private static void precalcNumbers() {
        boolean[] isPrime = new boolean[1001];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= 1000; i++) {
            if (isPrime[i]) {
                precalculatedNumbers[i] = new Factorisation(Collections.singletonList(new int[]{i, 1}));
                for (int j = i * 2; j <= 1000; j += i) {
                    isPrime[j] = false;
                    int power = 0;
                    int n = j;
                    while (n % i == 0) {
                        power++;
                        n /= i;
                    }
                    if (precalculatedNumbers[j] == null) {
                        precalculatedNumbers[j] = new Factorisation(new ArrayList<>());
                    }
                    precalculatedNumbers[j].multiples.add(new int[]{i, power});
                }
            }
        }
    }

    private static String solve(int n) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            final Factorisation factorisation = C(n, i);

            if (builder.length() > 0) {
                builder.append("+");
            }

            if (factorisation.multiples.size() > 0 || n == 0) {
                builder.append(factorisation.print());
            }


            if (n - i > 0) {
                if (factorisation.multiples.size() > 0 || n == 0) {
                    builder.append("x");
                }
                builder.append("A");
            }
            if (n - i > 1) {
                builder.append("^").append(n - i);
            }

            if (i > 0) {
                builder.append("B");
            }
            if (i > 1) {
                builder.append("^").append(i);
            }
        }

        return builder.toString();
    }

    private static Factorisation C(int n, int k) {
        return factorizeFactorial(n).divide(factorizeFactorial(k)).divide(factorizeFactorial(n - k));
    }

    private static Factorisation factorizeFactorial(int n) {
        if (precalculatedFactorials[n] != null) {
            return precalculatedFactorials[n];
        }
        return precalculatedFactorials[n] = computeFactorizationOfFactorial(n);
    }

    private static Factorisation computeFactorizationOfFactorial(int n) {
        if (n <= 1) {
            return new Factorisation(Collections.emptyList());
        }

        return factorizeFactorial(n - 1).multiply(factorizeNumber(n));
    }

    private static Factorisation factorizeNumber(int n) {
        return precalculatedNumbers[n];
    }

    private static class Factorisation {
        final List<int[]> multiples;

        String printed = null;

        Factorisation(List<int[]> multiples) {
            this.multiples = multiples;
        }

        Factorisation multiply(Factorisation other) {
            final List<int[]> result = new ArrayList<>(multiples);
            for (int[] otherMultiplicant : other.multiples) {
                boolean foundMultiplicant = false;
                for (int i = 0; i < result.size(); i++) {
                    final int[] current = result.get(i);
                    if (current[0] == otherMultiplicant[0]) {
                        result.set(i, new int[]{current[0], current[1] + otherMultiplicant[1]});
                        foundMultiplicant = true;
                        break;
                    }
                }

                if (!foundMultiplicant) {
                    result.add(otherMultiplicant);
                }
            }

            return new Factorisation(result);
        }

        Factorisation divide(Factorisation other) {
            final List<int[]> result = new ArrayList<>(multiples);
            for (int[] otherMultiplicant : other.multiples) {
                for (int i = 0; i < result.size(); i++) {
                    final int[] current = result.get(i);
                    if (current[0] == otherMultiplicant[0]) {
                        result.set(i, new int[]{current[0], current[1] - otherMultiplicant[1]});
                        break;
                    }
                }
            }

            return new Factorisation(result.stream().filter(a -> a[1] > 0).collect(Collectors.toList()));
        }

        String print() {
            if (printed != null) {
                return printed;
            }

            return printed = doPrint();
        }

        private String doPrint() {
            if (multiples.isEmpty()) {
                return "1";
            }

            multiples.sort(Comparator.comparingInt(a -> a[0]));
            final StringBuilder builder = new StringBuilder();

            multiples.forEach(pair -> {
                final int base = pair[0], power = pair[1];
                if (builder.length() > 0) {
                    builder.append("x");
                }
                builder.append(base);
                if (power > 1) {
                    builder.append("^").append(power);
                }
            });

            return builder.toString();
        }


    }
}
