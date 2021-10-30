package _Array;

public class _55_JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;

        int lastTrueIndex = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int stepToNextSlot = nums[i];
            int reversedIndex = nums.length - 1 - i;
            if (reversedIndex - lastTrueIndex <= stepToNextSlot) {
                lastTrueIndex = reversedIndex;
            }
        }
        return lastTrueIndex == nums.length - 1;
    }
}


//          4 3 2 1 0
//          2 1 5 0 8
// lastTrue         0
