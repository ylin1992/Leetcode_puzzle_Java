package Sorting;

public class MergeSort {
    public static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }
    private static void mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int mid = (hi - lo) / 2 + lo;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private static void merge(int[] nums, int lo, int mid, int hi) {
        int[] newArr = new int[hi - lo + 1];
        int p = lo;
        int q = mid + 1;
        int idx = 0;
        while (p <= mid && q <= hi) {
            if (nums[p] > nums[q]) {
                newArr[idx++] = nums[q++];
            } else {
                newArr[idx++] = nums[p++];
            }
        }
        while (p <= mid) {
            newArr[idx++] = nums[p++];
        }
        while (q <= hi) {
            newArr[idx++] = nums[q++];
        }
        System.arraycopy(newArr, 0, nums, lo, hi - lo + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8,4,3,5,9,11,2,1};
        mergeSort(arr);
        System.out.println();
    }
}
