package BinarySearch;

/**
 * Strategy: divide the problem in three cases
 * 1. m and t lie on left --> l < t < m --> in this case we move r to m, otherwise move l to m
 * 2. m and t lie on right --> m < t < r --> in this case we move l to m, otherwise move r to m
 * 3. l = m --> duplicate: move l -> l+1, at some point there will be a position where l > m
 */
public class _081_SearchInRotatedArrayII {
   public boolean search(int[] nums, int target) {
      int n = nums.length;

      int l = 0;
      int r = n - 1;
      int m = 0;
      while (l+1 < r) {
         m = (r-l) / 2 + l;
         System.out.println("l: " + l + " ,m: " + m + ", r: " + r);
         if (nums[m] == target) return true;
         if (nums[m] > nums[l]) {
            // l < t < m
            if (target >= nums[l] && nums[m] >= target) r = m;
               // if not l < t < m, t may lie on right or on the tip if left array
            else l = m;
         } else if (nums[m] < nums[l]){
            if (target >= nums[m] && nums[r] >= target) l = m;
            else r = m;
         } else l++;
      }
      System.out.println("l: " + l + " ,m: " + m + ", r: " + r);
      return nums[l] == target || nums[r] == target;
   }
}
