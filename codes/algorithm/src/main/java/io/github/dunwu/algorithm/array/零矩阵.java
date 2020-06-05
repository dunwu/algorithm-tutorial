package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-05
 */
public class 零矩阵 {

    public static void main(String[] args) {
        int[][] array = {
            { 1, 1, 1 },
            { 1, 0, 1 },
            { 1, 1, 1 }
        };
        int[][] array2 = {
            { 1, 0, 1 },
            { 0, 0, 0 },
            { 1, 0, 1 }
        };
        setZeroes(array);
        // setZeroForElement(array, 1, 1);
        Assertions.assertArrayEquals(array2, array);
    }

    /**
     * @see <a href="https://leetcode-cn.com/problems/zero-matrix-lcci/">08. 零矩阵</a>
     */
    public static void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new Point(i, j));
                }
            }
        }

        list.forEach(p -> {
            setZeroForElement(matrix, p.i, p.j);
        });
    }

    public static void setZeroForElement(int[][] matrix, int x, int y) {
        int row = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            matrix[i][y] = 0;
        }
        for (int j = 0; j < column; j++) {
            matrix[x][j] = 0;
        }
    }

    static class Point {

        public int i;
        public int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

    }

}
