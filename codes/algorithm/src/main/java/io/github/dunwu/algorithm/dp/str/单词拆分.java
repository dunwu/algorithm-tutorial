package io.github.dunwu.algorithm.dp.str;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    }

    static class Solution {

        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && set.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }

    }

}
