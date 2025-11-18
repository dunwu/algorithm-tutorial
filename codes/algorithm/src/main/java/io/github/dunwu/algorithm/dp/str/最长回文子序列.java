package io.github.dunwu.algorithm.dp.str;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/longest-palindromic-subsequence/">516. 最长回文子序列</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-10
 */
public class 最长回文子序列 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(4, s.longestPalindromeSubseq("bbbab"));
        Assertions.assertEquals(2, s.longestPalindromeSubseq("v"));
    }

    static class Solution {

        public int longestPalindromeSubseq(String s) {
            int n = s.length();
            int[][] dp = new int[n][n];
            for (int i = n - 1; i >= 0; i--) {
                dp[i][i] = 1;
                for (int j = i + 1; j < n; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[0][n - 1];
        }

    }

}
