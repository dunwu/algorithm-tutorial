package io.github.dunwu.algorithm.dfs.island;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/number-of-closed-islands/">1254. 统计封闭岛屿的数目</a>
 * <p>
 * 元素不可重复，不可复选
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-04
 */
public class 统计封闭岛屿的数目 {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] input = new int[][] {
            { 1, 1, 1, 1, 1, 1, 1, 0 },
            { 1, 0, 0, 0, 0, 1, 1, 0 },
            { 1, 0, 1, 0, 1, 1, 1, 0 },
            { 1, 0, 0, 0, 0, 1, 0, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 0 }
        };
        Assertions.assertEquals(2, s.closedIsland(input));

        int[][] input2 = new int[][] {
            { 1, 1, 1, 1, 1, 1, 1 },
            { 1, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 1, 1, 1, 0, 1 },
            { 1, 0, 1, 0, 1, 0, 1 },
            { 1, 0, 1, 1, 1, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 1 },
            { 1, 1, 1, 1, 1, 1, 1 }
        };
        Assertions.assertEquals(2, s.closedIsland(input2));
    }

    static class Solution {

        public int closedIsland(int[][] grid) {

            if (grid == null || grid.length == 0 || grid[0].length == 0) { return 0; }

            int M = grid.length, N = grid[0].length;

            for (int column = 0; column < N; column++) {
                dfs(grid, 0, column);
                dfs(grid, M - 1, column);
            }

            for (int row = 0; row < M; row++) {
                dfs(grid, row, 0);
                dfs(grid, row, N - 1);
            }

            // 遍历 grid
            int res = 0;
            for (int row = 0; row < M; row++) {
                for (int column = 0; column < N; column++) {
                    if (grid[row][column] == 0) {
                        // 每发现一个岛屿，岛屿数量加一
                        res++;
                        // 然后使用 dfs 将岛屿淹了
                        dfs(grid, row, column);
                    }
                }
            }
            return res;
        }

        public void dfs(int[][] grid, int row, int column) {

            // 坐标超过边界，无效
            int M = grid.length, N = grid[0].length;
            if (row < 0 || row >= M || column < 0 || column >= N) { return; }

            // 已经是海水了
            if (grid[row][column] == 1) { return; }
            // 将 (row, column) 变成海水
            grid[row][column] = 1;

            // 淹没上下左右的陆地
            dfs(grid, row - 1, column);
            dfs(grid, row + 1, column);
            dfs(grid, row, column - 1);
            dfs(grid, row, column + 1);
        }

    }

}
