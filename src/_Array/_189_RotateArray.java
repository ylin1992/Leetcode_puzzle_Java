package _Array;

public class _189_RotateArray {
   public void rotate(int[] nums, int k) {
      k = k % nums.length; // avoid cases like [1,2], k = 3
      reverse(nums, 0, nums.length - 1);
      reverse(nums, 0, k-1);
      reverse(nums, k, nums.length - 1);
   }
   private void reverse(int[] nums, int i, int j) {
      while (i < j) {
         int temp = nums[i];
         nums[i++] = nums[j];
         nums[j--] = temp;
      }
   }

}
