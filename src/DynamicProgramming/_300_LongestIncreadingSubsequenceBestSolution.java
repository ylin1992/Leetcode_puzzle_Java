package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class _300_LongestIncreadingSubsequenceBestSolution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();

        dp.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int idx = bisect(dp, nums[i]);
            if (idx == dp.size()) {
                dp.add(nums[i]);
            } else {
                dp.set(idx, nums[i]);
            }
        }
        return dp.size();
    }

    private int bisect(List<Integer> dp, int target) {
        int i = 0;
        int j = dp.size() - 1;
        while (i <= j) {
            int m = (j - i) / 2 + i;
            if (dp.get(m) > target) {
                j = m - 1;
            } else if (dp.get(m) < target){
                i = m + 1;
            } else {
                return m;
            }
        }
        return i;
    }
}
