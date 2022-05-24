package SlidingWindow;

import java.util.HashSet;

public class _003_LongestSubstringWithoutRepeatingCharacters {
   public int lengthOfLongestSubstring(String s) {
      HashSet<Character> set = new HashSet<>();
      int max = 0;
      int i = 0;
      for (int j = 0; j < s.length(); j++) {
         if (set.contains(s.charAt(j))) {
            while (s.charAt(i) != s.charAt(j)) {
               set.remove(s.charAt(i));
               i++;
            }
            i++;
         }
         // System.out.println(i + "," + j);
         set.add(s.charAt(j));
         max = Math.max(j - i + 1, max);
      }
      return max;
   }

}
