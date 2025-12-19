package io.github.dunwu.algorithm.bfs;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/nearest-exit-from-entrance-in-maze/">1926. 迷宫中离入口最近的出口</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-07
 */
public class 迷宫中离入口最近的出口 {

    public static void main(String[] args) {

        Solution s = new Solution();

        char[][] maze1 = { { '+', '+', '.', '+' }, { '.', '.', '.', '+' }, { '+', '+', '+', '.' } };
        int[] entrance1 = { 1, 2 };
        Assertions.assertEquals(1, s.nearestExit(maze1, entrance1));

        char[][] maze2 = { { '+', '+', '+' }, { '.', '.', '.' }, { '+', '+', '+' } };
        int[] entrance2 = { 1, 0 };
        Assertions.assertEquals(2, s.nearestExit(maze2, entrance2));

        char[][] maze3 = { { '.', '+' } };
        int[] entrance3 = { 0, 0 };
        Assertions.assertEquals(-1, s.nearestExit(maze3, entrance3));

        char[][] maze4 = {
            { '+', '.', '+', '+', '+', '+', '+' },
            { '+', '.', '+', '.', '.', '.', '+' },
            { '+', '.', '+', '.', '+', '.', '+' },
            { '+', '.', '.', '.', '+', '.', '+' },
            { '+', '+', '+', '+', '+', '+', '.' }
        };
        int[] entrance4 = { 0, 1 };
        Assertions.assertEquals(-1, s.nearestExit(maze4, entrance4));
    }

    static class Solution {

        public int nearestExit(char[][] maze, int[] entrance) {

            int m = maze.length, n = maze[0].length;
            final int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

            // BFS 算法的队列和 visited 数组
            LinkedList<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[m][n];
            queue.offer(entrance);
            visited[entrance[0]][entrance[1]] = true;
            // 启动 BFS 算法从 entrance 开始像四周扩散
            int step = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                step++;
                // 扩散当前队列中的所有节点
                for (int i = 0; i < size; i++) {
                    int[] point = queue.poll();
                    // 每个节点都会尝试向上下左右四个方向扩展一步
                    for (int[] d : directions) {
                        int x = point[0] + d[0], y = point[1] + d[1];
                        if (x < 0 || x >= m || y < 0 || y >= n) { continue; }
                        if (visited[x][y] || maze[x][y] == '+') { continue; }
                        // 走到边界（出口）
                        if (x == 0 || x == m - 1 || y == 0 || y == n - 1) { return step; }
                        visited[x][y] = true;
                        queue.offer(new int[] { x, y });
                    }
                }
            }
            return -1;
        }

    }

}
