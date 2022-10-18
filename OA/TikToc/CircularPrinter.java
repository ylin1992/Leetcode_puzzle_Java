package OA.TikToc;

public class CircularPrinter {
   public static long getTime(String s) {
      char[] chs = s.toCharArray();
      long steps = getSingleStep('A', chs[0]);
      for (int i = 0; i < chs.length - 1; i++) {
         steps += getSingleStep(chs[i], chs[i+1]);
         System.out.println(chs[i] + "->" + chs[i+1] + " = " + getSingleStep(chs[i], chs[i+1]));
      }
      return steps;
   }

   public static long getSingleStep(char c1, char c2) {
      long min = Math.min(Math.abs(c2 - c1), Math.abs(c1 - c2));
      min = Math.min(Math.abs(c2 - c1 + 26), min);
      min = Math.min(Math.abs(c1 - c2 + 26), min);
      return min;
   }
   public static void main(String[] args) {
      System.out.println(getTime("BZA"));
      System.out.println(getTime("AZGB"));
   }
}
