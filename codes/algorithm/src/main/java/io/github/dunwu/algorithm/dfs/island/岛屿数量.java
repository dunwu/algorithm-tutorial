package io.github.dunwu.algorithm.dfs.island;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/number-of-islands/">200. 岛屿数量</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-04
 */
public class 岛屿数量 {

    public static void main(String[] args) {
        Solution s = new Solution();

        char[][] input = {
            { '1', '1', '1', '1', '0' },
            { '1', '1', '0', '1', '0' },
            { '1', '1', '0', '0', '0' },
            { '0', '0', '0', '0', '0' }
        };
        Assertions.assertEquals(1, s.numIslands(input));

        char[][] input2 = {
            { '1', '1', '0', '0', '0' },
            { '1', '1', '0', '0', '0' },
            { '0', '0', '1', '0', '0' },
            { '0', '0', '0', '1', '1' }
        };
        Assertions.assertEquals(3, s.numIslands(input2));
    }

    static class Solution {

        private final int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) { return 0; }
            int res = 0;
            int m = grid.length, n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        // 每发现一个岛屿，岛屿数量加一
                        res++;
                        // 然后使用 DFS 将岛屿淹了
                        dfs(grid, i, j);
                    }
                }
            }
            return res;
        }

        // 淹没与 (x, y) 相邻的陆地，并返回淹没的陆地面积
        public void dfs(char[][] grid, int x, int y) {
            int m = grid.length, n = grid[0].length;
            if (x < 0 || x >= m || y < 0 || y >= n) { return; }
            if (grid[x][y] == '0') { return; }

            grid[x][y] = '0';
            for (int[] d : directions) {
                int i = x + d[0], j = y + d[1];
                dfs(grid, i, j);
            }
        }

    }

}
