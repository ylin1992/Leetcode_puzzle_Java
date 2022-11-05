package TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class _1023_CamelCaseMatching {
   public List<Boolean> camelMatch(String[] queries, String pattern) {
      List<Boolean> res = new ArrayList<>();
      for (String query : queries) {
         res.add(match(query, pattern));
      }
      return res;
   }

   private boolean match(String str, String pattern) {
      int i = 0;
      int j = 0;
      while (i < str.length() && j < pattern.length()) {
         if (str.charAt(i) == pattern.charAt(j)) {
            i++;
            j++;
         } else {
            while (i < str.length() && j < pattern.length() && str.charAt(i) != pattern.charAt(j)) {
               if (Character.isUpperCase(str.charAt(i))) {
                  return false;
               }
               i++;
               // if (Character.isUpperCase(str.charAt(i)) && j == pattern.length() - 1)
               //     return false;
            }
         }
      }
      // System.out.println(i + ", " + j);
      while (i < str.length()) {
         if (Character.isUpperCase(str.charAt(i)))
            return false;
         i++;
      }
      return j == pattern.length();
   }

}
