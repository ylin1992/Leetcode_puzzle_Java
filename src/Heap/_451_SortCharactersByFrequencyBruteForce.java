package Heap;
import java.util.*;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class _451_SortCharactersByFrequencyBruteForce {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        // O(n)
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());

        // O(lgm) m = numbers of character, it is constant
        for (Map.Entry<Character, Integer> en : map.entrySet()) {
            pq.offer(en);
        }

        // O(n)
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> en = pq.poll();
            for (int i = 0; i < en.getValue(); i++) {
                sb.append(en.getKey());
            }
        }
        return sb.toString();
    }

}
