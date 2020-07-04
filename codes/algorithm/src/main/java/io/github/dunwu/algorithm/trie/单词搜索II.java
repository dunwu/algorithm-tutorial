package io.github.dunwu.algorithm.trie;

import org.junit.jupiter.api.Assertions;

import java.util.*;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-04
 */
public class 单词搜索II {

    Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        String[] words = { "oath", "pea", "eat", "rain" };
        char[][] board = {
            { 'o', 'a', 'a', 'n' },
            { 'e', 't', 'a', 'e' },
            { 'i', 'h', 'k', 'r' },
            { 'i', 'f', 'l', 'v' }
        };

        单词搜索II demo = new 单词搜索II();
        List<String> result = demo.findWords(board, words);
        Assertions.assertArrayEquals(Arrays.asList("oath", "eat").toArray(), result.toArray());
    }

    // 利用字典树来进行单词搜索
    public List<String> findWords(char[][] board, String[] words) {

        if (board == null || board.length == 0
            || words == null || words.length == 0) { return new ArrayList<>(set); }

        // 初始化字典树
        Trie trie = new Trie();
        for (String w : words) {
            trie.insert(w);
        }

        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(board, visited, trie, "", i, j);
            }
        }

        return new ArrayList<>(set);
    }

    public void dfs(char[][] board, boolean[][] visited, Trie trie, String str, int x, int y) {
        // 数组越界，扫描退出
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) { return;}
        // 已扫描过，则退出
        if (visited[x][y]) return;

        // 拼接字符串，然后在字典树中查找，如果找到 word，添加到目标 list
        // visited[x][y] 已被扫描过，置为 true
        str += board[x][y];
        if (!trie.startsWith(str)) return;
        if (trie.search(str)) set.add(str);
        visited[x][y] = true;

        // 基于当前位置，向四个方向展开 DFS 搜索
        dfs(board, visited, trie, str, x + 1, y);
        dfs(board, visited, trie, str, x - 1, y);
        dfs(board, visited, trie, str, x, y + 1);
        dfs(board, visited, trie, str, x, y - 1);

        // 重置 visited[x][y] 为 false
        visited[x][y] = false;
    }

    public static class Trie {

        private TrieNode root;
        public static final int MAX_WORD_COUNT = 26;

        public Trie() {
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

        static class TrieNode {

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

}
