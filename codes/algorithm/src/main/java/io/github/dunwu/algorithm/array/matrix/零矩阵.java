package io.github.dunwu.algorithm.array.matrix;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

/**
 * <a href="https://leetcode-cn.com/problems/zero-matrix-lcci/">08. 零矩阵</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-05
 */
public class 零矩阵 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] input = {
            { 1, 1, 1 },
            { 1, 0, 1 },
            { 1, 1, 1 }
        };
        int[][] expect = {
            { 1, 0, 1 },
            { 0, 0, 0 },
            { 1, 0, 1 }
        };
        s.setZeroes(input);
        Assertions.assertArrayEquals(expect, input);
    }

    static class Solution {

        public void setZeroes(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            LinkedList<int[]> queue = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        queue.offer(new int[] { i, j });
                    }
                }
            }

            while (!queue.isEmpty()) {
                int[] point = queue.poll();
                int x = point[0], y = point[1];
                for (int i = 0; i < n; i++) { matrix[x][i] = 0; }
                for (int i = 0; i < m; i++) { matrix[i][y] = 0; }
            }
        }

    }

}
