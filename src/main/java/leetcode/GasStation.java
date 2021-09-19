package leetcode;

import java.util.stream.IntStream;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = IntStream.of(gas).sum();
        int totalCost = IntStream.of(cost).sum();

        if (totalCost > totalGas) {
            return -1;
        }

        int n = gas.length;
        int tank = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            tank = tank + gas[i] - cost[i];
            if (tank < 0) {
                tank = 0;
                start = (i + 1) % n;
            }
        }
        return start;
    }
}
