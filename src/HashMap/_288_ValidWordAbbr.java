package HashMapandDesign;

import java.util.HashSet;

public class _288_ValidWordAbbr {
    HashSet<String> set;

    public void validWordAbbr(String[] dictionary) {
        set = new HashSet<>();
        for (String word : dictionary) {
            set.add(convertWordToAbbr(word));
        }
    }

    public boolean isUnique(String word) {
        return !set.contains(convertWordToAbbr(word)) || word.length() == 2 || word.length() == 1;
    }

    private String convertWordToAbbr(String word) {
        if (word.length() <= 2) return word;
        String out = String.valueOf(word.charAt(0));
        out += String.valueOf(word.length() - 2);
        out += String.valueOf(word.charAt(word.length() - 1));
        return out;
    }

    public static void main(String[] args) {
        _288_ValidWordAbbr vwa = new _288_ValidWordAbbr();
        vwa.validWordAbbr(new String[]{"deer", "door", "cake", "card"});
        System.out.println(vwa.isUnique("dear"));
        System.out.println(vwa.isUnique("cart"));
        System.out.println(vwa.isUnique("cane"));
        System.out.println(vwa.isUnique("make"));
        vwa.validWordAbbr(new String[]{"a", "ab"});
        boolean ans = vwa.isUnique("a");


    }
}
