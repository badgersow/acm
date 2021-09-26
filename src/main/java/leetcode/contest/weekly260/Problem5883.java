package leetcode.contest.weekly260;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem5883 {
    public boolean placeWordInCrossword(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] lookDown = new boolean[n][m];
        boolean[][] lookRight = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(lookDown[i], true);
            Arrays.fill(lookRight[i], true);
        }

        Node root = new Node();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // First, look right. Then look down.
                if (board[i][j] != '#' && lookRight[i][j]) {
                    look(i, j, 0, 1, n, m, board, root, lookRight);
                }
                if (board[i][j] != '#' && lookDown[i][j]) {
                    look(i, j, 1, 0, n, m, board, root, lookDown);
                }
            }
        }

        // Now let's match the word in trie
        return match(0, root, word.toCharArray()) ||
                match(0, root, new StringBuffer(word).reverse().toString().toCharArray());
    }

    private boolean match(int index, Node node, char[] ch) {
        if (index == ch.length) {
            return node.children.containsKey('$');
        }

        if (node.children.containsKey(ch[index]) && match(index + 1, node.children.get(ch[index]), ch)) {
            return true;
        }

        if (node.children.containsKey(' ') && match(index + 1, node.children.get(' '), ch)) {
            return true;
        }

        return false;
    }

    private void look(int startI, int startJ, int di, int dj, int n, int m, char[][] board, Node root, boolean[][] look) {
        int i = startI, j = startJ;
        Node node = root;
        while (i < n && j < m && board[i][j] != '#') {
            char c = board[i][j];
            look[i][j] = false;

            if (!node.children.containsKey(c)) {
                node.children.put(c, new Node());
            }
            node = node.children.get(c);

            i += di;
            j += dj;
        }

        node.children.computeIfAbsent('$', c -> new Node());
    }

    private static class Node {
        Map<Character, Node> children = new HashMap<>();

        @Override
        public String toString() {
            return "Node{" + children + "}";
        }
    }
}
