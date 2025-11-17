package io.github.dunwu.algorithm.dp.matrix;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/minimum-falling-path-sum/">931. 下降路径最小和</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-10
 */
public class 下降路径最小和 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(13, s.minFallingPathSum(new int[][] { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } }));
        Assertions.assertEquals(-59, s.minFallingPathSum(new int[][] { { -19, 57 }, { -40, -5 } }));
    }

    static class Solution {

        public int minFallingPathSum(int[][] matrix) {

            // base case
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) { return 0; }
            if (matrix.length == 1) { return matrix[0][0]; }

            // 状态定义
            int n = matrix.length;
            int[][] dp = new int[n][n];

            // 初始状态、边界状态
            for (int j = 0; j < n; j++) {
                dp[0][j] = matrix[0][j];
            }

            // 状态转移
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + matrix[i][0];
                for (int j = 1; j < n - 1; j++) {
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
                }
                dp[i][n - 1] = Math.min(dp[i - 1][n - 1], dp[i - 1][n - 2]) + matrix[i][n - 1];
            }

            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                min = Math.min(min, dp[n - 1][j]);
            }
            return min;
        }

        public int min(int a, int b, int c) {
            return Math.min(a, Math.min(b, c));
        }

    }

}
