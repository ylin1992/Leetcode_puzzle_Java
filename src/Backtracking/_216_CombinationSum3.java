package Backtracking;
import java.util.*;
public class _216_CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(k, n, new Stack<Integer>(), res, 1, n);
        return res;
    }

    private void helper(int k, int n, Stack<Integer> stk, List<List<Integer>> res, int cur, int remain) {
        // if cur + 1 = 10, remain - cur = 0, so we have to set limitation as > 10, not > 9
        // for example, k = 45, n = 9
        // if we set cur > 9, we get [], since when cur + 1 comes to 10, remain is 0, we should have added it
        // but the logic forces it to return
        // Instead, if we set cur > 10, we can solve this issue
        if (cur > 10)
            return;

        if (cur == n) {
            if (stk.size() == k && remain == 0) {
                res.add(new ArrayList<>(stk));
            }
            return;
        }

        if (stk.size() == k && remain == 0) {
            res.add(new ArrayList<>(stk));
            return;
        }

        if (remain < 0)
            return;

        if (stk.size() > k)
            return;

        helper(k, n, stk, res, cur + 1, remain);

        stk.push(cur);
        helper(k, n, stk, res, cur + 1, remain - cur);
        stk.pop();

    }
}
