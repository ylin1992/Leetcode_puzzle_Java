package Backtracking;
import java.util.*;
public class _017_LetterCombinations {
    public List<String> letterCombinations(String digits) {
        int[] len = {0,0,3,3,3,3,3,4,3,4};
        char[] startingChar = {' ', ' ','a', 'd', 'g', 'j', 'm', 'p', 't', 'w'};
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        helper(res, "", digits, 0, len, startingChar);
        return res;
    }

    private void helper(List<String> res, String temp, String digits, int cur, int[] len, char[] startingChar) {
        if (temp.length() == digits.length()) {
            res.add(temp);
            return;
        }
        int digit = Character.getNumericValue(digits.charAt(cur));
        for (int i = 0; i < len[digit]; i++) {
            char c = (char) (startingChar[digit] + i);
            helper(res, temp + c, digits, cur + 1, len, startingChar);
        }
    }

    public static void main(String[] args) {
        _017_LetterCombinations lc = new _017_LetterCombinations();
        lc.letterCombinations("23");
    }
}
