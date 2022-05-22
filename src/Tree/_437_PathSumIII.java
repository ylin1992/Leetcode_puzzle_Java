package Tree;
import java.util.*;

// dfs + memoization
// hashmap records how many times the summation has shown up
// for example:
//       10
//    5      -3
//  3   2       11
// 3 -2   1

// left side dsf
// 10 -> map: 10
// 5 -> map: 10, 15
// 3 -> map: 10, 15, curSum = 15 + 3 = 18, and 18 - target = 8 is in the map, we increase count by map.get(8)
public class _437_PathSumIII {
    class Count {
        private int count;
        public Count(int count) {
            this.count = count;
        }
        public void inc(int num) {
            this.count += num;
        }
        public void dec() {
            this.count--;
        }
        public int get() {
            return this.count;
        }
    }
    public int pathSum(TreeNode root, int targetSum) {
        // int count = 0;
        Count count = new Count(0);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // for cases where curSum + root.val == targetSum
        dfs(root, 0, targetSum, map, count);
        return count.get();
    }
    private void dfs(TreeNode root, int curSum, int targetSum, HashMap<Integer, Integer> map, Count count) {
        if (root == null) return;

        curSum += root.val;
        int diff =  curSum - targetSum;
        count.inc(map.getOrDefault(diff,0));
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        dfs(root.left, curSum, targetSum, map, count);
        dfs(root.right, curSum, targetSum, map, count);
        map.put(curSum, map.getOrDefault(curSum, 0) - 1);
    }

    public static void main(String[] args) {
        TreeNodeHelper helper = new TreeNodeHelper();
        TreeNode root = helper.levelOrderTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1});
        _437_PathSumIII ps = new _437_PathSumIII();
        int res = ps.pathSum(root, 22);
    }
}
