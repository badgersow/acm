package ipsc2001;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D {

    private static int n;
    private static List<Integer>[] children;
    private static int[] a;
    private static int[][][] solveDP;
    private static int[][][][] composeDP;
    private static int[] count;

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        n = in.nextInt();
        children = new List[n + 1];
        a = new int[n + 1];

        for (int i = 0; i < children.length; i++) {
            children[i] = new ArrayList<>();
        }

        int root = -1;

        for (int i = 1; i <= n; i++) {
            int parent = in.nextInt(), weight = in.nextInt();
            a[i] = weight;

            if (parent == 0 && weight == 0) {
                root = i;
                continue;
            }

            children[parent].add(i);
        }

        solveDP = new int[n + 1][n / 2 + 1][];
        for (int i = 0; i < solveDP.length; i++) {
            for (int j = 0; j < solveDP[i].length; j++) {
                solveDP[i][j] = new int[]{-1, -1, -1};
            }
        }

        composeDP = new int[n + 1][25][n / 2 + 1][]; // 25 is the maximum degree of the node from problem input
        for (int i = 0; i < composeDP.length; i++) {
            for (int j = 0; j < composeDP[i].length; j++) {
                for (int k = 0; k < composeDP[i][j].length; k++) {
                    composeDP[i][j][k] = new int[]{-1, -1, -1};
                }
            }
        }

        count = new int[n + 1];
        calculateCount(root);

        System.out.println(solve(root, n / 2, 0));
    }

    private static int calculateCount(int root) {
        return count[root] = 1 +
                children[root].stream().mapToInt(D::calculateCount).sum();
    }

    private static int solve(int root, int firstMembers, int parentColor) {
        // Color the leaf
        if (children[root].isEmpty()) {
            if (firstMembers > 1) {
                return Integer.MIN_VALUE / 2; // Impossible
            }

            // If the leaf employee is happy
            if (firstMembers == 1 && parentColor == 2 || firstMembers == 0 && parentColor == 1) {
                return a[root];
            }

            // Leaf employee has the same color as the boss
            return 0;
        }

        // If we already have the solution
        if (solveDP[root][firstMembers][parentColor] != -1) {
            return solveDP[root][firstMembers][parentColor];
        }

        int bestSolution = Integer.MIN_VALUE / 2;

        // Color the current node to 1 if this is possible
        if (firstMembers > 0) {
            bestSolution =
                    Math.max(bestSolution,
                            (parentColor == 2 ? a[root] : 0) +
                                    compose(root, 0, firstMembers - 1, 1));
        }

        // Color the current node to 2
        bestSolution =
                Math.max(bestSolution,
                        (parentColor == 1 ? a[root] : 0) +
                                compose(root, 0, firstMembers, 2));

        return solveDP[root][firstMembers][parentColor] = bestSolution;
    }

    // Implement weak k-composition of the current node into subtrees
    private static int compose(int root, int position, int sum, int parentColor) {
        if (position == children[root].size()) {
            if (sum == 0) {
                // Successful!
                return 0;
            }

            // Failed. We should return -infinity
            return Integer.MIN_VALUE / 2;
        }

        if (composeDP[root][position][sum][parentColor] != -1) {
            return composeDP[root][position][sum][parentColor];
        }

        int bestSolution = Integer.MIN_VALUE;
        final int child = children[root].get(position);
        for (int firstMembers = 0; firstMembers <= Math.min(sum, count[child]); firstMembers++) {
            bestSolution = Math.max(bestSolution,
                    solve(child, firstMembers, parentColor) + // current child node
                            compose(root, position + 1, sum - firstMembers, parentColor)); // rest of children
        }

        return composeDP[root][position][sum][parentColor] = bestSolution;
    }
}
