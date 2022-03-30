package DynamicProgramming;

public class _376_WiggleSubsequence {
   //         [1,17,5,10,13,15,10,5,16,8]
   // dp_p[i]  1  2 2  4
   // dp_n[i]  1  1 3  3

   // dp_p[i] means the longest wiggle seq that goes up, considering 0~i
   // dp_n[i] means the longest wiggle seq that goes down, considering 0~i

   // if nums[i] > nums[i-1] dp_p[i] = dp_n[i-1] + 1 (inherit the max length from the negative part)
   // if nums[i] < nums[i-1] dp_n[i] = dp_p[i-1] + 1
   // if nums[i] == nums[i-1] dp_n[i], dp_p[i] = dp_n[i-1], dp_p[i-1]

   // initial: dp_p[0] = 1, dp_n[0] = 1
   // return max(dp_p[n-1], dp_n[n-1])
   public int wiggleMaxLength(int[] nums) {
      int n = nums.length;

      int[] dpPos = new int[n];
      int[] dpNeg = new int[n];

      dpPos[0] = 1;
      dpNeg[0] = 1;

      for (int i = 1; i < nums.length; i++) {
         if (nums[i] > nums[i-1]) {
            dpPos[i] = dpNeg[i-1] + 1;
            dpNeg[i] = dpNeg[i-1];
         } else if (nums[i] < nums[i-1]) {
            dpNeg[i] = dpPos[i-1] + 1;
            dpPos[i] = dpPos[i-1];
         } else {
            dpPos[i] = dpPos[i-1];
            dpNeg[i] = dpNeg[i-1];
         }
      }
      return Math.max(dpPos[n-1], dpNeg[n-1]);
   }
}
