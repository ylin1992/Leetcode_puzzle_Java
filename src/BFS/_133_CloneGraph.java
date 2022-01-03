package BFS;
import java.util.*;
public class _133_CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return helper(node, new HashMap<Node, Node>());
    }

    private Node helper(Node node, HashMap<Node, Node> map) {
        if (map.containsKey(node))
            return map.get(node);

        Node clone = new Node(node.val);
        map.put(node, clone);
        for (Node n : node.neighbors) {
            clone.neighbors.add(helper(n, map));
        }
        return clone;
    }

}
