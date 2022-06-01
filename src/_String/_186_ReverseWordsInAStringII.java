package _String;

/**
 * Reverse the entire array
 * and for each word separated by ' ', flip it again
 * using two pointers
 */
public class _186_ReverseWordsInAStringII {
    public static char[] reverseWordsInAString(char[] ch) {
        reverseWord(ch, 0, ch.length - 1);
        System.out.println(ch);
        int p = 0;
        while (p < ch.length) {
            int q = p;
            while (p < ch.length && ch[p] != ' ') {
                p++;
            }
            reverseWord(ch, q, p - 1); // need to -1, because p is on the ' ' index
            p++;
        }
        return ch;
    }

    private static void reverseWord(char[] chars, int i, int j) {
        while (i < j) {
            char tmp = chars[i];
            chars[i++] = chars[j];
            chars[j--] = tmp;
        }
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        char[] ch = new char[]{'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's'};
        System.out.println(reverseWordsInAString(ch));
    }
}
