package HashMapandDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _500_KeyboardRow {
    private final HashMap<Character, Integer> keyboardRowMap = new HashMap<>();

    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        buildKeyboardMap();
        for (String word : words) {
            char[] wordCh = word.toCharArray();
            int row = keyboardRowMap.get(wordCh[0]);
            boolean isSameRow = true;
            for (int i = 1; i < wordCh.length; i++) {
                if (row != keyboardRowMap.get(wordCh[i])) {
                    isSameRow = false;
                    break;
                }
            }
            if (isSameRow) {
                result.add(word);
            }
        }
        //return result.toArray(new String[result.size()]);
        return result.stream().toArray(String[]::new);
    }

    private void buildKeyboardMap() {
        char[] row1 = "qwertyuiop".toCharArray();
        char[] row2 = "asdfghjkl".toCharArray();
        char[] row3 = "zxcvbnm".toCharArray();
        for (char ch : row1) {
            keyboardRowMap.put(ch, 1);
            keyboardRowMap.put(Character.toUpperCase(ch), 1);
        }
        for (char ch : row2) {
            keyboardRowMap.put(ch, 2);
            keyboardRowMap.put(Character.toUpperCase(ch), 2);
        }
        for (char ch : row3) {
            keyboardRowMap.put(ch, 3);
            keyboardRowMap.put(Character.toUpperCase(ch), 3);
        }
    }

    public static void main(String[] args) {
        _500_KeyboardRow kbr = new _500_KeyboardRow();
        String[] out = kbr.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
        out = kbr.findWords(new String[]{"omk"});
        out = kbr.findWords(new String[]{"adsdf", "sfd"});
        System.out.println();
    }

}
