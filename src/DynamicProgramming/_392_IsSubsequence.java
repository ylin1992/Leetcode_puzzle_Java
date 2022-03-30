package DynamicProgramming;

public class _392_IsSubsequence {
   // two pointer solution O(n)
   public boolean isSubsequence(String s, String t) {
      int ns = s.length();
      int nt = t.length();
      int ps = 0;
      int pt = 0;
      while (ps < s.length() && pt < t.length()) {
         if (s.charAt(ps) == t.charAt(pt)) {
            ps++;
            pt++;
         } else {
            pt++;
         }
      }

      return ps == ns;
   }

   /*
    Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109,
    and you want to check one by one to see if t has its subsequence.
    In this scenario, how would you change your code?
    */
}
