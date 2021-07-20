package _String;

import java.util.HashMap;

public class _13_RomanToInteger {
    private HashMap<Character, Integer> map;
    public _13_RomanToInteger(){
        buildMap();
    }
    public int romanToInt(String s) {
        int ans = 0;
        int sign = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i + 1 < s.length() && isSameScale(i, s)) {
                sign = -1;
            } else {
                sign = 1;
            }
            ans += map.get(s.charAt(i)) * sign;
        }
        return ans;
    }
    private void buildMap(){
        map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    private boolean isSameScale(int i,  String s){
        //if (i - 1 <= 0) return false; // sign = -1;
        if (s.charAt(i) == 'C' && (s.charAt(i + 1) == 'M' || s.charAt(i + 1) == 'D')) {
            return true;
        }
        if (s.charAt(i) == 'X' && (s.charAt(i + 1) == 'C' || s.charAt(i + 1) == 'L')) {
            return true;
        }
        if (s.charAt(i) == 'I' && (s.charAt(i + 1) == 'X' || s.charAt(i + 1) == 'V')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        _13_RomanToInteger r2i = new _13_RomanToInteger();
        System.out.println(r2i.romanToInt("MCMXCIV"));
    }
}
