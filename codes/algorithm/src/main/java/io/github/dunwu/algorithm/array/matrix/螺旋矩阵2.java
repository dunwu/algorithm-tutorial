package io.github.dunwu.algorithm.array.matrix;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/spiral-matrix-ii/">54. 螺旋矩阵</a>
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
            int[][] res = new int[n][n];
            int left = 0, right = n - 1, top = 0, bottom = n - 1;
            while (cnt < n * n) {

                // 向右
                if (top <= bottom) {
                    for (int i = left; i <= right; i++) {
                        res[top][i] = ++cnt;
                    }
                    top++;
                }

                // 向下
                if (left <= right) {
                    for (int i = top; i <= bottom; i++) {
                        res[i][right] = ++cnt;
                    }
                    right--;
                }

                // 向左
                if (top <= bottom) {
                    for (int i = right; i >= left; i--) {
                        res[bottom][i] = ++cnt;
                    }
                    bottom--;
                }

                // 向上
                if (left <= right) {
                    for (int i = bottom; i >= top; i--) {
                        res[i][left] = ++cnt;
                    }
                    left++;
                }
            }
            return res;
        }

    }

}
