package HashMap;

import java.util.*;

public class ValidWordAbbr {
    /*
     * @param dictionary: a list of words
     */
    HashSet<String> set;
    public ValidWordAbbr(String[] dictionary) {
        // do intialization if necessary
        set = new HashSet<>();
        for (String str : dictionary) {
            String abbreviation = string2Abbreviation(str);
            if (!set.contains(abbreviation)) {
                set.add(abbreviation);
            }
        }
    }

    /*
     * @param word: a string
     * @return: true if its abbreviation is unique or false
     */
    public boolean isUnique(String word) {
        // write your code here
        return !set.contains(string2Abbreviation(word));
    }

    private String string2Abbreviation(String str) {
        if (str.length() <= 2) return str;
        int digits = str.length() - 2;
        return String.valueOf(str.charAt(0))
                + String.valueOf(digits)
                + String.valueOf(str.charAt(str.length() - 1));
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param = obj.isUnique(word);
 */
