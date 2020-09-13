/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 */
public class Trie {

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            if(!node.containsKey(w)) {
                node.put(w, new TrieNode());
            }
            node = node.get(w);
        }
        node.setEnd();
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            if(!node.containsKey(w)) {
                return null;
            }
            node = node.get(w);
        }
        return node;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    class TrieNode {

        private TrieNode[] trieNodes;

        private int R = 26;

        private boolean isEnd = false;

        public TrieNode() {
            trieNodes = new TrieNode[R];
        }

        public void put(char w, TrieNode node) {
            trieNodes[w - 'a'] = node;
        }

        public TrieNode get(char w) {
            return trieNodes[w - 'a'];
        }

        public boolean containsKey(char w) {
            return get(w) != null;
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean isEnd() {
            return this.isEnd;
        }
    }
}
