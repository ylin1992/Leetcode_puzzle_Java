package OA.TikToc;

import java.util.Arrays;
// [3,2,1,2,7]
// [1,2,2,3,7]
public class MinimumUniqueArray {
   public static int getSum(int[] nums) {
      Arrays.sort(nums);
      int prev = nums[0];
      for (int i = 1; i < nums.length; i++) {
         if (nums[i] <= prev) {
            nums[i] = prev + 1;
         }
         prev = nums[i];
      }

      int sum = 0;
      for (int num : nums)
         sum += num;

      return sum;
   }

   public static void main(String[] args) {
      System.out.println(getSum(new int[] {3,2,1,2,7}));
      System.out.println(getSum(new int[] {2,2,2}));
      System.out.println(getSum(new int[] {1,1,1,1}));
      System.out.println(getSum(new int[] {1, 1, 2, 2, 3, 3, 3}));



   }
}
