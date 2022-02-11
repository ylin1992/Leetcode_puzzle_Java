package _Array;

public class _287_FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }

        fast = 0;

        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return fast;
    }
}
