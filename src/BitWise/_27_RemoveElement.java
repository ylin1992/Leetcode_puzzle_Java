package BitwiseOperation;

public class _27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        // 3 3 3 4 2 4 5 6, val = 2
        //       r
        //            i

        // 2 3 3 3 2, val = 2
        //       r
        //         i
        if (nums == null || nums.length == 0) return 0;

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[ans++] = nums[i];
            }
        }
        return ans;
    }
}
