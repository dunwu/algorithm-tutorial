package io.github.dunwu.algorithm.trie;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-15
 */
public class 最长公共前缀 {

    public static void main(String[] args) {
        longestCommonPrefix("flower", "flow", "flight");
    }

    public static String longestCommonPrefix(String... strs) {
        Trie trie = new Trie();
        for (String s : strs) {
            trie.insert(s.toCharArray());
        }
        return trie.longest();
    }

}
