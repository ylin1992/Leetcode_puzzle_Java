package _String;

import java.util.HashMap;

/**
 * basic idea: if there are two consecutive '+', then we flip them and recursively
 * try the result
 * For some moves that we've already examined the result, we put it into a map
 */
public class _294_CharArrayWithMemoization {
   public boolean canWin(String currentState) {
      return helper(currentState.toCharArray(), new HashMap<>());
   }

   private boolean helper(char[] s, HashMap<String, Boolean> map) {
      String cache = String.valueOf(s);
      if (map.containsKey(cache)) return map.get(cache);
      for (int i = 1; i < s.length; i++) {
         if (s[i] == '+' && s[i-1] == '+') {
            // String nextMove = s.substring(0, i-1) + "--" + s.substring(i+1);
            s[i-1] = '-';
            s[i] = '-';
            boolean rivalWin = helper(s, map);
            s[i-1] = '+';
            s[i] = '+';
            if (!rivalWin) {
               map.put(String.valueOf(s), true);
               return true;
            }
         }
      }
      return false;
   }

}
