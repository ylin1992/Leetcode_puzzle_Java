package TwoPointers;
/*
   The idea is that we keep narrowing down the searching range if s[i] == s[j].
   If s[i] != s[j], then we increase count by 1.
   And in this case we should iterate through both cases: (i++, j) and (i, j++).
 */
public class _680_ValidPalindromeIIDFS {
   public boolean validPalindrome(String s) {
      return helper(s.toCharArray(), 0, s.length() -1 , 0);
   }
   private boolean helper(char[] s, int i, int j, int count) {
      if (i >= s.length || j < 0)
         return false;

      if (i >= j) {
         return count <= 1;
      }

      if (s[i] == s[j])
         return helper(s, i + 1, j - 1, count);

      count++;
      // System.out.println(count);
      if (count > 1)
         return false;
      return helper(s, i + 1, j, count) || helper(s, i, j - 1, count);
   }
}
