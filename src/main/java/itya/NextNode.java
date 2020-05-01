package itya;

public class NextNode {

    public static void connect(Node v) {

    }

    public static class Node {
        Node left, right, next = null;

        public Node() {
        }

        public Node(Node left, Node right) {
            this.left = left;
            this.right = right;
        }
    }

}
