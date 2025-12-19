package io.github.dunwu.algorithm.dfs.island;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/count-sub-islands/">1905. 统计子岛屿</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-05
 */
public class 统计子岛屿 {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] gridA1 = {
            { 1, 1, 1, 0, 0 },
            { 0, 1, 1, 1, 1 },
            { 0, 0, 0, 0, 0 },
            { 1, 0, 0, 0, 0 },
            { 1, 1, 0, 1, 1 }
        };
        int[][] gridB1 = {
            { 1, 1, 1, 0, 0 },
            { 0, 0, 1, 1, 1 },
            { 0, 1, 0, 0, 0 },
            { 1, 0, 1, 1, 0 },
            { 0, 1, 0, 1, 0 }
        };
        Assertions.assertEquals(3, s.countSubIslands(gridA1, gridB1));

        int[][] gridA2 = {
            { 1, 0, 1, 0, 1 },
            { 1, 1, 1, 1, 1 },
            { 0, 0, 0, 0, 0 },
            { 1, 1, 1, 1, 1 },
            { 1, 0, 1, 0, 1 }
        };
        int[][] gridB2 = {
            { 0, 0, 0, 0, 0 },
            { 1, 1, 1, 1, 1 },
            { 0, 1, 0, 1, 0 },
            { 0, 1, 0, 1, 0 },
            { 1, 0, 0, 0, 1 }
        };
        Assertions.assertEquals(2, s.countSubIslands(gridA2, gridB2));
    }

    static class Solution {

        private final int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        public int countSubIslands(int[][] grid1, int[][] grid2) {
            int m = grid1.length, n = grid1[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                        // 这个岛屿肯定不是子岛，淹掉
                        dfs(grid2, i, j);
                    }
                }
            }

            int res = 0;
            // 现在 grid2 中剩下的岛屿都是子岛，计算岛屿数量
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid2[i][j] == 1) {
                        res++;
                        dfs(grid2, i, j);
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
            if (grid[x][y] == 0) { return; }

            grid[x][y] = 0;
            for (int[] d : directions) {
                int i = x + d[0], j = y + d[1];
                dfs(grid, i, j);
            }
        }

    }

}
