package _String;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {
   public List<String> generatePossibleNextMoves(String currentState) {
      List<String> list = new ArrayList<>();
      // if (currentState.length() <= 2) return list;
      char[] chs = currentState.toCharArray();

      for (int i = 0; i < chs.length - 1; i++) {
         if (chs[i] == chs[i+1] && chs[i] == '+') {
            chs[i] = '-';
            chs[i+1] = '-';
            list.add(String.valueOf(chs));
            chs[i] = '+';
            chs[i+1] = '+';
         }
      }
      return list;
   }

}
