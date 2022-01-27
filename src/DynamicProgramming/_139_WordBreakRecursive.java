package DynamicProgramming;
import java.util.*;
public class _139_WordBreakRecursive {
    public boolean wordBreakRecursive(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        HashMap<String, Boolean> map = new HashMap<>();
        return helper(s, set, map);
    }

    private boolean helper(String s, HashSet<String> set, HashMap<String, Boolean> map) {
        if (map.containsKey(s)) return map.get(s);

        if (set.contains(s)) {
            if (!map.containsKey(s)) map.put(s, false);
            map.put(s, true);
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i, s.length());
            if (set.contains(left) && helper(right, set, map)) {
                if (!map.containsKey(right)) {
                    map.put(right, false);
                }
                map.put(right, true);
                return true;
            }
        }

        if (!map.containsKey(s)) map.put(s, false);

        return false;

    }

    public static void main(String[] args) {
        _139_WordBreakRecursive wbs = new _139_WordBreakRecursive();
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        boolean res = wbs.wordBreakRecursive("leetcode", list);
    }

}
