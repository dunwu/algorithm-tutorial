package io.github.dunwu.algorithm.dfs.island;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/number-of-islands/">200. 岛屿数量</a>
 * <p>
 * 元素不可重复，不可复选
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-04
 */
public class 岛屿数量 {

    public static void main(String[] args) {
        Solution s = new Solution();

        char[][] input = new char[][] {
            { '1', '1', '1', '1', '0' },
            { '1', '1', '0', '1', '0' },
            { '1', '1', '0', '0', '0' },
            { '0', '0', '0', '0', '0' }
        };
        Assertions.assertEquals(1, s.numIslands(input));

        char[][] input2 = new char[][] {
            { '1', '1', '0', '0', '0' },
            { '1', '1', '0', '0', '0' },
            { '0', '0', '1', '0', '0' },
            { '0', '0', '0', '1', '1' }
        };
        Assertions.assertEquals(3, s.numIslands(input2));
    }

    static class Solution {

        public int numIslands(char[][] grid) {

            if (grid == null || grid.length == 0 || grid[0].length == 0) { return 0; }

            int res = 0;
            int M = grid.length, N = grid[0].length;

            // 遍历 grid
            for (int row = 0; row < M; row++) {
                for (int column = 0; column < N; column++) {
                    if (grid[row][column] == '1') {
                        // 每发现一个岛屿，岛屿数量加一
                        res++;
                        // 然后使用 dfs 将岛屿淹了
                        dfs(grid, row, column);
                    }
                }
            }
            return res;
        }

        public void dfs(char[][] grid, int row, int column) {

            // 坐标超过边界，无效
            int M = grid.length, N = grid[0].length;
            if (row < 0 || row >= M || column < 0 || column >= N) { return; }

            // 已经是海水了
            if (grid[row][column] == '0') { return; }
            // 将 (row, column) 变成海水
            grid[row][column] = '0';

            // 淹没上下左右的陆地
            dfs(grid, row - 1, column);
            dfs(grid, row + 1, column);
            dfs(grid, row, column - 1);
            dfs(grid, row, column + 1);
        }

    }

}
