package io.github.dunwu.algorithm.dp.matrix;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/unique-paths/">62. 不同路径</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-12
 */
public class 不同路径 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(28, s.uniquePaths(3, 7));
        Assertions.assertEquals(3, s.uniquePaths(3, 2));
    }

    static class Solution {

        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            // 沿着边界只有一个前进方向
            for (int i = 0; i < m; i++) { dp[i][0] = 1; }
            for (int j = 0; j < n; j++) { dp[0][j] = 1; }
            // dp[i][j] 表示到达 (i, j) 的最多路径
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }

    }

}
