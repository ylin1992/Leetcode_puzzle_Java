package Greedy;

public class _55_JumpGame {
    public boolean canJump(int[] nums) {
        int right = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (right < i) return false;
            right = Math.max(right, i + nums[i]);
        }

        return right >= nums.length - 1;
    }
}
