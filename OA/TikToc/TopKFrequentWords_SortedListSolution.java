package OA.TikToc;

import java.util.*;

/**
 * Time Complexity O(nlogn) -> Sorting
 * Space Complexity O(n)
 */
public class TopKFrequentWords_SortedListSolution {
   class Solution {
      public class WordFreqComp implements Comparator<Map.Entry<String, Integer>> {
         @Override
         public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
            // smaller comes first
            if (a.getValue() == b.getValue())
               return a.getKey().compareTo(b.getKey());
            // greater comes first
            return b.getValue() - a.getValue();
         }
      }

      public List<String> topKFrequent(String[] words, int k) {
         HashMap<String, Integer> map = new HashMap<>();

         for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
         }

         List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
         Collections.sort(list, new WordFreqComp());

         List<String> res = new ArrayList<>();
         for (int i = 0; i < k; i++) {
            res.add(list.get(i).getKey());
         }
         return res;
      }
   }
}
