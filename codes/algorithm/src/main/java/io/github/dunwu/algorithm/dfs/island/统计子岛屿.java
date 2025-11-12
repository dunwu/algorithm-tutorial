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

        int[][] gridA1 = new int[][] {
            { 1, 1, 1, 0, 0 },
            { 0, 1, 1, 1, 1 },
            { 0, 0, 0, 0, 0 },
            { 1, 0, 0, 0, 0 },
            { 1, 1, 0, 1, 1 }
        };
        int[][] gridB1 = new int[][] {
            { 1, 1, 1, 0, 0 },
            { 0, 0, 1, 1, 1 },
            { 0, 1, 0, 0, 0 },
            { 1, 0, 1, 1, 0 },
            { 0, 1, 0, 1, 0 }
        };
        Assertions.assertEquals(3, s.countSubIslands(gridA1, gridB1));

        int[][] gridA2 = new int[][] {
            { 1, 0, 1, 0, 1 },
            { 1, 1, 1, 1, 1 },
            { 0, 0, 0, 0, 0 },
            { 1, 1, 1, 1, 1 },
            { 1, 0, 1, 0, 1 }
        };
        int[][] gridB2 = new int[][] {
            { 0, 0, 0, 0, 0 },
            { 1, 1, 1, 1, 1 },
            { 0, 1, 0, 1, 0 },
            { 0, 1, 0, 1, 0 },
            { 1, 0, 0, 0, 1 }
        };
        Assertions.assertEquals(2, s.countSubIslands(gridA2, gridB2));
    }

    static class Solution {

        public int countSubIslands(int[][] gridA, int[][] gridB) {
            int M = gridB.length, N = gridB[0].length;
            for (int row = 0; row < M; row++) {
                for (int column = 0; column < N; column++) {
                    if (gridA[row][column] == 0 && gridB[row][column] == 1) {
                        dfs(gridB, row, column);
                    }
                }
            }

            int res = 0;
            for (int row = 0; row < M; row++) {
                for (int column = 0; column < N; column++) {
                    if (gridB[row][column] == 1) {
                        res++;
                        dfs(gridB, row, column);
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
