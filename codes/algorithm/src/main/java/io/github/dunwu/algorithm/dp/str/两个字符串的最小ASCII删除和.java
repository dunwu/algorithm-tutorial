package io.github.dunwu.algorithm.dp.str;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/minimum-ascii-delete-sum-for-two-strings/">712. 两个字符串的最小ASCII删除和</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-06
 */
public class 两个字符串的最小ASCII删除和 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(231, s.minimumDeleteSum("sea", "eat"));
        Assertions.assertEquals(403, s.minimumDeleteSum("delete", "leet"));
    }

    static class Solution {

        public int minimumDeleteSum(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                dp[i][0] = dp[i - 1][0] + s1.codePointAt(i - 1);
            }
            for (int j = 1; j <= n; j++) {
                dp[0][j] = dp[0][j - 1] + s2.codePointAt(j - 1);
            }
            for (int i = 1; i <= m; i++) {
                int code1 = s1.codePointAt(i - 1);
                for (int j = 1; j <= n; j++) {
                    int code2 = s2.codePointAt(j - 1);
                    if (code1 == code2) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j] + code1, dp[i][j - 1] + code2);
                    }
                }
            }
            return dp[m][n];
        }

    }

}
