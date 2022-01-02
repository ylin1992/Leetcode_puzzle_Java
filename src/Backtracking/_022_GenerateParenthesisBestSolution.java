package Backtracking;
import java.util.*;
public class _022_GenerateParenthesisBestSolution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, 0, 0, "", n);
        return res;
    }
    private void helper(List<String> res, int left, int right, String temp, int n) {
        if (temp.length() == n * 2) {
            res.add(temp);
            return;
        }

        if (left < n) {
            helper(res, left + 1, right, temp + "(", n);
        }
        if (right < left) {
            helper(res, left, right + 1, temp + ")", n);
        }
    }
}
