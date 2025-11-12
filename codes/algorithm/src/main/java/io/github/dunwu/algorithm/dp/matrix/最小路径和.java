package io.github.dunwu.algorithm.dp.matrix;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/minimum-path-sum/">64. 最小路径和</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-10
 */
public class 最小路径和 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(7, s.minPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }));
        Assertions.assertEquals(12, s.minPathSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }));
    }

    static class Solution {

        public int minPathSum(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) { return 0; }
            int m = grid.length, n = grid[0].length;
            int[][] dp = new int[m][n];
            dp[0][0] = grid[0][0];
            for (int i = 1; i < m; i++) { dp[i][0] = dp[i - 1][0] + grid[i][0]; }
            for (int j = 1; j < n; j++) { dp[0][j] = dp[0][j - 1] + grid[0][j]; }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }
            }
            return dp[m - 1][n - 1];
        }

    }

}
