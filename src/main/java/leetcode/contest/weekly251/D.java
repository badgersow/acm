package leetcode.contest.weekly251;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class D {

    Map<String, List<Node>> nodeByPreorder = new HashMap<>();

    Set<Node> duplicates = new HashSet<>();

    String separator = "/";

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Node root = new Node("");

        for (int i = 0; i < paths.size(); i++) {
            Node current = root;
            for (int j = 0; j < paths.get(i).size(); j++) {
                final String name = paths.get(i).get(j);
                if (!current.children.containsKey(name)) {
                    // Create the directory
                    final Node node = new Node(name);
                    current.children.put(name, node);
                }
                current = current.children.get(name);
            }
        }

        // Now we have the tree
        // Let's create a map "inorder of children -> Node"
        for (Node firstLevelChild : root.children.values()) {
            dfsFillMap(firstLevelChild);
        }


        // Now let's mark duplicated things
        for (String preorder : nodeByPreorder.keySet()) {
            final List<Node> nodes = nodeByPreorder.get(preorder);
            if (nodes.size() >= 2) {
                // There are duplicates
                duplicates.addAll(nodes);
            }
        }

        // Now let's generate the output by traversing the tree and skipping duplicates
        List<List<String>> result = new ArrayList<>();
        List<String> currentPath = new ArrayList<>();

        for (Node firstLevelChild : root.children.values()) {
            fillResult(firstLevelChild, result, currentPath);
        }

        return result;
    }

    private void fillResult(Node node, List<List<String>> result, List<String> currentPath) {
        if (duplicates.contains(node)) {
            // Do nothing. This is deleted
            return;
        }

        currentPath.add(node.data);
        result.add(new ArrayList<>(currentPath));
        for (Node child : node.children.values()) {
            fillResult(child, result, currentPath);
        }
        currentPath.remove(currentPath.size() - 1);
    }

    private void dfsFillMap(Node node) {
        if (node.children.isEmpty()) {
            // If the children is empty, nothing to do here
            node.subtreePreorder = "";
            return;
        }
        StringBuilder subtreePreorder = new StringBuilder();
        for (Node child : node.children.values()) {
            dfsFillMap(child);
            subtreePreorder.append(separator).append(child.data).append(separator).append(child.subtreePreorder);
        }
        node.subtreePreorder = subtreePreorder.toString();

        if (!nodeByPreorder.containsKey(node.subtreePreorder)) {
            nodeByPreorder.put(node.subtreePreorder, new ArrayList<>());
        }

        nodeByPreorder.get(node.subtreePreorder).add(node);
    }

    private static class Node {
        String data;
        Map<String, Node> children = new TreeMap<>();
        String subtreePreorder;

        public Node(String data) {
            this.data = data;
        }
    }
}


