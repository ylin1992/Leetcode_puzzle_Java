package _Stack;
import java.util.*;
public class _503_NGEII {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> stk = new Stack<>(); // stores the index of element that hasn't found its NGE

        for (int i = 0; i < 2 * nums.length; i++) {
            int idx = i % nums.length;
            if (res[idx] == -1) {
                while (!stk.empty() && nums[idx] > nums[stk.peek()]){
                    int val = stk.pop();
                    res[val] = nums[idx];
                }
                stk.push(idx);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        _503_NGEII nge = new _503_NGEII();
        System.out.println(nge.nextGreaterElements(new int[]{1,2,3,2,1}));
    }
}
