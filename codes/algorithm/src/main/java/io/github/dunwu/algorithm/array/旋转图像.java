package io.github.dunwu.algorithm.array;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/rotate-image/">LCR 006. 两数之和 II - 输入有序数组</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-08-06
 */
public class 旋转图像 {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        rotate(matrix);
        int[][] expect = { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };
        System.out.println("matrix: " + JSONUtil.toJsonStr(matrix));
        Assertions.assertTrue(ArrayUtil.equals(expect, matrix));

        int[][] matrix2 = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
        rotate(matrix2);
        int[][] expect2 = { { 15, 13, 2, 5 }, { 14, 3, 4, 1 }, { 12, 6, 8, 9 }, { 16, 7, 10, 11 } };
        System.out.println("matrix: " + JSONUtil.toJsonStr(matrix2));
        Assertions.assertTrue(ArrayUtil.equals(expect2, matrix2));
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            reverse(matrix[i]);
        }
    }

    public static void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

}
