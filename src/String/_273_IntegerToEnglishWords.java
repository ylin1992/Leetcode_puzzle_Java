package String;

public class _273_IntegerToEnglishWords {
    private String[] underTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] tens = {"", "","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String ans = "";
        int idx = 0;
        while (num > 0) { //  12,345,678
            if (num % 1000 != 0) {
                ans = helper(num % 1000) + thousands[idx] + " " + ans;
            }
            idx++;
            num /= 1000;
        }
        return ans.trim();
    }
    private String helper(int num) {
        if (num == 0) {
            return "";
        }
        if (num < 20) {
            return underTwenty[num] + " ";
        }
        if (num < 100) {
            return tens[num / 10] + " " + helper(num % 10); // 67 -> Sixty + " " + helper(7) = Sixty + " " + Seven
        } else { // 101 ~ 999
            return underTwenty[num / 100] + " Hundred " + helper(num % 100);
        }
    }

    public static void main(String[] args) {
        _273_IntegerToEnglishWords i2w = new _273_IntegerToEnglishWords();
        System.out.println(i2w.numberToWords(1000000));
        System.out.println(i2w.numberToWords(50868));
        System.out.println(i2w.numberToWords(12));
        System.out.println(i2w.numberToWords(1));
    }
}
