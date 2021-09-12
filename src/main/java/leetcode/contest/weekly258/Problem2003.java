package leetcode.contest.weekly258;

import java.util.ArrayList;
import java.util.List;

public class Problem2003 {

    // Starting at 2:24:13 pm

    int subtreeIndex = 0;

    int[] nodeIndex = new int[100_001];

    int[] subtreeSizes = new int[100_001];

    int[] nodeValues = new int[100_001];

    int[] values;

    List<Integer>[] children = new List[100_001];

    public int[] smallestMissingValueSubtree(int[] parents, int[] values) {
        boolean[] present = new boolean[100_001];
        for (int i = 0; i < values.length; i++) {
            present[values[i]] = true;
        }
        int mex = -1;
        for (int i = 1; i < present.length; i++) {
            if (!present[i]) {
                mex = i;
                break;
            }
        }

        int n = parents.length;
        this.values = values;
        for (int i = 0; i < children.length; i++) {
            children[i] = new ArrayList<>();
        }

        // parents[0] is not interesing, it's the root
        for (int i = 1; i < parents.length; i++) {
            int child = i;
            int parent = parents[i];
            children[parent].add(child);
        }

        // Now we traverse the tree and fill SubtreeSize and SubtreeValue
        inorder(0);

        // Now for each node we need to find the minimum in 2 subranges. One from the
        // left, and one from the right;

        // minPrefix[i] - minimum of the nodeValues on [0,i]
        int[] minPrefix = new int[n];
        minPrefix[0] = nodeValues[0];
        for (int i = 1; i < n; i++) {
            minPrefix[i] = Math.min(minPrefix[i - 1], nodeValues[i]);
        }

        // minSuffix[i] - minimum of the nodeValues on [i..n)
        int[] minSuffix = new int[n];
        minSuffix[n - 1] = nodeValues[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minSuffix[i] = Math.min(minSuffix[i + 1], nodeValues[i]);
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            // Result of the node n is the minimum [0, nodeIndex[i])
            // And [nodeIndex[i] + subtreeSize[i], n)
            int index = nodeIndex[i];
            result[i] = Math.min(
                    i == 0 ? mex : minPrefix[index - 1],
                    index + subtreeSizes[i] == n ? mex : minSuffix[index + subtreeSizes[i]]
            );
            result[i] = Math.min(result[i], mex);
        }

        return result;
    }

    // Returns subtree size
    private int inorder(int node) {
        // OK, this is inorder.
        // I save the information about this node, and then I call the children

        int indexInTheArray = subtreeIndex++;
        nodeIndex[node] = indexInTheArray;

        nodeValues[indexInTheArray] = values[node];
        int subtreeSize = 1;
        for (Integer child : children[node]) {
            subtreeSize += inorder(child);
        }

        return (subtreeSizes[node] = subtreeSize);
    }
}
