package io.github.dunwu.algorithm.bfs;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/shortest-path-in-binary-matrix/">1091. 二进制矩阵中的最短路径</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-12-15
 */
public class 二进制矩阵中的最短路径 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(2, s.shortestPathBinaryMatrix(new int[][] { { 0, 1 }, { 1, 0 } }));
        Assertions.assertEquals(4, s.shortestPathBinaryMatrix(new int[][] { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } }));
        Assertions.assertEquals(-1, s.shortestPathBinaryMatrix(new int[][] { { 1, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } }));
    }

    static class Solution {

        // 八个方向偏移量（上、下、左、右、左上、右下、左下、右上）
        private final int[][] directions = {
            { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 },
            { -1, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 }
        };

        public int shortestPathBinaryMatrix(int[][] grid) {

            int m = grid.length, n = grid[0].length;
            if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
                return -1;
            }

            // 需要记录走过的路径，避免死循环
            boolean[][] visited = new boolean[m][n];
            LinkedList<int[]> queue = new LinkedList<>();

            // 初始化队列，从 (0, 0) 出发
            visited[0][0] = true;
            queue.offer(new int[] { 0, 0 });

            int step = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] cur = queue.poll();
                    int x = cur[0], y = cur[1];
                    if (grid[x][y] != 0) { return -1; }
                    // 到达底部，返回步骤数
                    if (x == m - 1 && y == n - 1) { return step; }

                    for (int[] d : directions) {
                        int nextX = x + d[0], nextY = y + d[1];
                        if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) { continue; }
                        if (visited[nextX][nextY] || grid[nextX][nextY] != 0) { continue; }
                        visited[nextX][nextY] = true;
                        queue.offer(new int[] { nextX, nextY });
                    }
                }
                step++;
            }
            return -1;
        }

    }

}
