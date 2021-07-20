package _String;

import java.util.HashMap;

public class _12_IntegerToRoman {
    private int[] nums;
    private String[] roman;
    public _12_IntegerToRoman(){
        nums = new int[]{1000, 900, 500, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    }
    // 1933 -> M CM XXX III
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            while (num >= nums[i]) {
                num -= nums[i];
                sb.append(roman[i]);
            }
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _12_IntegerToRoman i2r = new _12_IntegerToRoman();
        System.out.println(i2r.intToRoman(3));
    }
}
