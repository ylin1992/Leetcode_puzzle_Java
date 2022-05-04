package BinarySearch;

/**
 * Strategy:
 * 1. find where is the min index by BS
 * 2. according to the relationship between target and BS
 *    do ordinary BS with new range
 */
public class _33_SearchInRotatedSortedArray {
   class Solution {
      public int search(int[] nums, int target) {
         int n = nums.length;
         int minIdx = findMinIndex(nums);
         if (target == nums[minIdx]) return minIdx;

         int l = target > nums[n - 1] ? 0 : minIdx + 1;
         int r = target > nums[n - 1] ? minIdx - 1 : n -1;

         while (l <= r) {
            int m = (r - l) / 2 + l;
            if (target == nums[m]) return m;
            if (target > nums[m]) {
               l = m + 1;
            } else {
               r = m - 1;
            }
         }
         return -1;
      }

      public int findMinIndex(int[] nums) {
         int n = nums.length;
         int l = 0;
         int r = n - 1;
         while (l < r) {
            int m = (r - l) / 2 + l;
            if (nums[m] > nums[r]) {
               l = m + 1;
            } else {
               r = m;
            }
         }
         return l;
      }
   }
}
