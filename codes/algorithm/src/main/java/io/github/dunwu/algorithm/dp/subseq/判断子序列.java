package io.github.dunwu.algorithm.dp.subseq;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/is-subsequence/">392. 判断子序列</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-06
 */
public class 判断子序列 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertTrue(s.isSubsequence("abc", "ahbgdc"));
        Assertions.assertFalse(s.isSubsequence("axc", "ahbgdc"));
        Assertions.assertTrue(s.isSubsequence("", "ahbgdc"));
        Assertions.assertFalse(s.isSubsequence("aaaaaa", "bbaaaa"));
    }

    static class Solution {

        public boolean isSubsequence(String s, String t) {
            int m = s.length(), n = t.length();

            // dp[i][j] 表示 s 的前 i 个字符是否是 t 的前 j 个字符的子序列
            boolean[][] dp = new boolean[m + 1][n + 1];

            // 初始化：空字符串是任何字符串的子序列
            for (int j = 0; j <= n; j++) {
                dp[0][j] = true;
            }

            // 动态规划填表
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        // 字符匹配，取决于前一个状态
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        // 字符不匹配，只能尝试在 t 中继续寻找
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }

            return dp[m][n];
        }

    }

}
