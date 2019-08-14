package session8;

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
        final int m = nextInt();
        int bestBonus = nextInt();
        for (int i = 0; i < m - 1; i++) {
            bestBonus = Math.min(bestBonus, nextInt());
        }

        final int n = nextInt();
        final int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }

        Arrays.sort(a);
        int index = a.length - 1;
        int result = 0;
        while (true) {
            // Check if we can use promotion
            if (index + 1 >= bestBonus) {
                // Use promotion
                for (int j = index; j > index - bestBonus; j--) {
                    result += a[j];
                }
                index -= bestBonus;
                index -= 2;
                if (index < 0) {
                    break;
                }
            } else {
                // Buy all items without promotion
                for (int j = 0; j <= index; j++) {
                    result += a[j];
                }
                break;
            }
        }

        System.out.println(result);
    }

}
