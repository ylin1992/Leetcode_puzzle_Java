package BinarySearch;

public class _852_PeakIndexInAMountainArray {
   public int peakIndexInMountainArray(int[] arr) {
      int lo = 0;
      int hi = arr.length - 1;

      while (lo < hi) {
         int mid = lo + (hi - lo) / 2;
         if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
            return mid;
         if (arr[mid] > arr[mid-1] && arr[mid] < arr[mid+1])
            lo = mid;
         else if (arr[mid] < arr[mid-1] && arr[mid] > arr[mid+1])
            hi = mid;
      }
      return -1;
   }
}

// [18,29,38,59,98,100,99,98,90]
//  l           m             h
// divide and conquer:
//     .
//   .   .
// .       .
//           .
// [lo, hi]
// if mid < mid - 1 && mid > mid + 1 -> [lo, mid] (backslash direction: \)
// if mid > mid - 1 && mid < mid + 1 -> [mid, hi] (slash direction: /)
// if mid > mid - 1 && mid > mid + 1 -> return mid, this is the summit
