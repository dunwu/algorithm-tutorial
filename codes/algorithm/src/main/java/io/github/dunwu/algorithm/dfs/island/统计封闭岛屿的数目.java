package io.github.dunwu.algorithm.dfs.island;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/number-of-closed-islands/">1254. 统计封闭岛屿的数目</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-04
 */
public class 统计封闭岛屿的数目 {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] input = {
            { 1, 1, 1, 1, 1, 1, 1, 0 },
            { 1, 0, 0, 0, 0, 1, 1, 0 },
            { 1, 0, 1, 0, 1, 1, 1, 0 },
            { 1, 0, 0, 0, 0, 1, 0, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 0 }
        };
        Assertions.assertEquals(2, s.closedIsland(input));

        int[][] input2 = {
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

        private final int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        public int closedIsland(int[][] grid) {

            // base case
            if (grid == null || grid.length == 0) { return 0; }

            // 将靠边的岛屿淹没
            int m = grid.length, n = grid[0].length;
            for (int j = 0; j < n; j++) {
                dfs(grid, 0, j);
                dfs(grid, m - 1, j);
            }
            for (int i = 0; i < m; i++) {
                dfs(grid, i, 0);
                dfs(grid, i, n - 1);
            }

            int res = 0;
            // 遍历 grid，剩下的岛屿都是封闭岛屿
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        res++;
                        dfs(grid, i, j);
                    }
                }
            }
            return res;
        }

        // 淹没与 (x, y) 相邻的陆地，并返回淹没的陆地面积
        public void dfs(int[][] grid, int x, int y) {
            // base case
            int m = grid.length, n = grid[0].length;
            if (x < 0 || x >= m || y < 0 || y >= n) { return; }
            if (grid[x][y] == 1) { return; }

            grid[x][y] = 1;
            for (int[] d : directions) {
                int i = x + d[0], j = y + d[1];
                dfs(grid, i, j);
            }
        }

    }

}
