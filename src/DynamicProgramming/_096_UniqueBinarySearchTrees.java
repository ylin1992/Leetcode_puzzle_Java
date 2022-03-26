package DynamicProgramming;
// When building a tree, we can pick any node as the root (says there are 5 nodes to be inserted)
// i.e., pick 3 as the root, then all nodes should be lying on right,
// the combination of the tree would be the number of combination from nodes {4,5} on the right and {1,2}
// Note that the number of possible combination {1,2} is the same as {4,5}

// Def F(i, n) = number of combination when n is the max number of the sequence with i standing at the root
// Def dp(n) = number of combination when n is the max number of the sequence
// F(i, n) = dp(i-1) * dp(n-i)
// take n = 6 as example, with i = 4 standing at the root
// the total number of combination from F(4, 6) would be
//          dp(3) * dp(2), left: {1,2,3}, right; {5,6}
// and dp(n) = sum(i from 1 to n) F(i, n)
// then we can get: dp(n) = sum(i from 1 to n) (dp(i-1) * dp(n-i))

public class _096_UniqueBinarySearchTrees {
   public int numTrees(int n) {
      int dp[] = new int[n + 1];
      dp[0] = 1;
      dp[1] = 1;

      for (int i = 2; i <= n; i++) {
         for (int j = 1; j <= i; j++) {
            dp[i] += dp[j-1] * dp[i-j];
         }
      }
      return dp[n];
   }
}
