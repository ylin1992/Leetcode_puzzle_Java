package HashMap;

import java.util.HashMap;
import java.util.HashSet;

public class _290_WordPattern {
    public boolean wordPattern(String pattern, String s) {
        // a b c a
        // cat dog dog cat
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        String[] strings = s.split("\\s+");

        for (int i = 0; i < strings.length; i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) != strings[i]) {
                    return false;
                }
            } else {
                if (set.contains(strings[i])) {
                    return false;
                }
            }
            map.put(c, strings[i]);
            set.add(strings[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        _290_WordPattern wp = new _290_WordPattern();
        boolean ans = wp.wordPattern("abba", "cat, dog, dog, cat");
        System.out.println();
    }
}
