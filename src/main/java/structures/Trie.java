package structures;

import java.util.Random;

public class Trie {

    private static final Random r = new Random();

    private Trie left;

    private Trie right;

    private int weight;

    private int size;

    private int min;

    private int data;

    boolean reversed = false;

    public Trie(Trie left, Trie right, int data, int weight) {
        this.left = left;
        this.right = right;
        this.data = data;
        this.weight = weight;
        this.size = size(left) + size(right) + 1;
        this.min = Math.min(data, Math.min(min(left), min(right)));
    }

    public Trie(int data) {
        this.data = data;
        this.min = data;
        this.size = 1;
        this.weight = r.nextInt();
    }

    public Trie withLeftNode(Trie leftNode) {
        return new Trie(leftNode, right, data, weight);
    }

    public Trie withRightNode(Trie rightNode) {
        return new Trie(left, rightNode, data, weight);
    }

    public static TriePair split(Trie root, int k) {
        if (root == null) {
            return new TriePair(null, null);
        }

        root.propagateReversed();
        if (size(root.left) < k) {
            // The cutting point is somewhere inside right subtree. So we can add current node and
            // the left subtree to the left part, and recursively process right subtree
            final TriePair result = split(root.right, k - size(root.left) - 1);// -1 because of root node
            return new TriePair(
                    root.withRightNode(result.left),
                    result.right
            );
        } else {
            // Split happens somewhere in the left subtree
            final TriePair result = split(root.left, k);
            return new TriePair(
                    result.left,
                    root.withLeftNode(result.right)
            );
        }
    }

    public static Trie merge(Trie left, Trie right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        right.propagateReversed();
        left.propagateReversed();
        if (left.weight <= right.weight) { // Left becomes a root
            left.right = merge(left.right, right);
            left.size = size(left.left) + size(left.right) + 1;
            left.min = Math.min(left.data, Math.min(min(left.left), min(left.right)));
            return left;
        } else {
            right.left = merge(left, right.left);
            right.size = size(right.left) + size(right.right) + 1;
            right.min = Math.min(right.data, Math.min(min(right.left), min(right.right)));
            return right;
        }
    }

    public static int positionOf(Trie root, int value) {
        root.propagateReversed();
        if (root.data == value) {
            return size(root.left);
        }

        // Let's see if we need to go right or left
        if (min(root.right) > value) { // Definitely not right
            return positionOf(root.left, value);
        } else {
            return positionOf(root.right, value) + size(root.left) + 1;
        }
    }

    public int get(int index) {
        this.propagateReversed();
        if (index == size(left)) {
            return this.data;
        }

        if (index < size(this.left)) {
            return this.left.get(index);
        } else {
            return this.right.get(index - size(this.left) - 1);
        }
    }

    public static Trie create(Integer... contents) {
        Trie trie = null;
        for (Integer next : contents) {
            trie = merge(trie, new Trie(next));
        }
        return trie;
    }

    public static int size(Trie root) {
        if (root == null) {
            return 0;
        }
        return root.size;
    }

    private static int min(Trie root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        return root.min;
    }

    public void reverse() {
        this.reversed = !this.reversed;
    }

    public static class TriePair {
        public Trie left, right;

        public TriePair(Trie left, Trie right) {
            this.left = left;
            this.right = right;
        }
    }

    private void propagateReversed() {
        if (this.reversed) {
            Trie tmp = left;
            left = right;
            right = tmp;

            if (left != null) {
                left.reversed = !left.reversed;
            }
            if (right != null) {
                right.reversed = !right.reversed;
            }
        }
        this.reversed = false;
    }
}
