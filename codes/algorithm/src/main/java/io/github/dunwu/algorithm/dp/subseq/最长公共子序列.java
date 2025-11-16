package io.github.dunwu.algorithm.dp.subseq;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/longest-common-subsequence/">1143. 最长公共子序列</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-10
 */
public class 最长公共子序列 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(3, s.longestCommonSubsequence("abcde", "ace"));
        Assertions.assertEquals(3, s.longestCommonSubsequence("abc", "abc"));
        Assertions.assertEquals(0, s.longestCommonSubsequence("abc", "def"));
    }

    static class Solution {

        private int[][] memo;

        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length(), n = text2.length();
            memo = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                Arrays.fill(memo[i], -1);
            }
            return dp(text1, 0, text2, 0);
        }

        public int dp(String text1, int i, String text2, int j) {
            if (i < 0 || i >= text1.length() || j < 0 || j >= text2.length()) { return 0; }
            if (memo[i][j] != -1) { return memo[i][j]; }
            if (text1.charAt(i) == text2.charAt(j)) {
                memo[i][j] = dp(text1, i + 1, text2, j + 1) + 1;
            } else {
                memo[i][j] = max(
                    dp(text1, i + 1, text2, j),
                    dp(text1, i, text2, j + 1),
                    dp(text1, i + 1, text2, j + 1)
                );
            }
            return memo[i][j];
        }

        public int max(int a, int b, int c) {
            return Math.max(a, Math.max(b, c));
        }

    }

}
