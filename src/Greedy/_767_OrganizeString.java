package Greedy;

/**
 * No need to sort
 * if s is [aaabbc]
 * we first insert the most frequent element into the even indices
 * [a _ a _ a _]
 * then, we go through the entire array of character to fill in the rest part
 * [a b a b a _]
 * [a b a b a c]
 *
 * another example:
 * [aaabbccd]
 * [a _ a _ a _ _ _]
 * [a _ a _ a _ b _] -> [a b a _ a _ b _]
 * [a b a c a c b _]
 * [a b a c a c b d] -> return
 */
public class _767_OrganizeString {
    public String reorganizeString(String s) {
        char[] chars = s.toCharArray();
        int[] counts = new int[26];
        // a b c d
        // 3 3 1 2
        for (char c : chars) {
            counts[c - 'a']++;
        }

        int maxCount = 0;
        int maxFreChar = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] > maxCount) {
                if (counts[i] > (s.length() + 1) / 2) return "";

                maxFreChar = i;
                maxCount = counts[i];
            }
        }

        char[] res = new char[s.length()];
        for (int i = 0; i < maxCount; i++) {
            res[i * 2] = (char) (maxFreChar + 'a');
            counts[maxFreChar]--;
        }

        int idx = (maxCount - 1) * 2 + 2;
        // idx = idx == s.length() - 1 ? 1 : idx;

        for (int i = 0; i < 26; i++) {
            if (i == maxFreChar) continue;
            while (counts[i] > 0) {
                if (idx > s.length() - 1) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                counts[i]--;
                idx += 2;
            }
        }
        return String.valueOf(res);
    }

}
