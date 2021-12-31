package Backtracking;
import java.util.*;

public class _039_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, new Stack<Integer>(), res, 0);
        return res;
    }

    private void helper(int[] nums, int target, Stack<Integer> stk, List<List<Integer>> res, int cur) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(stk));
            return;
        }
        for (int i = cur; i < nums.length; i++) {
            stk.push(nums[i]);
            helper(nums, target - nums[i], stk, res, i);
            stk.pop();
        }
    }

    public static void main(String[] args) {
        _039_CombinationSum ss = new _039_CombinationSum();
        int[] nums = {2,3,5};
        int target = 8;
        List<List<Integer>> res = ss.combinationSum(nums, target);
    }
}
