package _Array;

public class _80_removeDuplicates {
    public int removeDuplicates(int[] nums) {
        // 0 0 0 1 1 1 2
        // 0 0 1 1 1 1 2
        // 0 0 1 1 1 1 2
        // TODO: nums[] = [0] nums = [ 0 0] nums = [0,1]
        int q = 2;
        int p = 2;
        while (p < nums.length) {
            if (nums[p] != nums[p - 1] && nums[p] != nums[p - 2]) {
                nums[q++] = nums[p];
            }
            p++;
        }
        return q;
    }

    public static void main(String[] args) {
        _80_removeDuplicates rd = new _80_removeDuplicates();
        System.out.println(rd.removeDuplicates(new int[]{1,1,1,2,2,3}));
    }
}
