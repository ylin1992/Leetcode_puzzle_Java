package Design;

import java.util.*;

public class _15_ThreeSum {
    /**
     * [-1 0 1 2 -1 -4]
     * [-4 -1 -1 0 1 2]
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums){

        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int num = nums[i];
            int target = 0 - num;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _15_ThreeSum ts = new _15_ThreeSum();
        int[] input = new int[]{-2,0,0,2,2};
        List<List<Integer>> ans = ts.threeSum(input);
        System.out.println();
    }
}
