package session3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final long a = in.nextLong(), b = in.nextLong();
        int k = in.nextInt();

        final Map<List<Integer>, List<Long>> states = new HashMap<>();

        long steps = 0;
        long currentA = a;

        long cycleSteps = -1, cycleDiff = -1;
        while (true) {
            List<Integer> currentState = state(currentA, k);

            if (states.containsKey(currentState)) {
                // cycle is found!

                final List<Long> value = states.get(currentState);
                cycleSteps = steps - value.get(1);
                cycleDiff = value.get(0) - currentA;
                break;
            }

            states.put(currentState, Arrays.asList(currentA, steps));

            int mostOptimalSubtraction = currentState.stream().mapToInt(Integer::intValue).max().orElse(1);
            if (mostOptimalSubtraction == 0) {
                mostOptimalSubtraction = 1;
            }
            steps++;
            currentA -= mostOptimalSubtraction;
        }

        System.out.println(cycleSteps + " " + cycleDiff);

    }

    private static List<Integer> state(long a, int k) {
        List<Integer> state = new ArrayList<>();
        for (int i = 2; i <= k; i++) {
            state.add((int) (a % i));
        }
        return state;
    }
}
