package SlidingWindow;

public class _597_PermutationInString {
   public boolean checkInclusion(String s1, String s2) {
      if (s1.length() > s2.length()) return false;
      int l1 = s1.length();
      int l2 = s2.length();

      int[] count1 = new int[26];
      int[] count2 = new int[26];
      for (char c : s1.toCharArray()) { count1[c - 'a']++ ;}
      for (int i = 0; i < l2; i++) {
         // undo left boundary
         if (i >= l1) {
            count2[s2.charAt(i-l1) - 'a']--;
         }

         // examine right boundary
         count2[s2.charAt(i) - 'a']++;

         boolean theSame = true;
         for (int k = 0; k < 26; k++) {
            if (count1[k] != count2[k]) {
               theSame = false;
               break;
            }
         }
         if (theSame) return true;
      }
      return false;
   }

}
