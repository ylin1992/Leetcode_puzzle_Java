package TwoPointers;

public class _408_ValidWordAbbreviation {
   public boolean validWordAbbreviation(String word, String abbr) {
      int i = 0;
      int j = 0;
      int accumNum = 0;
      while (i < word.length() && j < abbr.length()) {
         char cW = word.charAt(i);
         char cA = abbr.charAt(j);
         if (cW == cA) {
            i++;
            j++;
            continue;
         }
         // cA is not a number and cA != cW
         if (!Character.isDigit(cA)) {
            return false;
         }
         // cA is a number
         // int runningJ = j;
         while (Character.isDigit(abbr.charAt(j))) {
            accumNum = accumNum * 10 + (abbr.charAt(j) - '0');

            // this is for the case where there is a '0' in abbr
            // i.e. word = "a", abbr = "01", this is expected to output false
            if (accumNum == 0)
               return false;
            j++;
            if (j >= abbr.length())
               break;
         }

         i += accumNum;
         accumNum = 0;
         // System.out.println("i: " + i + ", j: " + j);

      }
      return i == word.length() && j == abbr.length();
   }
}
