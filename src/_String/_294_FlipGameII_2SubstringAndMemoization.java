package _String;

import java.util.HashMap;

public class _294_FlipGameII_2SubstringAndMemoization {
   public boolean canWin(String currentState) {
      return helper(currentState, new HashMap<>());
   }

   private boolean helper(String s, HashMap<String, Boolean> map) {
      // System.out.println(s);
      if (map.containsKey(s)) return map.get(s);
      for (int i = 1; i < s.length(); i++) {
         if (s.charAt(i) == '+' && s.charAt(i-1) == '+') {
            String nextMove = s.substring(0, i-1) + "--" + s.substring(i+1);
            boolean rivalWin = helper(nextMove, map);
            if (!rivalWin) {
               map.put(s, true);
               return true;
            }
         }
      }
      return false;
   }

}
