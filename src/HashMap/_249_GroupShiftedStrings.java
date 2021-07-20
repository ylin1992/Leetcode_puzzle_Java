package HashMap;

import java.util.*;

public class _249_GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>(); // <String, count>
        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];
            map.put(str, map.containsKey(str) ? map.get(str) + 1 : 1);
        }
        int k = 0;
        while (!map.isEmpty()) {
            String str = strings[k++];
            List<String> list = new ArrayList<>();
            if (map.containsKey(str)) {
                list.add(str);
                for (int i = 0; i < 26; i++) {
                    String shiftedString = shiftString(str, i);
                    if (map.containsKey(shiftedString)) {
                        list.add(shiftedString);
                        map.put(shiftedString, map.get(shiftedString) - 1);
                        if (map.get(shiftedString) == 0) {
                            map.remove(shiftedString);
                        }
                    }
                }
                if (map.get(str) == 1) {
                    map.remove(str);
                }
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) - 1);
                }
            }

            if (!list.isEmpty()) {
                res.add(list);
            }

        }
        return res;
    }

    private String shiftString(String str, int i) {
        char[] ch = str.toCharArray();
        for (int k = 0; k < ch.length; k++) {
            char c = ch[k];
            ch[k] = (char) (c + i) > 'z' ? (char) (c + i - 26)  : (char) (c + i);
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        _249_GroupShiftedStrings gsp = new _249_GroupShiftedStrings();
        List<List<String>> ans = gsp.groupStrings(new String[]{"abc","abc","bcd","acef","xyz","cb","az","x","z"});
        System.out.println();
    }
}
