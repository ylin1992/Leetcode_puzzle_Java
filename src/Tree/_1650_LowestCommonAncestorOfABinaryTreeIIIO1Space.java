package Tree;
/*
   If p and q are at the same level, then it is guaranteed that
   if we keep moving both p->p.parent and q->q.parent, then we will eventually find the LCA.

   If p and q are at different levels, then we should move the lower one to the higher level
   and continue doing the previous step.

   Space: O(1)
   Time: O(n)
 */
public class _1650_LowestCommonAncestorOfABinaryTreeIIIO1Space {
   class Node {
      public int val;
      public _1650_LowestCommonAncestorOfABinaryTreeIII.Node left;
      public _1650_LowestCommonAncestorOfABinaryTreeIII.Node right;
      public Node parent;
   };
   public Node lowestCommonAncestor(Node p, Node q) {
      int hP = getHeight(p);
      int hQ = getHeight(q);

      if (hP > hQ) {
         // swim up hP
         while (hP > hQ) {
            p = p.parent;
            hP--;
         }
      }

      if (hP < hQ) {
         while (hQ > hP) {
            q = q.parent;
            hQ--;
         }
      }

      while (p != q) {
         p = p.parent;
         q = q.parent;
      }
      return p;
   }

   private int getHeight(Node node) {
      if (node == null)
         return -1;
      int h = 0;
      while (node != null) {
         h++;
         node = node.parent;
      }
      return h;
   }
}
