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

        int[][] input = {
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

        int[][] input2 = { { 0, 0, 0, 0, 0, 0, 0, 0 } };
        Assertions.assertEquals(0, s.maxAreaOfIsland(input2));
    }

    static class Solution {

        private final int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        public int maxAreaOfIsland(int[][] grid) {

            // base case
            if (grid == null || grid.length == 0) return 0;

            int res = 0;
            int m = grid.length, n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        int size = dfs(grid, i, j);
                        res = Math.max(res, size);
                    }
                }
            }
            return res;
        }

        // 淹没与 (x, y) 相邻的陆地，并返回淹没的陆地面积
        public int dfs(int[][] grid, int x, int y) {
            int m = grid.length, n = grid[0].length;
            if (x < 0 || x >= m || y < 0 || y >= n) { return 0; }
            if (grid[x][y] == 0) { return 0; }

            int cnt = 1;
            grid[x][y] = 0;
            for (int[] d : directions) {
                int i = x + d[0], j = y + d[1];
                cnt += dfs(grid, i, j);
            }
            return cnt;
        }

    }

}
