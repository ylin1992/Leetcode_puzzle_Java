package Sorting;

public class _493_ReversePairs {
    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return 0;
        }

        int mid = (hi - lo) / 2 + lo; // prevent data overflow
        int res = 0;
        res += mergeSort(nums, lo, mid);
        res += mergeSort(nums, mid + 1, hi);
        res += merge(nums, lo, mid, hi);
        return res;
    }

    private static int merge(int[] nums, int lo, int mid, int hi) {
        int p = lo, q = mid + 1;
        int count = 0;
        int[] tmpArr = new int[hi - lo + 1];
        // [1 2 3 4] [1 5 6 7]
        while (p <= mid && q <= hi) {
            if (nums[p] > 2L * nums[q]) {
                count += mid - p + 1;
                q++;
            } else {
                p++;
            }
        }
        p = lo;
        q = mid + 1;
        int idx = 0;
        while (p <= mid && q <= hi) {
            if (nums[p] > nums[q]) {
                tmpArr[idx++] = nums[q++];
            } else {
                tmpArr[idx++] = nums[p++];
            }
        }
        while (p <= mid) {
            tmpArr[idx++] = nums[p++];
        }
        while (q <= hi) {
            tmpArr[idx++] = nums[q++];
        }
        System.arraycopy(tmpArr, 0, nums, lo, hi - lo + 1);
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,3,5,1};
        int ans = reversePairs(arr);
        System.out.println(ans);
    }
}
