package _String;

public class _294_FlipGameII_1SubStringSlowest {
   public boolean canWin(String currentState) {
      // System.out.println(currentState);
      for (int i = 1; i < currentState.length(); i++) {
         if (currentState.charAt(i) == '+' && currentState.charAt(i-1) == '+') {
            String nextMove = currentState.substring(0, i-1) + "--" + currentState.substring(i+1, currentState.length());
            if (!canWin(nextMove)) {
               return true;
            }
         }
      }
      return false;
   }
}
