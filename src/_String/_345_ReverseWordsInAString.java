package _String;

public class _345_ReverseWordsInAString {
    public static String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            while (i < s.length() && !isVowel(s.charAt(i))) {
                i++;
            }
            while (j >= 0 && !isVowel(s.charAt(j))) {
                j--;
            }
            if (i < j) {
                char tmp = chars[i];
                chars[i++] = chars[j];
                chars[j++] = tmp;
            }
        }
        return String.valueOf(chars);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U';
    }

    public static void main(String[] args) {
        String s = "hello";
        String ans  = reverseVowels(s);
    }
}
