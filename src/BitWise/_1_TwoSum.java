package BitwiseOperation;

import java.util.HashMap;

public class _1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> diffMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int d = target - nums[i];
            if (diffMap.containsKey(d)) {
                return new int[]{i, diffMap.get(d)};
            }
            diffMap.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        _1_TwoSum ts = new _1_TwoSum();
        int[] ans = ts.twoSum(new int[]{7, 2, 1, 3}, 9);
        System.out.println(ts.twoSum(new int[]{7, 2, 1, 3}, 9));
    }
}
