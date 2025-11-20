package io.github.dunwu.algorithm.array.matrix;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/spiral-matrix/">54. 螺旋矩阵</a>
 *
 * @author Zhang Peng
 * @since 2018-11-04
 */
public class 螺旋矩阵 {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> output = s.spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
        Assertions.assertArrayEquals(new Integer[] { 1, 2, 3, 6, 9, 8, 7, 4, 5 }, output.toArray());
        List<Integer> output2 = s.spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } });
        Assertions.assertArrayEquals(new Integer[] { 1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7 }, output2.toArray());
    }

    static class Solution {

        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
                return new LinkedList<>();
            }

            int m = matrix.length, n = matrix[0].length;
            int up = 0, down = m - 1;
            int left = 0, right = n - 1;
            List<Integer> res = new LinkedList<>();
            while (res.size() < m * n) {
                // 向右
                if (up <= down) {
                    for (int i = left; i <= right; i++) {
                        res.add(matrix[up][i]);
                    }
                    up++;
                }
                // System.out.printf("\t [right] up: %d, down: %d, left: %d, right: %d\n", up, down, left, right);
                // 向下
                if (left <= right) {
                    for (int i = up; i <= down; i++) {
                        res.add(matrix[i][right]);
                    }
                    right--;
                }
                // System.out.printf("\t [down] up: %d, down: %d, left: %d, right: %d\n", up, down, left, right);
                // 向左
                if (up <= down) {
                    for (int i = right; i >= left; i--) {
                        res.add(matrix[down][i]);
                    }
                    down--;
                }
                // System.out.printf("\t [left] up: %d, down: %d, left: %d, right: %d\n", up, down, left, right);
                // 向上
                if (left <= right) {
                    for (int i = down; i >= up; i--) {
                        res.add(matrix[i][left]);
                    }
                    left++;
                }
                // System.out.printf("\t [up] up: %d, down: %d, left: %d, right: %d\n", up, down, left, right);
                // System.out.printf("res: %s\n", JSONUtil.toJsonStr(res));
            }
            return res;
        }

    }

}
