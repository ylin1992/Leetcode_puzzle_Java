package Backtracking;
import java.util.*;
public class _090_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        helper(list, nums, 0, new Stack<Integer>(), true);
        return list;
    }

    private void helper(List<List<Integer>> list, int[] nums, int index, Stack<Integer> stk, boolean taken) {
        if (index == nums.length) {
            list.add(new ArrayList<>(stk));
            return;
        }

        helper(list, nums, index +1, stk, false);
        if (taken || nums[index] != nums[index - 1]) {
            stk.push(nums[index]);
            helper(list, nums, index + 1, stk, true);
            stk.pop();
        }
    }

}
