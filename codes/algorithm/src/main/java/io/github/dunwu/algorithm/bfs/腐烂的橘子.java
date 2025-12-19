package io.github.dunwu.algorithm.bfs;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/rotting-oranges/">994. 腐烂的橘子</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-07
 */
public class 腐烂的橘子 {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] input1 = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        Assertions.assertEquals(4, s.orangesRotting(input1));

        int[][] input2 = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
        Assertions.assertEquals(-1, s.orangesRotting(input2));

        int[][] input3 = { { 0, 2 } };
        Assertions.assertEquals(0, s.orangesRotting(input3));

        int[][] input4 = { { 1 } };
        Assertions.assertEquals(-1, s.orangesRotting(input4));

        int[][] input5 = { { 1, 2 } };
        Assertions.assertEquals(1, s.orangesRotting(input5));
    }

    static class Solution {

        // 四个方向偏移量（上、下、左、右）
        private static final int[][] directions = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

        public int orangesRotting(int[][] grid) {

            int m = grid.length, n = grid[0].length;

            int freshCount = 0;
            boolean[][] visited = new boolean[m][n];
            LinkedList<int[]> queue = new LinkedList<>();

            // 把所有腐烂的橘子加入队列，作为 BFS 的起点
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (grid[x][y] == 1) {
                        freshCount++;
                    } else if (grid[x][y] == 2) {
                        queue.offer(new int[] { x, y });
                        visited[x][y] = true;
                    }
                }
            }
            if (freshCount == 0) { return 0; }
            if (queue.isEmpty()) { return -1; }

            int step = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] point = queue.poll();
                    int x = point[0], y = point[1];
                    for (int[] d : directions) {
                        int nextX = x + d[0], nextY = y + d[1];
                        // 超出边界，跳过
                        if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) { continue; }
                        // 已访问，跳过（避免死循环）
                        if (visited[nextX][nextY]) { continue; }
                        // 遇到空格，跳过
                        if (grid[nextX][nextY] == 0) { continue; }
                        // 遇到新鲜橘子，被传播腐烂
                        if (grid[nextX][nextY] == 1) {
                            grid[nextX][nextY] = 2;
                            freshCount--;
                            // 新鲜橘子数为 0，返回结果
                            if (freshCount == 0) { return step; }
                        }
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
