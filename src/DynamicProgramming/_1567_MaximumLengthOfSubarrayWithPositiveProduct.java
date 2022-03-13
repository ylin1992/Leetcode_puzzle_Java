package DynamicProgramming;

public class _1567_MaximumLengthOfSubarrayWithPositiveProduct {
   // Dry run provided by harin_mehta
   // elements      :   9    5    8    2    -6    4    -3    0    2    -5    15    10    -7    9    -2
   // positive_len  :   1    2    3    4     0    1     7    0    1     0     1     2     5    6     5
   // negative_len  :   0    0    0    0     5    6     2    0    0     2     3     4     3    4     7
   public int getMaxLen(int[] nums) {
      if (nums.length == 0) return nums[0] > 0 ? 1 : 0;

      int[] posL = new int[nums.length];
      int[] negL = new int[nums.length];
      posL[0] = nums[0] > 0 ? 1 : 0;
      negL[0] = nums[0] < 0 ? 1 : 0;
      int maxL = posL[0] > 0 ? 1 : 0;
      for (int i = 1; i < nums.length; i++) {
         if (nums[i] == 0) {
            posL[i] = 0;
            negL[i] = 0;
            continue;
         } else if (nums[i] > 0) {
            posL[i] = posL[i-1] + 1;
            negL[i] = negL[i-1] == 0 ? 0 : negL[i-1] + 1;
         } else {
            posL[i] = negL[i-1] == 0 ? 0 : negL[i-1] + 1;
            negL[i] = posL[i-1] + 1;
         }
         maxL = Math.max(maxL, posL[i]);
      }
      return maxL;
   }

}
