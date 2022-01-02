package Backtracking;
import java.util.*;
public class _046_Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, new Stack<Integer>(), new boolean[nums.length]);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] nums, Stack<Integer> stk, boolean[] visited) {
        if (stk.size() == nums.length) {
            res.add(new ArrayList<>(stk));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // use visited array to avoid duplicates
            if (visited[i]) continue;
            visited[i] = true;
            stk.push(nums[i]);
            helper(res, nums, stk, visited);
            stk.pop();
            visited[i] = false;
        }
    }

}
