package Backtracking;
import java.util.*;
public class _784_LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        helper(s, 0, res, "");
        return res;
    }

    private void helper(String s, int curIdx, List<String> res, String tempString) {
        if (curIdx == s.length()) {
            res.add(tempString);
            return;
        }

        if (!isLetter(s.charAt(curIdx)))
            helper(s, curIdx + 1, res, tempString + s.charAt(curIdx));
        else {
            helper(s, curIdx + 1, res, tempString + s.charAt(curIdx));
            helper(s, curIdx + 1, res, tempString + convertCases(s.charAt(curIdx)));
        }
    }

    private boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private char convertCases(char c) {
        if (c >= 'a' && c <= 'z') {
            return (char) (c + ('A' - 'a'));
        } else {
            return (char) (c - ('A' - 'a'));
        }
    }
    public List<String> letterCasePermutationByBFS(String s) {
        // BFS (binary-tree-level-order like solution)
        if (s == null || s.length() == 0) return new ArrayList<>();

        Queue<String> q = new LinkedList<>();
        q.offer(s);

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) continue;

            int size = q.size();
            for (int j = 0; j < size; j++) {
                char[] chars = q.poll().toCharArray();
                chars[i] = Character.toLowerCase(chars[i]);
                q.offer(String.valueOf(chars));

                chars[i] = Character.toUpperCase(chars[i]);
                q.offer(String.valueOf(chars));
            }
        }
        return new ArrayList<>(q);
    }

}
