package Sort;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                } else {
                    break;
                }
            }
        }
        System.out.println("result = " + Arrays.toString(nums));
    }

    private static void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }

    public static void insertionBinarySort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int start = 0;
            int end = i;
            int tmp = nums[i + 1];
            int insertIndex = binarySearch(nums, start, end, tmp);
            for (int j = i; j >= insertIndex; j--) {
                nums[j + 1] = nums[j];
            }
            nums[insertIndex] = tmp;
        }
        System.out.println("result of binary sort= " + Arrays.toString(nums));
    }

    private static int binarySearch(int[] nums, int start, int end, int target) {
        // test case
        // 1, 3, 5, 7, 8, target = 2
        // return 1
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = start + 1;
            }
        }
        return start; // return the second one
    }

    public static int findDuplicate(int[] nums) {
        int start = 1;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int cnt = 0;
            for (int num : nums) {
                if (num >= mid) {
                    cnt = cnt + 1;
                }
            }
            if (cnt > mid) { // duplicate number is in [start, mid)
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            System.out.println("start = " + start + ", end = " + end + ", count = " + cnt);
        }
        return start;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 7, 1, 3, 2, 8, 9, 0};
        insertionBinarySort(nums);

        findDuplicate(new int[]{1, 3, 4, 2, 2});
    }
}
