package io.github.dunwu.algorithm.dfs.island;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/number-of-enclaves/">1020. 飞地的数量/a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-04
 */
public class 飞地的数量 {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] input = {
            { 0, 0, 0, 0 },
            { 1, 0, 1, 0 },
            { 0, 1, 1, 0 },
            { 0, 0, 0, 0 }
        };
        Assertions.assertEquals(3, s.numEnclaves(input));

        int[][] input2 = {
            { 0, 1, 1, 0 },
            { 0, 0, 1, 0 },
            { 0, 0, 1, 0 },
            { 0, 0, 0, 0 }
        };
        Assertions.assertEquals(0, s.numEnclaves(input2));
    }

    static class Solution {

        private final int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        public int numEnclaves(int[][] grid) {

            // base case
            if (grid == null || grid.length == 0) { return 0; }

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
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        res += dfs(grid, i, j);
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
