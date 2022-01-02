package Backtracking;
import java.util.*;
public class _022_GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, 0, 0, "", n);
        return res;
    }
    private void helper(List<String> res, int left, int right, String temp, int n) {
        if (right > left) return;
        if (left == n && right == n) {
            res.add(temp);
            return;
        }

        if (left == n && right < n) {
            temp += ")";
            helper(res, left, right + 1, temp, n);
            temp = temp.substring(0, temp.length() - 1);
            return;
        }

        if (left == right) {
            temp += "(";
            helper(res, left + 1, right, temp, n);
            temp = temp.substring(0, temp.length() - 1);
            return;
        }

        if (left < n) {
            temp += "(";
            helper(res, left + 1, right, temp, n);
            temp = temp.substring(0, temp.length() - 1);

            temp += ")";
            helper(res, left, right + 1, temp, n);
            temp = temp.substring(0, temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        _022_GenerateParenthesis gp = new _022_GenerateParenthesis();
        List<String> res = gp.generateParenthesis(3);
    }

}
