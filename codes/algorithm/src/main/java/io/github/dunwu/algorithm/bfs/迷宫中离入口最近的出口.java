package io.github.dunwu.algorithm.bfs;

import org.junit.jupiter.api.Assertions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/nearest-exit-from-entrance-in-maze/">1926. 迷宫中离入口最近的出口</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-07
 */
public class 迷宫中离入口最近的出口 {

    public static void main(String[] args) {

        Solution s = new Solution();

        char[][] maze1 = new char[][] { { '+', '+', '.', '+' }, { '.', '.', '.', '+' }, { '+', '+', '+', '.' } };
        int[] entrance1 = new int[] { 1, 2 };
        Assertions.assertEquals(1, s.nearestExit(maze1, entrance1));

        char[][] maze2 = new char[][] { { '+', '+', '+' }, { '.', '.', '.' }, { '+', '+', '+' } };
        int[] entrance2 = new int[] { 1, 0 };
        Assertions.assertEquals(2, s.nearestExit(maze2, entrance2));

        char[][] maze3 = new char[][] { { '.', '+' } };
        int[] entrance3 = new int[] { 0, 0 };
        Assertions.assertEquals(-1, s.nearestExit(maze3, entrance3));

        char[][] maze4 = new char[][] {
            { '+', '.', '+', '+', '+', '+', '+' },
            { '+', '.', '+', '.', '.', '.', '+' },
            { '+', '.', '+', '.', '+', '.', '+' },
            { '+', '.', '.', '.', '+', '.', '+' },
            { '+', '+', '+', '+', '+', '+', '.' }
        };
        int[] entrance4 = new int[] { 0, 1 };
        Assertions.assertEquals(-1, s.nearestExit(maze4, entrance4));
    }

    static class Solution {

        public int nearestExit(char[][] maze, int[] entrance) {

            int M = maze.length, N = maze[0].length;
            int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

            int step = 0;
            boolean[][] visited = new boolean[M][N];
            visited[entrance[0]][entrance[1]] = true;
            LinkedList<int[]> queue = new LinkedList<>();
            queue.offer(entrance);
            while (!queue.isEmpty()) {
                int size = queue.size();
                step++;
                // 扩散当前队列中的所有节点
                for (int i = 0; i < size; i++) {
                    int[] cur = queue.poll();
                    // 每个节点都会尝试向上下左右四个方向扩展一步
                    for (int[] dir : dirs) {

                        int row = cur[0] + dir[0];
                        int column = cur[1] + dir[1];

                        // 无效路径，返回
                        if (row < 0 || row >= M || column < 0 || column >= N) {
                            continue;
                        }
                        if (visited[row][column]) {
                            continue;
                        }
                        if (maze[row][column] == '+') {
                            continue;
                        }

                        // 找到出口，退出
                        if (row == 0 || row == M - 1 || column == 0 || column == N - 1) {
                            return step;
                        }

                        visited[row][column] = true;
                        queue.offer(new int[] { row, column });
                    }
                }
            }
            return -1;
        }

    }

}
