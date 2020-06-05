package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-05
 */
public class 旋转矩阵 {

    public static void main(String[] args) {
        int[][] array = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };
        int[][] array2 = {
            { 7, 4, 1 },
            { 8, 5, 2 },
            { 9, 6, 3 }
        };
        rotate(array);
        Assertions.assertArrayEquals(array2, array);
    }

    /**
     * @see <a href="https://leetcode-cn.com/problems/compress-string-lcci/">07. 旋转矩阵</a>
     */
    public static void rotate(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] array = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                array[j][row - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = array[i][j];
            }
        }
    }

}
