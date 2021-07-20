package HashMap;

import java.util.HashMap;

public class _288_ValidWordAbbr2 {
    HashMap<String, String> map;

    public void validWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for (String word : dictionary) {
            String key = convertWordToAbbr(word);
            if (map.containsKey(key)) {
                if (map.get(key).equals(word)) {
                    // "deer", "door"
                    // -> map("d2r", "")
                    // special implicit test case
                    map.put(key, "");
                }
            } else {
                map.put(key, word);
            }
        }
    }

    public boolean isUnique(String word) {
        return !map.containsKey(convertWordToAbbr(word)) || map.get(convertWordToAbbr(word)).equals(word);
    }

    private String convertWordToAbbr(String word) {
        if (word.length() <= 2) return word;
        String out = String.valueOf(word.charAt(0));
        out += String.valueOf(word.length() - 2);
        out += String.valueOf(word.charAt(word.length() - 1));
        return out;
    }

}
