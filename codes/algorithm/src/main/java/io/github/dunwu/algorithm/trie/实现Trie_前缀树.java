package io.github.dunwu.algorithm.trie;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/implement-trie-prefix-tree/">208. 实现 Trie (前缀树)</a>
 * @since 2020-06-15
 */
public class 实现Trie_前缀树 {

    public static void main(String[] args) {
        实现Trie_前缀树 trie = new 实现Trie_前缀树();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // 返回 true
        System.out.println(trie.search("app")); // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app")); // 返回 true
    }

    private TrieNode root;

    public 实现Trie_前缀树() {
        root = new TrieNode('/');
    }

    public void insert(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (p.children[index] == null) {
                TrieNode node = new TrieNode(c);
                p.children[index] = node;
            }
            p = p.children[index];
        }
        p.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        return p.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        return true;
    }

    public static class TrieNode {

        public boolean isEnd;
        public char data;
        public TrieNode[] children;

        public TrieNode(char data) {
            this.data = data;
            this.children = new TrieNode[26];
        }

    }

}
