package TwoPointers;

/*
   O(1) space and O(n) time
 */
public class _844_BackSpaceStringCompare_FollowUp {
   public boolean backspaceCompare(String s, String t) {
      int i = s.length() - 1;
      int j = t.length() - 1;

      while (true) {
         int backSpaceNum = 0;
         // find the last valid char for s
         while (i >= 0) {
            if (s.charAt(i) == '#') {
               backSpaceNum++; // found a backspace char, we should advance i by 1
               i--;
            } else {
               if (backSpaceNum > 0) { // consume the backspace
                  backSpaceNum--;
                  i--;
               } else {
                  break; // found the valid char at position i
               }
            }
         }

         // do the same thing for t
         backSpaceNum = 0;
         while (j >= 0) {
            if (t.charAt(j) == '#') {
               backSpaceNum++; // found a backspace char, we should advance i by 1
               j--;
            } else {
               if (backSpaceNum > 0) { // consume the backspace
                  backSpaceNum--;
                  j--;
               } else {
                  break; // found the valid char at position i
               }
            }
         }
         if (i >= 0 && j >= 0 && s.charAt(i) == t.charAt(j)) {
            i--;
            j--;
         } else {
            break;
         }
      }
      return i == -1 && j == -1;
   }

}
