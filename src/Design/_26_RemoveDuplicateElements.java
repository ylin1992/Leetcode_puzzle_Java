package Design;

public class _26_RemoveDuplicateElements {
    public int removeDuplicates(int[] nums) {
        // 0 1 2 2
        // 0 1 1 2
        // 0 0 1 2
        // 0 0 0 0 0 0 1 1 1 1 1 2 2
        int p = 0, q = 0;
        while (q < nums.length) {
            while (q < nums.length && nums[p] == nums[q]) {
                q++;
            }
            swap(nums, ++p, q++);
        }
        return p;
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        _26_RemoveDuplicateElements rde = new _26_RemoveDuplicateElements();
        int[] nums = new int[]{1,1,1,1,1,1,2};
        int ans = rde.removeDuplicates(nums);
        System.out.println(ans);
    }
}
