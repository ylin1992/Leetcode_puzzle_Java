package Trie;

public class _208_ImplementTrie {
    class Node {
        public Node[] children;
        public boolean isWord;

        public Node() {
            children = new Node[26];
            isWord = false;
        }
    }

    private Node root;
    public _208_ImplementTrie() {
        root = new Node();
    }

    public void insert(String word) {
        insert(word.toCharArray(), 0, root);
    }

    private void insert(char[] cword, int start, Node root) {
        if (start == cword.length - 1) {
            if (root.children[cword[start] - 'a'] == null) {
                root.children[cword[start] - 'a'] = new Node();
            }
            root.children[cword[start] - 'a'].isWord = true;
            return;
        }
        System.out.println(cword[start] + " " + start);
        if (root.children[cword[start] - 'a'] == null) {
            root.children[cword[start] - 'a'] = new Node();
        }
        insert(cword, start + 1, root.children[cword[start] - 'a']);
    }

    public boolean search(String word) {
        return search(word.toCharArray(), 0, root);
    }

    private boolean search(char[] cword, int index, Node root) {
        if (root == null) {
            return false;
        }

        if (index == cword.length) {
            return false;
        }

        if (index == cword.length - 1 && root.children[cword[index] - 'a'] != null &&  root.children[cword[index] - 'a'].isWord) {
            return true;
        }

        boolean contains = false;
        if (root.children[cword[index] - 'a'] != null) {
            contains = contains || search(cword, index + 1, root.children[cword[index] - 'a']);
        }
        return contains;
    }

    public boolean startsWith(String prefix) {
        return startsWith(prefix.toCharArray(), 0, root);
    }

    private boolean startsWith(char[] cword, int index, Node root) {
        if (root == null) {
            return false;
        }

        if (index == cword.length) {
            return false;
        }

        if (index == cword.length - 1 && root.children[cword[index] - 'a'] != null) {
            return true;
        }

        boolean contains = false;
        if (root.children[cword[index] - 'a'] != null) {
            contains = contains || startsWith(cword, index + 1, root.children[cword[index] - 'a']);
        }
        return contains;
    }

    public static void main(String[] args) {
        _208_ImplementTrie trie = new _208_ImplementTrie();
        trie.insert("apple");
        trie.search("apple");
    }
}
