package io.github.dunwu.algorithm.array.two_pointer;

import org.junit.jupiter.api.Assertions;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/">378. 有序矩阵中第 K 小的元素</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-01-21
 */
public class 有序矩阵中第K小的元素 {

    public static void main(String[] args) {

        Solution s = new Solution();

        int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        Assertions.assertEquals(13, s.kthSmallest(matrix, 8));

        int[][] matrix2 = { { -5 } };
        Assertions.assertEquals(-5, s.kthSmallest(matrix2, 1));

        int[][] matrix3 = { { 1, 2 }, { 1, 3 } };
        Assertions.assertEquals(1, s.kthSmallest(matrix3, 2));

        int[][] matrix4 = { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } };
        Assertions.assertEquals(3, s.kthSmallest(matrix4, 8));
    }

    static class Solution {

        public int kthSmallest(int[][] matrix, int k) {
            // 存储二元组 (matrix[i][j], i, j)
            // i, j 记录当前元素的索引位置，用于生成下一个节点
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                // 按照元素大小升序排序
                return a[0] - b[0];
            });

            // 初始化优先级队列，把每一行的第一个元素装进去
            for (int i = 0; i < matrix.length; i++) {
                pq.offer(new int[] { matrix[i][0], i, 0 });
            }

            int res = -1;
            while (!pq.isEmpty() && k > 0) {
                int[] cur = pq.poll();
                res = cur[0];
                k--;

                // 链表中的下一个节点加入优先级队列
                int i = cur[1], j = cur[2];
                if (j + 1 < matrix[i].length) {
                    pq.add(new int[] { matrix[i][j + 1], i, j + 1 });
                }
            }
            return res;
        }

    }

}
