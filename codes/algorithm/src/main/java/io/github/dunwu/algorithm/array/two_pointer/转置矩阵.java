package io.github.dunwu.algorithm.array.two_pointer;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/sort-the-matrix-diagonally/">1329. 将矩阵按对角线排序</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-08-06
 */
public class 转置矩阵 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] input1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] expect1 = { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } };
        int[][] output1 = s.transpose(input1);
        Assertions.assertArrayEquals(expect1, output1);

        int[][] input2 = { { 1, 2, 3 }, { 4, 5, 6 } };
        int[][] expect2 = { { 1, 4 }, { 2, 5 }, { 3, 6 } };
        int[][] output2 = s.transpose(input2);
        Assertions.assertArrayEquals(expect2, output2);
    }

    public static class Solution {

        public int[][] transpose(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int[][] res = new int[n][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    res[j][i] = matrix[i][j];
                }
            }
            return res;
        }

    }

}
