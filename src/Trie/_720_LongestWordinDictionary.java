package Trie;

/**
 * Create a Trie, since we want to return a string, in order to prevent from
 * taking redundant time converting StringBuilder to String, we modify the Trie
 * so that it contains a string, if the string is null, the node is a word present
 * in the dict, otherwise there is no word ending at that node present in the dict.
 *
 * Then we perform dfs, if the node we are visiting contains null of word, we skip it.
 * And then we keep running dfs until we reach the end
 */
public class _720_LongestWordinDictionary {
   public String longestWord(String[] words) {
      StringTrie root = constructTrie(words);
      return dfs(root);
   }

   private String dfs(StringTrie root) {
      if (root == null) return "";
      String longest = root.word == null ? "" : root.word;
      for (int i = 0; i < root.children.length; i++) {
         if (root.children[i] != null && root.children[i].word != null) {
            String returned = dfs(root.children[i]);
            if (returned.length() > longest.length()) {
               longest = returned;
            } else if (returned.length() == longest.length()) {
               longest = returned.compareTo(longest) > 0 ? longest : returned;
            }
         }
      }
      return longest;
   }


   private StringTrie constructTrie(String[] words) {
      StringTrie root = new StringTrie();
      for (String word : words) {
         StringTrie cur = root;
         for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
               cur.children[c - 'a'] = new StringTrie();
            }
            cur = cur.children[c - 'a'];
         }
         cur.word = word;
      }
      return root;
   }
}

class StringTrie {
   StringTrie[] children = new StringTrie[26];
   String word = null;
}

