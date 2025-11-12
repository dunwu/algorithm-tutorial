package io.github.dunwu.algorithm.dfs.island;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/max-area-of-island/">695. 岛屿的最大面积</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-05
 */
public class 岛屿的最大面积 {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] input = new int[][] {
            { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
            { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
            { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }
        };
        Assertions.assertEquals(6, s.maxAreaOfIsland(input));

        int[][] input2 = new int[][] {
            { 0, 0, 0, 0, 0, 0, 0, 0 }
        };
        Assertions.assertEquals(0, s.maxAreaOfIsland(input2));
    }

    static class Solution {

        public int maxAreaOfIsland(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) { return 0; }

            int max = 0;
            int M = grid.length, N = grid[0].length;
            for (int row = 0; row < M; row++) {
                for (int column = 0; column < N; column++) {
                    max = Math.max(max, dfs(grid, row, column));
                }
            }
            return max;
        }

        public int dfs(int[][] grid, int row, int column) {

            // 坐标超过边界，无效
            int M = grid.length, N = grid[0].length;
            if (row < 0 || row >= M || column < 0 || column >= N) { return 0; }

            // 已经是海水了
            if (grid[row][column] == 0) { return 0; }
            // 将 (row, column) 变成海水
            grid[row][column] = 0;

            // 淹没上下左右的陆地
            return 1 + dfs(grid, row - 1, column)
                + dfs(grid, row + 1, column)
                + dfs(grid, row, column - 1)
                + dfs(grid, row, column + 1);
        }

    }

}
