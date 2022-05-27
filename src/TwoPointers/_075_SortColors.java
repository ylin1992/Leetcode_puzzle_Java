package TwoPointers;

public class _075_SortColors {
   public void sortColors(int[] nums) {
      if (nums.length == 1) return;
      int i = 0;
      int j = 0;
      while (i < nums.length && j < nums.length) {
         if (nums[j] == 0) {
            int temp = nums[j];
            nums[j++] = nums[i];
            nums[i++] = temp;
         } else {
            j++;
         }
      }

      j = i;
      while (i < nums.length && j < nums.length) {
         if (nums[j] == 1) {
            int temp = nums[j];
            nums[j++] = nums[i];
            nums[i++] = temp;
         } else {
            j++;
         }
      }
   }
   public void sortColorsBetter(int[] nums) {
      int idx0 = 0;
      int idx2 = nums.length - 1;
      int i = 0;
      while (i <= idx2) {
         if (nums[i] == 0) {
            swap(nums, i, idx0);
            i++;
            idx0++;
         } else if (nums[i] == 2) {
            swap(nums, i, idx2);
            idx2--;
         } else {
            i++;
         }
      }
   }

   private void swap(int[] nums, int i1, int i2) {
      int temp = nums[i1];
      nums[i1] = nums[i2];
      nums[i2] = temp;
   }


}
