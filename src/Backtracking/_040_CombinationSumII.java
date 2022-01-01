package Backtracking;
import java.util.*;
public class _040_CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, new Stack<Integer>(), 0, true, candidates, target);
        return res;
    }

    private void helper(List<List<Integer>> res, Stack<Integer> stk, int cur, boolean isTaken, int[] nums, int target) {
        if (cur == nums.length) {
            if (target == 0) {
                res.add(new ArrayList<>(stk));
            }
            return;
        }
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<>(stk));
            return;
        }
        // not taking nums[cur]
        helper(res, stk, cur + 1, false, nums, target);

        // taking nums[cur]
        // if the previous item is taken, continue taking the current one
        // if the preovious one is not taken, and if nums[cur - 1] == nums[cur]
        // we should skip the recursion stack since the path of [cur-1, cur] is already considered

        // for example:
        // [1, 1', 2]
        // if 1 is taken, we should pick 1' when it comes to 1'
        // since the path of [1, 1'] is already considered,
        // when the path comes to "1 is not selected", we should ignore 1' as well
        if (isTaken || nums[cur] != nums[cur - 1]) {
            stk.push(nums[cur]);
            helper(res, stk, cur + 1, true, nums, target - nums[cur]);
            stk.pop();
        }

    }

}
