package _Array;
import java.util.*;
public class _245_ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        // Write your code here
        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<>());
            }
            map.get(words[i]).add(i);
        }

        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);

        int i = 0;
        int j = 0;
        int minDist = Integer.MAX_VALUE;
        // 1 4
        // 1 4
        while (i < list1.size() && j < list2.size()) {
            int idx1 = list1.get(i);
            int idx2 = list2.get(j);
            if (idx1 == idx2 && word1 == word2) {
                i++;
                continue;
            }
            minDist = Math.min(Math.abs(idx1 - idx2), minDist);
            if (i > j) {
                j++;
            } else {
                i++;
            }
        }
        return minDist;
    }

    public static void main(String[] args) {

    }
}
