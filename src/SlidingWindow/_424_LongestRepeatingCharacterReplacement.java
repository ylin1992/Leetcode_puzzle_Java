package SlidingWindow;

public class _424_LongestRepeatingCharacterReplacement {
   public int characterReplacement(String s, int k) {
      int[] counts = new int[26];
      int maxLength = 0;

      int maxCount = 0;
      // l and r are boundaries of the window
      int l = 0;
      for (int r = 0; r < s.length(); r++) {
         counts[s.charAt(r) - 'A']++;
         maxCount = Math.max(counts[s.charAt(r) - 'A'], maxCount);
         // lettersToReplace = windowSize - maxCount
         // for example: ABABA, l = 0, r = 4, we should replace 2 B's to A
         // since the max frequent letters is A, which has counts of 3
         int lettersToReplace = (r - l + 1) - maxCount;
         if (lettersToReplace > k) {
            // move l forward
            counts[s.charAt(l) - 'A']--;
            l++;
         }
         maxLength = Math.max(maxLength, r - l + 1);
      }
      return maxLength;
   }
}
