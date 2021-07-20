package Design;

public class _26_RemoveDuplicateNumbersFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length + 1;
        int res = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[res] != nums[res - 2]) {
                nums[res++] = nums[i];
            }
        }
        return res;
    }
}
