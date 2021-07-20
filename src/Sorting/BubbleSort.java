package Sort;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) { // idx = nums.length - 1 has no need to be traveresed
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
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

    public static void moveZeroes283(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] == 0 && j + 1 < nums.length) {
                    if (nums[j + 1] != 0)
                        swap(nums, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 7, 1, 3, 2, 8, 9, 0};
        bubbleSort(nums);
    }
}
