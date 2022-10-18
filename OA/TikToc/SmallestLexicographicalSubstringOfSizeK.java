package OA.TikToc;

// tutorial, k = 3
// tut, fails at i = 2
//    -> start new window from i to i + 2
// tor, fails at i = 3
//    -> start new window from i to i + 2
// ori, fails at i = 5
//    -> start new window from i to i + 2
public class SmallestLexicographicalSubstringOfSizeK {
   public static String solve(String input, int k) {
      if(input==null || input.length()<k){
         System.out.println("Invalid Input");
         return null;
      }

      String currSubString = input.substring(0, k);
      String smallestSubString = input.substring(0, k);

      //rest of the string
      for (int i = k; i <input.length() ; i++) {
         currSubString = currSubString.substring(1, k) + input.charAt(i);
         if(currSubString.compareTo(smallestSubString)<0)
            smallestSubString = currSubString;
      }

      return smallestSubString;
   }

   public static void main(String[] args) {
      System.out.println(solve("tutorial", 3));
   }
}
