package io.github.dunwu.algorithm.trie;

import java.util.concurrent.atomic.AtomicInteger;

public class Trie {

    private final AtomicInteger wordCount = new AtomicInteger(0);
    private final TrieNode root = new TrieNode('/'); // 存储无意义字符

    // 往 Trie 树中插入一个字符串
    public void insert(char[] text) {
        TrieNode p = root;
        for (char c : text) {
            int index = c - 'a';
            if (p.children[index] == null) {
                p.children[index] = new TrieNode(c);
            } else {
                p.children[index].count++;
            }
            p = p.children[index];
        }
        wordCount.getAndIncrement();
        p.isEnd = true;
    }

    // 在 Trie 树中查找一个字符串
    public boolean find(char[] pattern) {
        TrieNode p = root;
        for (int i = 0; i < pattern.length; ++i) {
            int index = pattern[i] - 'a';
            if (p.children[index] == null) {
                return false; // 不存在 pattern
            }
            p = p.children[index];
        }
        return p.isEnd;
    }

    public String longest() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            method(root.children[i], sb);
        }
        return sb.toString();
    }

    public void method(TrieNode root, StringBuilder sb) {
        if (root != null) {
            if (root.count == wordCount.get()) {
                sb.append(root.data);
                if (root.children != null) {
                    for (int i = 0; i < 26; i++) {
                        method(root.children[i], sb);
                    }
                }
            }
        }
    }

    public class TrieNode {

        public int count;
        public char data;
        public boolean isEnd = false;
        public TrieNode[] children = new TrieNode[26];

        public TrieNode(char data) {
            this.count = 1;
            this.data = data;
        }

    }

}
