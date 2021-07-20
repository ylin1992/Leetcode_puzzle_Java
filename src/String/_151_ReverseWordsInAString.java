package String;

public class _151_ReverseWordsInAString {
    public static String reverseWordsInAString(String s) {
        if (s == null || s.length() == 0) return s;

        StringBuilder sb = new StringBuilder();
        String[] strings = s.trim().split("\\s+");
        for (int i = strings.length - 1; i >= 0; i--) {
            sb.append(strings[i] + " ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "   the sky is blue    ";
        System.out.println(reverseWordsInAString(s));
    }
}
