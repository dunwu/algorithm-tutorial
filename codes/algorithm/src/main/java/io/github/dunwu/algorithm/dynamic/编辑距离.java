package io.github.dunwu.algorithm.dynamic;

import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/maximum-subarray/">72. 编辑距离</a>
 * @since 2020-07-06
 */
public class 编辑距离 {

    public static void main(String[] args) {
        Assertions.assertEquals(3, minDistance("horse", "ros"));
        Assertions.assertEquals(5, minDistance("intention", "execution"));
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) dp[i][0] = i;
        for (int j = 0; j < n + 1; j++) dp[0][j] = j;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int m1 = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    int m2 = Math.min(m1, dp[i - 1][j - 1]);
                    dp[i][j] = 1 + m2;
                }
            }
        }
        return dp[m][n];
    }

}
