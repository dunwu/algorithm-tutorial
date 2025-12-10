package io.github.dunwu.algorithm.array.matrix;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/diagonal-traverse/">498. 对角线遍历</a>
 *
 * @author Zhang Peng
 * @since 2018-11-04
 */
public class 对角线遍历 {

    public static void main(String[] args) {

        Solution s = new Solution();

        int[][] input = { { 1, 2 }, { 3, 4 } };
        int[] expect = { 1, 2, 3, 4 };

        int[][] input2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[] expect2 = { 1, 2, 4, 7, 5, 3, 6, 8, 9 };

        int[][] input3 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        int[] expect3 = { 1, 2, 5, 9, 6, 3, 4, 7, 10, 13, 14, 11, 8, 12, 15, 16 };

        Assertions.assertArrayEquals(expect, s.findDiagonalOrder(input));
        Assertions.assertArrayEquals(expect2, s.findDiagonalOrder(input2));
        Assertions.assertArrayEquals(expect3, s.findDiagonalOrder(input3));
    }

    static class Solution {

        // 1. 同一对角线上的元素，满足 i + j = k
        // 2. k 的大小，满足递增，从 0 到 m + n - 2
        // 3. 由于，i + j = k -> i = k - j
        // i = m - 1 时最大，j 最小；而 k - (m - 1) 必须大于 0 => minJ = max(0, k - (m - 1))
        // i = 0 时最小，j 最大，但不能超过 n - 1 => maxJ = Math.max(k, n -1)
        public int[] findDiagonalOrder(int[][] mat) {

            // base case
            if (mat == null || mat.length == 0) { return new int[0]; }

            int idx = 0;
            int m = mat.length, n = mat[0].length;
            int[] res = new int[m * n];
            for (int k = 0; k < m + n - 1; k++) {
                int minJ = Math.max(k - (m - 1), 0);
                int maxJ = Math.min(k, n - 1);
                if (k % 2 == 0) {
                    for (int j = minJ; j <= maxJ; j++) {
                        res[idx++] = mat[k - j][j];
                    }
                } else {
                    for (int j = maxJ; j >= minJ; j--) {
                        res[idx++] = mat[k - j][j];
                    }
                }
            }
            return res;
        }

    }

}
