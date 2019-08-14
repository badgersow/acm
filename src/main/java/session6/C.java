package session6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();

        final int[] a = new int[n];
        final Map<Integer, Integer> firstPosition = new HashMap<>();

        final Map<Integer, Integer> counts = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            firstPosition.putIfAbsent(x, i);
            a[i] = firstPosition.get(x);

            counts.compute(x, (k, v) -> (v == null ? 0 : v) + 1);
        }

        int result = counts.values().stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);

        final int[] totalSegments = new int[n];
        final boolean[] segmentMask = new boolean[n];
        final boolean[] startChecked = new boolean[n];

        Arrays.fill(segmentMask, false);
        for (int firstIndex = 0; firstIndex < n; firstIndex++) {
            final int firstNum = a[firstIndex];
            if (startChecked[firstNum]) {
                continue;
            }

            startChecked[firstNum] = true;

            Arrays.fill(totalSegments, 0);

            final List<Integer> segmentEnds = new ArrayList<>();
            for (int j = firstIndex + 1; j < n; j++) {
                if (a[j] == firstNum) {
                    segmentEnds.add(j);
                }
            }
            segmentEnds.add(n);

            int segmentStart = firstIndex + 1;
            for (Integer segmentEnd : segmentEnds) {
                Arrays.fill(segmentMask, false);
                for (int pos = segmentStart; pos < segmentEnd; pos++) {
                    if (!segmentMask[a[pos]]) {
                        segmentMask[a[pos]] = true;
                        totalSegments[a[pos]]++;
                    }
                }

                segmentStart = segmentEnd + 1;
            }

            for (int i = 0; i < totalSegments.length; i++) {
                final int thisResult = totalSegments[i] * 2 + (!segmentMask[i] ? 1 : 0);
                result = Math.max(thisResult, result);
            }
        }

        System.out.println(result);
    }
}
