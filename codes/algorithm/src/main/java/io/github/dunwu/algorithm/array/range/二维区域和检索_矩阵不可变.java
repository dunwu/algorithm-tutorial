package io.github.dunwu.algorithm.array.range;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/range-sum-query-immutable/">303. 区域和检索 - 数组不可变</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-08-06
 */
public class 二维区域和检索_矩阵不可变 {

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][] {
            { 3, 0, 1, 4, 2 },
            { 5, 6, 3, 2, 1 },
            { 1, 2, 0, 1, 5 },
            { 4, 1, 0, 1, 7 },
            { 1, 0, 3, 0, 5 }
        });
        Assertions.assertEquals(8, numMatrix.sumRegion(2, 1, 4, 3));
    }

    static class NumMatrix {

        private int[][] preSum;

        public NumMatrix(int[][] matrix) {
            final int M = matrix.length;
            final int N = matrix[0].length;
            preSum = new int[M + 1][N + 1];
            for (int i = 1; i <= M; i++) {
                for (int j = 1; j <= N; j++) {
                    preSum[i][j] = preSum[i][j - 1] + preSum[i - 1][j] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum[row2 + 1][col2 + 1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1] + preSum[row1][col1];
        }

    }

}
