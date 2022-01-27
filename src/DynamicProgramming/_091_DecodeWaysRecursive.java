package DynamicProgramming;

import java.util.HashMap;

public class _091_DecodeWaysRecursive {
    public int numDecodings(String s) {
        return helper(s, 0, s.length() - 1, new HashMap<Integer, Integer>());
    }

    private int helper(String s, int l, int r, HashMap<Integer, Integer> map) {
        if (map.containsKey(l)) return map.get(l);
        if (l > r) return 1;
        if (l == r) return s.charAt(l) == '0' ? 0 : 1;
        if (s.charAt(l) == '0') return 0;

        int res = helper(s, l+1, r, map);
        int prefix = (s.charAt(l) - '0') * 10 + (s.charAt(l+1) - '0');
        if (prefix <= 26) {
            res += helper(s, l+2, r, map);
        }
        map.put(l, res);
        return res;
    }
    public static void main(String[] args) {
        _091_DecodeWaysRecursive dw = new _091_DecodeWaysRecursive();
        dw.numDecodings("12");
    }
}
