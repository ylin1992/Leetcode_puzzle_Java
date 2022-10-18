package OA.TikToc;

import java.util.ArrayList;
import java.util.List;

public class CountingBinarySubstrings {
   public int countBinarySubstrings(String s) {
      if (s.length() <= 1) return 0;
      List<Integer> list = new ArrayList<>();
      char[] chs = s.toCharArray();
      for (int i = 1; i < chs.length; i++) {
         int count = 1;
         while(i < chs.length && chs[i] == chs[i-1]) {
            i++;
            count++;
         }
         // System.out.println(count);
         list.add(count);
      }
      if (chs[chs.length-1] != chs[chs.length-2])
         list.add(1);

      int res = 0;
      for (int i = 0; i < list.size() - 1; i++) {
         res += Math.min(list.get(i), list.get(i+1));
      }
      return res;
   }

}
