package Backtracking;
import java.util.*;
public class _078_BinarySolution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int s = 0; s < (1 << n); s++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((s & (1 << i)) > 0) {
                    list.add(nums[i]);
                }
            }
            res.add(list);
        }
        return res;
    }
}
