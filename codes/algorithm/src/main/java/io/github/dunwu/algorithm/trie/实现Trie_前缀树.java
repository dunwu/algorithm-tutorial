package io.github.dunwu.algorithm.trie;

import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/implement-trie-prefix-tree/">208. 实现 Trie (前缀树)</a>
 * @since 2020-06-15
 */
public class 实现Trie_前缀树 {

    public static void main(String[] args) {
        实现Trie_前缀树 trie = new 实现Trie_前缀树();
        trie.insert("apple");
        Assertions.assertTrue(trie.search("apple"));
        Assertions.assertFalse(trie.search("app"));
        Assertions.assertTrue(trie.startsWith("app"));

        trie.insert("app");
        Assertions.assertTrue(trie.search("app"));
    }

    private TrieNode root;
    public static final int MAX_WORD_COUNT = 26;

    public 实现Trie_前缀树() {
        root = new TrieNode('/');
    }

    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }

        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode(c);
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }

        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }

    public static class TrieNode {

        boolean isEnd;
        char data;
        TrieNode[] children;

        public TrieNode(char data) {
            this(data, false);
        }

        public TrieNode(char data, boolean isEnd) {
            this.data = data;
            this.isEnd = isEnd;
            children = new TrieNode[MAX_WORD_COUNT];
        }

    }

}
