package io.github.dunwu.algorithm.array.two_pointer;

import org.junit.jupiter.api.Assertions;

import java.util.Optional;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/">378. 有序矩阵中第 K 小的元素</a>
 *
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
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
        for (int[] row : matrix) {
            for (int val : row) {
                queue.offer(val);
            }
        }
        Integer num = null;
        for (int i = 0; i < n; i++) {
            num = queue.poll();
        }
        return Optional.ofNullable(num).orElse(0);
    }

}
