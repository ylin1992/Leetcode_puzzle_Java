package Tree;

import java.util.HashSet;

public class _1650_LowestCommonAncestorOfABinaryTreeIII {
   class Node {
      public int val;
      public Node left;
      public Node right;
      public Node parent;
   };

   public Node lowestCommonAncestor(Node p, Node q) {
      Node retP = dfs(p, q);
      // p is the LCA
      if (retP != null)
         return p;

      // q is the LCA
      Node retQ = dfs(q, p);
      if (retQ != null)
         return q;

      // LCA is the common ancestor of p and q
      HashSet<Node> set = new HashSet<>();
      traceUpP(p, set);
      return traceUpQ(q, set);
   }

   /*
       to check if one of the node is beneath the another one
       if n2 is benath n1, then return n2, otherwise return null
       precondition: n2 should not be null
   */
   private Node dfs(Node n1, Node n2) {
      if (n1 == null)
         return null;
      if (n1.val == n2.val)
         return n1;

      Node retL = dfs(n1.left, n2);
      Node retR = dfs(n1.right, n2);
      if (retL == null && retR == null)
         return null;

      // it is impossible to have both l and r return non-null Node
      return retL == null ? retR : retL;
   }

   /*
       return p or q if p.val == q.val
   */
   private void traceUpP(Node p, HashSet<Node> set) {
      if (p == null)
         return;
      set.add(p);
      traceUpP(p.parent, set);
   }

   private Node traceUpQ(Node q, HashSet<Node> set) {
      if (q == null)
         return null;
      if (set.contains(q))
         return q;
      Node ret = traceUpQ(q.parent, set);
      return ret;
   }

}
