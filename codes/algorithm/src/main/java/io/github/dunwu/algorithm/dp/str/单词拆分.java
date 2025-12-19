package io.github.dunwu.algorithm.dp.str;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/word-break/">139. 单词拆分</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-10
 */
public class 单词拆分 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertTrue(s.wordBreak("leetcode", Arrays.asList("leet", "code")));
        Assertions.assertTrue(s.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        Assertions.assertFalse(s.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));

        Solution2 s2 = new Solution2();
        Assertions.assertTrue(s2.wordBreak("leetcode", Arrays.asList("leet", "code")));
        Assertions.assertTrue(s2.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        Assertions.assertFalse(s2.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }

    // 回溯解决方案
    static class Solution {

        // 记录是否找到一个合法的答案
        boolean found = false;
        // 记录回溯算法的路径
        private LinkedList<String> path;

        public boolean wordBreak(String s, List<String> wordDict) {
            found = false;
            path = new LinkedList<>();
            backtrack(wordDict, s, 0);
            return found;
        }

        public void backtrack(List<String> wordDict, String target, int start) {

            // 找到一个合法答案
            if (start == target.length()) { found = true; }
            // 如果已经找到答案，就不要再递归搜索了
            if (found) { return; }

            // 回溯算法框架
            for (String word : wordDict) {

                int len = word.length();

                // 无效情况，剪枝
                if (start + len > target.length()) { return; }
                if (!target.substring(start, start + len).equals(word)) { continue; }

                // 【选择】
                path.add(word);
                // 【回溯】
                backtrack(wordDict, target, start + len);
                // 【取消选择】
                path.remove(path.size() - 1);
            }
        }

    }

    static class Solution2 {

        // 备忘录，-1 代表未计算，0 代表无法凑出，1 代表可以凑出
        private int[] memo;
        // 用哈希集合方便快速判断是否存在
        HashSet<String> wordDict;

        public boolean wordBreak(String s, List<String> wordDict) {
            this.wordDict = new HashSet<>(wordDict);
            this.memo = new int[s.length()];
            Arrays.fill(memo, -1);
            return dp(s, 0);
        }

        public boolean dp(String s, int index) {
            // base case
            if (index == s.length()) { return true; }
            // 避免冗余
            if (memo[index] != -1) { return memo[index] == 0 ? false : true; }

            // 遍历 s[i..] 的所有前缀
            for (int len = 1; index + len <= s.length(); len++) {
                // 看看哪些前缀存在 wordDict 中
                String prefix = s.substring(index, index + len);
                if (wordDict.contains(prefix)) {
                    // 找到一个单词匹配 s[i..i+len)
                    // 只要 s[i+len..] 可以被拼出，s[i..] 就能被拼出
                    if (dp(s, index + len)) {
                        memo[index] = 1;
                        return true;
                    }
                }
            }
            // s[i..] 无法被拼出
            memo[index] = 0;
            return false;
        }

    }

}
