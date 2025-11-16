package io.github.dunwu.algorithm.dp.matrix;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/unique-paths/">62. 不同路径</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-12
 */
public class 不同路径2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] input1 = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        Assertions.assertEquals(2, s.uniquePathsWithObstacles(input1));
        int[][] input2 = new int[][] { { 0, 1 }, { 0, 0 } };
        Assertions.assertEquals(1, s.uniquePathsWithObstacles(input2));
        int[][] input3 = new int[][] { { 1, 0 } };
        Assertions.assertEquals(0, s.uniquePathsWithObstacles(input3));
        int[][] input4 = new int[][] { { 0, 1, 0, 0 } };
        Assertions.assertEquals(0, s.uniquePathsWithObstacles(input4));
    }

    static class Solution {

        public int uniquePathsWithObstacles(int[][] obstacleGrid) {

            // 基本校验
            if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) { return 0; }
            int m = obstacleGrid.length, n = obstacleGrid[0].length;
            // 起点、终点有障碍，注定无法到达
            if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) { return 0; }

            // 状态定义
            int[][] dp = new int[m][n];

            // 初始化、边界状态
            dp[0][0] = 1;
            for (int i = 1; i < m; i++) { dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0]; }
            for (int j = 1; j < n; j++) { dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j - 1]; }

            // 状态转移
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
            return dp[m - 1][n - 1];
        }

    }

}
