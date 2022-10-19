package OA.TikToc;

import java.util.*;

public class TopKFrequentWords_MinHeapSolution {
   public class WordFreqComp implements Comparator<Map.Entry<String, Integer>> {
      @Override
      public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
         // smaller comes first
         if (a.getValue() == b.getValue())
            return b.getKey().compareTo(a.getKey());
         // smaller comes first, since we are implementing minHeap
         return a.getValue() - b.getValue();
      }
   }

   public List<String> topKFrequent(String[] words, int k) {
      HashMap<String, Integer> map = new HashMap<>();

      for (String word : words) {
         map.put(word, map.getOrDefault(word, 0) + 1);
      }

      WordFreqComp comp = new WordFreqComp();
      PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(comp);
      for (Map.Entry<String, Integer> e : map.entrySet()) {
         if (pq.size() < k) {
            pq.offer(e);
         } else {
            // if e is greater than the min element in pq
            if (comp.compare(e, pq.peek()) > 0) {
               pq.poll();
               pq.offer(e);
            }
         }
      }
      List<String> res = new ArrayList<>();
      for (int i = 0; i < k; i++) {
         // smallest gets popped out first, but we want the largest k-th elements
         res.add(0, pq.poll().getKey());
      }
      return res;
   }

}
