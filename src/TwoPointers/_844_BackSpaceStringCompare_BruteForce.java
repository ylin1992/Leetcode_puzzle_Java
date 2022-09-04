package TwoPointers;

import java.util.Stack;
/*
   O(n) space
   O(n) time
   Follow-up: Solve this with O(1) space
 */
public class _844_BackSpaceStringCompare_BruteForce {
   public boolean backspaceCompare(String s, String t) {
      Stack<Character> stkS = new Stack<>();
      Stack<Character> stkT = new Stack<>();

      for (char c : s.toCharArray()) {
         if (c == '#' ) {
            if (!stkS.isEmpty())
               stkS.pop();
         } else {
            stkS.push(c);
         }
      }
      for (char c : t.toCharArray()) {
         if (c == '#') {
            if (!stkT.isEmpty())
               stkT.pop();
         } else {
            stkT.push(c);
         }
      }
      if (stkT.size() != stkS.size()) return false;
      if (stkT.size() == 0 && stkS.size() == 0) return true;
      while (!stkT.isEmpty()) {
         if (stkT.pop() != stkS.pop()) return false;
      }
      return true;
   }

}
