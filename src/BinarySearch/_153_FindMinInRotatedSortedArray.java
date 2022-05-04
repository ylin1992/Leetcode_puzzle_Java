package BinarySearch;

// [4,5,6,7,0,1,2]
//  l     m     r
//        l m   r
// r < m => left rotated (min val is on the right)
// keep searching until we find nums[m-1] < nums[m] < nums[m+1]
// then nums[m] is the min val.

// 5 1 2 3 4
// l   m   r
// l r

public class _153_FindMinInRotatedSortedArray {
   public int findMin(int[] nums) {
      if (nums.length == 1) return nums[0];
      if (nums.length == 2) return Math.min(nums[0], nums[1]);
      int l = 0;
      int r = nums.length - 1;
      int m = (r - l) / 2 + l;
      while (true) {
         if (m != 0 && m != nums.length-1 && nums[m] < nums[m-1] && nums[m] < nums[m+1]) break;
         if (nums[r] < nums[m]) {
            l = m + 1;
         } else {
            r = m - 1;
         }
         m = (r - l) / 2 + l;
         if (m == 0 && nums[m] < nums[nums.length - 1] && nums[m] < nums[m+1]) break;
         else if (m == nums.length - 1 && nums[m] < nums[0] && nums[m] < nums[m-1]) break;
      }
      return nums[m];
   }
}
