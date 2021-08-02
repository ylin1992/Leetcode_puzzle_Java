package _Stack;
import java.util.*;
public class _224_BasicCalculator {
    public int calculate(String s) {
        // 0 1 |
        // 12
        // stack: | sum1, sign1 | sum2, sign2
        // ans = ans * sign2 + sum2 * sign1 + sum1

        // (48 + 32 - (-2 + 3) + 5)
        // sum = 79 + 5 -> 84 * +1 + 0
        // stk: 0 +1
        // sign = +1
        Stack<Integer> stk = new Stack<>();
        int sum = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                // 4 9 5
                // 0 * 10 + 4
                // 4 * 10 + 9
                // 49 * 10 + 5
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--; //this is important, (2 + 3) + 4 -> when it goes to 3, i++ no matter what the next element is, so it misses ")"
                sum += num * sign;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stk.push(sum);
                stk.push(sign);
                sum = 0;
                sign = 1;
            } else if (ch == ')') {
                // 1 - (2 + 3)
                // 1 -1 sum = 5
                sum = sum * stk.pop() + stk.pop();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String input = "(1+(4+5+2)-3)+(6+8)";
        _224_BasicCalculator bc = new _224_BasicCalculator();
        System.out.println(bc.calculate(input));
    }
}
