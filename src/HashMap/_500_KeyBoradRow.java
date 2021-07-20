package HashMap;

import java.util.*;

public class _500_KeyBoradRow {
    HashMap<Character, Integer> map;
    public _500_KeyBoradRow(){
        buildMap();
    }

    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();

        for (String word : words) {
            if (isSameRow(word)) {
                list.add(word);
            }
        }
        return list.toArray(new String[list.size()]);
    }

    private void buildMap(){
        map = new HashMap<>();
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        for (char c : row1.toCharArray()) {
            map.put(c, 1);
        }
        for (char c : row2.toCharArray()) {
            map.put(c, 2);
        }
        for (char c : row3.toCharArray()) {
            map.put(c, 3);
        }
        for (char c : row1.toUpperCase().toCharArray()) {
            map.put(c, 1);
        }
        for (char c : row2.toUpperCase().toCharArray()) {
            map.put(c, 2);
        }
        for (char c : row3.toUpperCase().toCharArray()) {
            map.put(c, 3);
        }
    }

    private boolean isSameRow(String word) {
        int curRow = map.get(word.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            if (map.get(word.charAt(i)) != curRow) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _500_KeyBoradRow kbr = new _500_KeyBoradRow();
        String[] ans = kbr.findWords(new String[]{"omk"});
    }
}
