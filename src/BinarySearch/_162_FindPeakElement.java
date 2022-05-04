package BinarySearch;
// 1 2 1 3 5 6 4
// l     m     r
// [5, 6, 4]


// m m+1 (m > m+1)
// .
//    .
// => [l,m]


// m m+1 (m < m+1)
//    .
// .
// => [m+1, r]

// while loop terminates when: l == r
// since at the end of each iteration, the following tow formula always hold true
// nums[l] > nums[l-1]
// nums[r] > nums[r+1]
// if nums[x] is peak, it must be that x = l = r
public class _162_FindPeakElement {
   public int findPeakElement(int[] nums) {
      int l = 0;
      int r = nums.length - 1;

      while (l < r) {
         int m = (r - l) / 2 + l;
         if (nums[m] > nums[m + 1]) {
            r = m;
         } else {
            l = m + 1;
         }
      }
      return l;
   }
}
