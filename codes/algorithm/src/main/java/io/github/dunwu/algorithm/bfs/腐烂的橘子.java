package io.github.dunwu.algorithm.bfs;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/rotting-oranges/">994. 腐烂的橘子</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-07
 */
public class 腐烂的橘子 {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] input1 = new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        Assertions.assertEquals(4, s.orangesRotting(input1));

        int[][] input2 = new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
        Assertions.assertEquals(-1, s.orangesRotting(input2));

        int[][] input3 = new int[][] { { 0, 2 } };
        Assertions.assertEquals(0, s.orangesRotting(input3));

        int[][] input4 = new int[][] { { 1 } };
        Assertions.assertEquals(-1, s.orangesRotting(input4));

        int[][] input5 = new int[][] { { 1, 2 } };
        Assertions.assertEquals(1, s.orangesRotting(input5));
    }

    static class Solution {

        // 四个方向偏移量（上、下、左、右）
        private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

        public int orangesRotting(int[][] grid) {

            int m = grid.length, n = grid[0].length;

            // 1. 初始化：收集腐烂橘子，统计新鲜橘子数量
            int freshNum = 0;
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        // 腐烂橘子入队（BFS起点）
                        queue.offer(new int[] { i, j });
                    } else if (grid[i][j] == 1) {
                        freshNum++;
                    }
                }
            }

            // 边界情况：无新鲜橘子，直接返回
            if (freshNum == 0) {
                return 0;
            }

            // BFS 算法框架
            int step = 0;
            while (!queue.isEmpty()) {

                // 当前分钟要处理的腐烂橘子数量
                int size = queue.size();
                // 标记当前分钟是否有新鲜橘子腐烂
                boolean hasRotten = false;

                // 处理当前层级所有腐烂橘子
                for (int i = 0; i < size; i++) {
                    int[] cur = queue.poll();

                    // 遍历四个相邻方向
                    for (int[] dir : DIRS) {
                        int x = cur[0] + dir[0];
                        int y = cur[1] + dir[1];

                        // 检查相邻单元格是否合法且为新鲜橘子
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                            freshNum--;
                            grid[x][y] = 2;
                            hasRotten = true;
                            queue.offer(new int[] { x, y });
                        }
                    }
                }

                // 只有当前分钟有橘子腐烂时，才增加层级
                if (hasRotten) {
                    step++;
                }

                // 提前终止：所有新鲜橘子已腐烂，无需继续遍历
                if (freshNum == 0) {
                    break;
                }
            }

            // 3. 最终判断：是否所有新鲜橘子都腐烂
            return freshNum == 0 ? step : -1;
        }

    }

}
