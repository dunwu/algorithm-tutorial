package io.github.dunwu.algorithm.dfs.island;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/number-of-enclaves/">1020. 飞地的数量/a>
 * <p>
 * 元素不可重复，不可复选
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-04
 */
public class 飞地的数量 {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] input = new int[][] {
            { 0, 0, 0, 0 },
            { 1, 0, 1, 0 },
            { 0, 1, 1, 0 },
            { 0, 0, 0, 0 }
        };
        Assertions.assertEquals(3, s.numEnclaves(input));

        int[][] input2 = new int[][] {
            { 0, 1, 1, 0 },
            { 0, 0, 1, 0 },
            { 0, 0, 1, 0 },
            { 0, 0, 0, 0 }
        };
        Assertions.assertEquals(0, s.numEnclaves(input2));
    }

    static class Solution {

        public int numEnclaves(int[][] grid) {

            int M = grid.length, N = grid[0].length;
            for (int i = 0; i < M; i++) {
                dfs(grid, i, 0);
                dfs(grid, i, N - 1);
            }
            for (int i = 0; i < N; i++) {
                dfs(grid, 0, i);
                dfs(grid, M - 1, i);
            }

            int res = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == 1) {
                        res++;
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
            if (grid[row][column] == 0) { return; }
            // 将 (row, column) 变成海水
            grid[row][column] = 0;

            // 淹没上下左右的陆地
            dfs(grid, row - 1, column);
            dfs(grid, row + 1, column);
            dfs(grid, row, column - 1);
            dfs(grid, row, column + 1);
        }

    }

}
