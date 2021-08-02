package _Array;
import java.util.*;
public class _299_BullsAndCows {
    public String getHint(String secret, String guess) {
        // Map: Key = digit appears in secret, Val = count of the digit (without counting A)
        // Set: index of the digits whose index are the same
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        int A = 0;
        int B = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
                set.add(i);
            } else {
                char c = secret.charAt(i);
                if (!map.containsKey(c)) {
                    map.put(c, 0);
                }
                map.put(c, map.get(c) + 1);
            }
        }
        // 1 1 2 3
        // 0 1 1 1  -> 1A

        // set : 1
        // map : <'1', 1>

        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            if (map.containsKey(c) && map.get(c) > 0 && !set.contains(i)) {
                B++;
                map.put(c, map.get(c) - 1);
            }
        }
        return String.valueOf(A) + "A" + String.valueOf(B) + "B";

    }

    public String getHint2(String secret, String guess) {
        int a = 0;
        int b = 0;
        int[] digitCount = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                a++;
            } else {
                if (digitCount[s - '0']++ < 0) {
                    b++;
                }
                if (digitCount[g - '0']-- > 0) {
                    b++;
                }
            }
        }
        return String.valueOf(a) + "A" + String.valueOf(b) + "B";
    }

    public static void main(String[] args) {
        _299_BullsAndCows bac = new _299_BullsAndCows();
        System.out.println(bac.getHint2("1123", "0111"));
    }

}
