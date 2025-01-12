package io.github.dunwu.algorithm.array;

//    【对角线遍历】
//
//    给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
//
//    示例:
//
//    输入:
//    [
//    [ 1, 2, 3 ],
//    [ 4, 5, 6 ],
//    [ 7, 8, 9 ]
//    ]
//
//    输出:  [1,2,4,7,5,3,6,8,9]
//
//    说明:
//
//    给定矩阵中的元素总数不会超过 100000 。

import org.junit.jupiter.api.Assertions;

/**
 * @author Zhang Peng
 * @since 2018-11-04
 */
public class 对角线遍历 {

    public static void main(String[] args) {

        int[][] matrix = { { 1, 2 }, { 3, 4 } };
        int[] expected = { 1, 2, 3, 4 };

        int[][] matrix2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[] expected2 = { 1, 2, 4, 7, 5, 3, 6, 8, 9 };

        int[][] matrix3 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        int[] expected3 = { 1, 2, 5, 9, 6, 3, 4, 7, 10, 13, 14, 11, 8, 12, 15, 16 };

        Assertions.assertArrayEquals(expected, 对角线遍历.findDiagonalOrder(matrix));
        Assertions.assertArrayEquals(expected2, 对角线遍历.findDiagonalOrder(matrix2));
        Assertions.assertArrayEquals(expected3, 对角线遍历.findDiagonalOrder(matrix3));
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }

        int x = 0, y = 0;
        final int M = matrix.length;
        final int N = matrix[0].length;
        int[] arr = new int[M * N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = matrix[x][y];
            if ((x + y) % 2 == 0) {
                if (y == N - 1) {
                    x++;
                } else if (x == 0) {
                    y++;
                } else {
                    x--;
                    y++;
                }
            } else {
                if (x == M - 1) {
                    y++;
                } else if (y == 0) {
                    x++;
                } else {
                    x++;
                    y--;
                }
            }
        }
        return arr;
    }

    public static int[] findDiagonalOrder2(int[][] matrix) {
        final int UP = 1;
        final int DOWN = 2;
        final int M = matrix.length;
        final int N = matrix[0].length;
        int i = 0, j = 0, status = UP;

        int[] result = new int[M * N];
        // System.out.println("========================================");
        // System.out.println(JSONUtil.toJsonStr(matrix));
        // System.out.println("========================================");
        int index = 0;
        while (i < M && j < N) {
            result[index] = matrix[i][j];
            System.out.println(result[index]);
            index++;
            if (status == UP) {
                if (i == 0 || j == N - 1) {
                    status = DOWN;
                    if (j == N - 1) {
                        i++;
                    } else {
                        j++;
                    }
                } else {
                    i--;
                    j++;
                }
            } else {
                if (j == 0 || i == M - 1) {
                    status = UP;
                    if (i == M - 1) {
                        j++;
                    } else {
                        i++;
                    }
                } else {
                    i++;
                    j--;
                }
            }
        }
        return result;
    }

}
