package BitwiseOperation;

public class _389_FindTheDifference {
    public char findTheDifference(String s, String t) {
        char[] chS = s.toCharArray();
        char[] chT = t.toCharArray();
        char res = 0;
        for (int i = 0; i < chS.length; i++) {
            res ^= chT[i];
            res ^= chS[i];
        }
        return (char) (res ^ chT[chT.length - 1]);
    }

    public char findTheDifference2(String s, String t) {
        char res = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            res ^= t.charAt(i);
            res ^= s.charAt(i);
        }
        return res;
    }

    public static void main(String[] args) {
        _389_FindTheDifference ftd = new _389_FindTheDifference();
        System.out.println(ftd.findTheDifference2("abcd", "abcde"));
        System.out.println(ftd.findTheDifference2("", "y"));
        System.out.println(ftd.findTheDifference2("a", "aa"));
    }
}
