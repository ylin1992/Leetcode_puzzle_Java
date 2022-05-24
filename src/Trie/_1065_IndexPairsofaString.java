package Trie;

import java.util.ArrayList;
import java.util.List;

public class _1065_IndexPairsofaString {
   public int[][] indexPairs(String text, String[] words) {
      Trie trie = constructTrie(words);
      List<int[]> res = new ArrayList<>();

      int j = 0;
      for (int i = 0; i < text.length(); i++) {
         Trie r = trie;
         if (r.children[text.charAt(i) - 'a'] != null) {
            j = i;
            while (j < text.length() && r.children[text.charAt(j) - 'a'] != null) {
               r = r.children[text.charAt(j) - 'a'];
               if (r.isWord == true) {
                  res.add(new int[] {i, j});
               }
               j++;
            }
         }
      }

      int[][] returned = new int[res.size()][2];
      for (int i = 0; i < res.size(); i++) {
         returned[i][0] = res.get(i)[0];
         returned[i][1] = res.get(i)[1];
      }
      return returned;
   }

   private Trie constructTrie(String[] words) {
      Trie trie = new Trie();
      Trie cur = trie;
      for (String word : words) {
         cur = trie;
         for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
               cur.children[c - 'a'] = new Trie();
            }
            cur = cur.children[c - 'a'];
         }
         cur.isWord = true;
      }
      return trie;
   }
}
class Trie {
   public Trie[] children;
   public boolean isWord;
   public Trie() {
      children = new Trie[26];
      isWord = false;
   }
}