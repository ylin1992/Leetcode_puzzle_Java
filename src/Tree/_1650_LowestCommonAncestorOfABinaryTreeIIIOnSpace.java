package Tree;

import java.util.HashSet;

public class _1650_LowestCommonAncestorOfABinaryTreeIIIOnSpace {
   class Node {
      public int val;
      public _1650_LowestCommonAncestorOfABinaryTreeIII.Node left;
      public _1650_LowestCommonAncestorOfABinaryTreeIII.Node right;
      public Node parent;
   };
   public Node lowestCommonAncestor(Node p, Node q) {
      HashSet<Node> visited = new HashSet<>();
      Node runningP = p;
      while (runningP != null) {
         visited.add(runningP);
         runningP = runningP.parent;
      }

      Node runningQ = q;
      while (runningQ != null) {
         if (visited.contains(runningQ))
            return runningQ;
         runningQ = runningQ.parent;
      }
      return null;
   }
}
