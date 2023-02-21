package _Stack;

import java.util.HashSet;
import java.util.Stack;

public class _1249_MinRemoveToMakeValid {
   /*
      Use a hashset to record the invalid bracket's index
      Meanwhile, use a stack to store the index of left bracket we've visited so far.
      - If we're visiting a right bracket, and the stack is not empty, this means that there are still
        some left brackets have not been paired up (or cancelled out), so in this case we should pop the top
        element out.
      - If we are visiting a right bracket, and the stack is empty, it means that all the left and right brackets
        we have visited are already paired up, in this case this right brackets is invalid, we should store this index
        into the toRemove set
      - If we are visiting a left bracket, just push it into the stack.
    */
   public String minRemoveToMakeValid(String s) {
      Stack<Integer> stk = new Stack<>();
      HashSet<Integer> toRemove = new HashSet<>();
      for (int i = 0; i < s.length(); i++) {
         char c = s.charAt(i);
         if (c == '(') {
            stk.push(i);
         } else if (c == ')') {
            if (stk.isEmpty()) {
               toRemove.add(i);
            } else {
               stk.pop();
            }
         }
      }
      while (!stk.isEmpty()) {
         toRemove.add(stk.pop());
      }

      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < s.length(); i++) {
         if (toRemove.contains(i))
            continue;
         sb.append(s.charAt(i));
      }
      return sb.toString();
   }
}
