package io.github.dunwu.algorithm.array.matrix;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.List;

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

        public int[] findDiagonalOrder(int[][] mat) {

            // base case
            if (mat == null || mat.length == 0) { return new int[0]; }

            int m = mat.length, n = mat[0].length;
            List<Integer> list = new LinkedList<>();
            for (int step = 0; step <= m + n - 2; step++) {
                int min = Math.max(step - (m - 1), 0);
                int max = Math.min(step, n - 1);
                if (step % 2 == 0) {
                    for (int i = max; i >= min; i--) {
                        list.add(mat[i][step - i]);
                    }
                } else {
                    for (int i = min; i <= max; i++) {
                        list.add(mat[i][step - i]);
                    }
                }
            }

            int[] res = new int[list.size()];
            for (int k = 0; k < list.size(); k++) {
                res[k] = list.get(k);
            }
            return res;
        }

    }

}
