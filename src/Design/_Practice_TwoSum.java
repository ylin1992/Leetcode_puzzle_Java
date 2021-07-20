package Design;

import java.util.*;

public class _Practice_TwoSum {
    public List<List<Integer>> twoSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (res.isEmpty() || res.get(res.size() - 1).get(0) != nums[i]) {
                if (set.contains(diff)) {
                    res.add(Arrays.asList(nums[i], diff));
                }
                set.add(nums[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _Practice_TwoSum ts = new _Practice_TwoSum();
        List<List<Integer>> list = ts.twoSum(new int[]{-2,-1,0,0,0,0,0,0,0,1,2}, 0);
        System.out.println();
    }
}
