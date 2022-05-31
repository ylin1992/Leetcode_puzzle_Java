package BinarySearch;

/**
 * Binary search, but this time we do not stop when reaching the target,
 * instead, we keep searching until the loop terminates.
 * for finding the first index of the target, we let mid = right when nums[mid] == target
 * on the contrary, we let mid = left when nums[mid] == target.
 * In this way we can finally get the "First" and "Last" index where the target lies in the array
 */
public class _034_FindFirstandLastPositionofElementinSortedArray {
   public int[] searchRange(int[] nums, int target) {
      if (nums.length == 0) return new int[]{-1,-1};
      int l = findFirst(nums, target);
      int r = findLast(nums, target);
      return new int[]{l, r};
   }

   // keep searching elements on right if we find the target
   private int findFirst(int[] nums, int target) {
      int l = 0;
      int r = nums.length - 1;
      while (l + 1< r) {
         int mid = (r - l) / 2 + l;
         if (nums[mid] >= target) {
            r = mid;
         } else {
            l = mid;
         }
      }

      if (nums[l] == target) return l;
      if (nums[r] == target) return r;
      return -1;
   }

   private int findLast(int[] nums, int target) {
      int l = 0;
      int r = nums.length - 1;
      while (l + 1< r) {
         int mid = (r - l) / 2 + l;
         if (nums[mid] > target) {
            r = mid;
         } else {
            l = mid;
         }
      }

      if (nums[r] == target) return r;
      if (nums[l] == target) return l;
      return -1;
   }

}
