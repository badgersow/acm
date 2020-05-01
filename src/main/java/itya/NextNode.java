package itya;

public class NextNode {

    public static void connect(Node v) {
        assign(v, null);
    }

    static void assign(Node v, Node parent) {
        if (v.next != null) {
            return;
        }

        Node parentOfNext = null;
        if (parent == null) {
            v.next = null;
            parentOfNext = null;
        } else {
            if (parent.left == v && parent.right != null) {
                v.next = parent.right;
                parentOfNext = parent;
            } else {
                Node nextParent = parent.next;
                while (nextParent != null) {
                    Node u = leftmost(nextParent);
                    if (u != null) {
                        v.next = u;
                        parentOfNext = nextParent;
                        break;
                    }
                    nextParent = nextParent.next;
                }
            }
        }

        if (v.next != null) {
            assign(v.next, parentOfNext);
        }
        if (v.left != null) {
            assign(v.left, v);
        }
        if (v.right != null) {
            assign(v.right, v);
        }
    }

    static Node leftmost(Node v) {
        if (v.left != null) {
            return v.left;
        }
        return v.right;
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
