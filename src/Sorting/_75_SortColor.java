package Sorting;

public class _75_SortColor {
    public static void sortColors(int[] nums) {
        int idx0 = 0;
        int idx2 = nums.length - 1;
        for (int i = 0; i < nums.length; i++){
            while (nums[i] != 1) {
                if (nums[i] == 0) {
                    swap(nums, idx0, i);
                    idx0++;
                } else if (nums[i] == 2 && i < idx2) {
                    swap(nums, idx2, i);
                    idx2--;
                }
            }
        }
    }

    private static void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    public static void main(String[] args) {
        sortColors(new int[]{2,0,2,1,1,0});
    }
}
