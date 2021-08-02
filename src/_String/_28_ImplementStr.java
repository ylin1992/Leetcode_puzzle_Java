package _String;
import java.util.*;
public class _28_ImplementStr {
    public int strStr(String haystack, String needle) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < needle.length(); i++) {
            if (i == needle.length() - 1) {
                if (map.containsKey(needle.charAt(i))) {
                    continue;
                }
                map.put(needle.charAt(i), needle.length());
            } else {
                map.put(needle.charAt(i), needle.length() - i - 1);
            }

        }
        // ababbbbaaabbbaaa
        // bbbb
        int i = needle.length() - 1;

        while (i < haystack.length()) {
            int tmpIdx = i;
            int j = needle.length() - 1;
            while (j >= 0) {
                if (needle.charAt(j) == haystack.charAt(tmpIdx)) {
                    j--;
                    tmpIdx--;
                } else {
                    int offset = map.containsKey(haystack.charAt(i)) ? map.get(haystack.charAt(i)) : needle.length();
                    i += offset;
                    break;
                }
            }
            if (j < 0) {
                return tmpIdx + 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        _28_ImplementStr is = new _28_ImplementStr();
        System.out.println(is.strStr("ababbbbaaabbbaaa", "bbbb"));
    }
}
