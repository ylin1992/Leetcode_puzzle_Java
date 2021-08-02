package _Array;

public class _41_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        boolean containsOne = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                containsOne = true;
            } else if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }

        if (containsOne == false) return 1;

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] *= nums[index] < 0 ? 1 : -1;
        }
        int k = 0;
        while (k < nums.length) {
            if (nums[k] > 0) {
                return k + 1;
            }
            k++;
        }
        return k + 1;
    }

    public static void main(String[] args) {
        _41_FirstMissingPositive fmpn = new _41_FirstMissingPositive();
        System.out.println(fmpn.firstMissingPositive(new int[]{3,4,-1,1}));
    }
}
