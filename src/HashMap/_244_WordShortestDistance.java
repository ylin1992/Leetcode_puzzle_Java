package HashMap;

import java.util.*;
public class _244_WordShortestDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        // Write your code here
        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i],new ArrayList<Integer>());
            }
            map.get(words[i]).add(i);
        }
        // list 1 and list 2 are all sorted
        // 8 9 10
        // 3 4 7
        int min = Integer.MAX_VALUE;
        int p = 0, q = 0;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        for (int i = 0; i < list1.size(); i++) {
            int index1 = list1.get(i);
            for (int j = 0; j < list2.size(); j++) {
                int index2 = list2.get(j);
                if (index1 != index2) {
                    min = Math.min(Math.abs(list1.get(i) - list2.get(j)), min);
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"a","b","c","d","d"};
        _244_WordShortestDistance wsd = new _244_WordShortestDistance();
        System.out.println(wsd.shortestDistance(words, "a", "d"));
    }
}
