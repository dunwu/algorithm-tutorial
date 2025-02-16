package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-01-21
 */
public class 有序矩阵中第K小的元素 {

    public static void main(String[] args) {

        int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        Assertions.assertEquals(13, kthSmallest(matrix, 8));

        int[][] matrix2 = { { -5 } };
        Assertions.assertEquals(-5, kthSmallest(matrix2, 1));

        int[][] matrix3 = { { 1, 2 }, { 1, 3 } };
        Assertions.assertEquals(1, kthSmallest(matrix3, 2));

        int[][] matrix4 = { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } };
        Assertions.assertEquals(3, kthSmallest(matrix4, 8));
    }

    public static int kthSmallest(int[][] matrix, int n) {
        int row = matrix.length;
        if (row == 1) {
            return matrix[0][n - 1];
        }
        int i = 1;
        int[] arr = matrix[0];
        while (i < row) {
            arr = merge(matrix[i], arr);
            i++;
        }
        return arr[n - 1];
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int[] merge = new int[arr1.length + arr2.length];
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                merge[k++] = arr1[i++];
            } else {
                merge[k++] = arr2[j++];
            }
        }
        if (i < arr1.length) {
            while (i < arr1.length) {
                merge[k++] = arr1[i++];
            }
        }
        if (j < arr2.length) {
            while (j < arr2.length) {
                merge[k++] = arr2[j++];
            }
        }
        return merge;
    }

}
