package io.github.dunwu.algorithm.array.matrix;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/spiral-matrix/">54. 螺旋矩阵</a>
 *
 * @author Zhang Peng
 * @since 2018-11-04
 */
public class 螺旋矩阵2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] output = s.generateMatrix(3);
        Assertions.assertArrayEquals(new int[][] { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } }, output);
        int[][] output2 = s.generateMatrix(1);
        Assertions.assertArrayEquals(new int[][] { { 1 } }, output2);
    }

    static class Solution {

        public int[][] generateMatrix(int n) {

            int cnt = 0;
            int up = 0, down = n - 1;
            int left = 0, right = n - 1;
            int[][] res = new int[n][n];
            while (cnt < n * n) {
                // 向右
                for (int i = left; i <= right; i++) {
                    res[up][i] = ++cnt;
                }
                up++;

                // 向下
                for (int i = up; i <= down; i++) {
                    res[i][right] = ++cnt;
                }
                right--;

                // 向左
                for (int i = right; i >= left; i--) {
                    res[down][i] = ++cnt;
                }
                down--;

                // 向上
                for (int i = down; i >= up; i--) {
                    res[i][left] = ++cnt;
                }
                left++;
            }
            return res;
        }

    }

}
