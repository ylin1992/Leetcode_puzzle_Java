package TwoPointers;

/**
 * l starts from 0
 * r starts from -1
 * keep monitoring the area circled with the two walls (l, r)
 * if h[l] < h[r] -> means if we don't move l -> l + 1, no improvement will be made since the min height is [l]
 *                -> we need to move l -> l + 1
 * the same, if h[r] > h[l], we need to move r -> r - 1
 * If h[l] == h [r], we can move either way
 */
public class _011_ContainWithMostWater {
   public int maxArea(int[] height) {
      int res = Integer.MIN_VALUE;
      int l = 0;
      int r = height.length - 1;
      while (l < r) {
         res = Math.max(res, (r - l) * Math.min(height[r], height[l]));
         if (height[r] >= height[l]) l++;
         else r--;
      }
      return res;
   }
}
