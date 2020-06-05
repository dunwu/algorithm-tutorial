package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

//    【螺旋矩阵】
//
//    给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
//
//    示例 1:
//
//    输入:
//    [
//    [ 1, 2, 3 ],
//    [ 4, 5, 6 ],
//    [ 7, 8, 9 ]
//    ]
//    输出: [1,2,3,6,9,8,7,4,5]
//    示例 2:
//
//    输入:
//    [
//    [1, 2, 3, 4],
//    [5, 6, 7, 8],
//    [9,10,11,12]
//    ]
//    输出: [1,2,3,4,8,12,11,10,9,5,6,7]

/**
 * @author Zhang Peng
 * @since 2018-11-04
 */
public class 螺旋矩阵 {

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 4, 5, 6, 7 };
        int[] expected1 = { 5, 6, 7, 1, 2, 3, 4 };
        旋转数组.rotate(nums1, 3);
        Assertions.assertArrayEquals(expected1, nums1);

        int[] nums2 = { -1, -100, 3, 99 };
        int[] expected2 = { 3, 99, -1, -100 };
        旋转数组.rotate(nums2, 2);
        Assertions.assertArrayEquals(expected2, nums2);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return list;
        }

        final int M = matrix.length;
        final int N = matrix[0].length;
        final int MAX = M * N;
        int x = 0, y = 0;
        int XMIN = 0, YMIN = 0;
        int XMAX = M - 1, YMAX = N - 1;
        for (int index = 0; index < MAX; index++) {
            list.add(matrix[x][y]);

            if (x == XMIN && y != YMAX) {
                y++;
            } else if (y == YMAX && x != XMAX) {
                x++;
            } else if (x == XMAX && y != YMIN) {
                y--;
            } else if (y == YMIN && x != XMIN + 1) {
                x--;
            } else if (x == XMIN + 1 && y == YMIN) {
                XMIN = XMIN + 1;
                YMIN = YMIN + 1;
                XMAX = XMAX - 1;
                YMAX = YMAX - 1;
                x = XMIN;
                y = YMIN;
            }
        }

        return list;
    }

}
