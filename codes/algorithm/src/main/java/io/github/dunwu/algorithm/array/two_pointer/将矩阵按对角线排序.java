package io.github.dunwu.algorithm.array.two_pointer;

import org.junit.jupiter.api.Assertions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/sort-the-matrix-diagonally/">1329. 将矩阵按对角线排序</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-08-06
 */
public class 将矩阵按对角线排序 {

    public static void main(String[] args) {

        Solution s = new Solution();

        int[][] input1 = { { 3, 3, 1, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 2 } };
        int[][] expected1 = { { 1, 1, 1, 1 }, { 1, 2, 2, 2 }, { 1, 2, 3, 3 } };
        int[][] output1 = s.diagonalSort(input1);
        Assertions.assertArrayEquals(expected1, output1);

        int[][] input2 = { { 11, 25, 66, 1, 69, 7 }, { 23, 55, 17, 45, 15, 52 }, { 75, 31, 36, 44, 58, 8 },
            { 22, 27, 33, 25, 68, 4 }, { 84, 28, 14, 11, 5, 50 } };
        int[][] expected2 = { { 5, 17, 4, 1, 52, 7 }, { 11, 11, 25, 45, 8, 69 }, { 14, 23, 25, 44, 58, 15 },
            { 22, 27, 31, 36, 50, 66 }, { 84, 28, 75, 33, 55, 68 } };
        int[][] output2 = s.diagonalSort(input2);
        Assertions.assertArrayEquals(expected2, output2);
    }

    static class Solution {

        public int[][] diagonalSort(int[][] mat) {

            int m = mat.length, n = mat[0].length;

            // 在同一个对角线上的元素，其横纵坐标之差是相同的
            // 存储所有对角线的元素列表，利用 PriorityQueue 自动对对角线元素排序
            Map<Integer, PriorityQueue<int[]>> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 横纵坐标之差可以作为一条对角线的 ID
                    int diff = i - j;
                    if (!map.containsKey(diff)) {
                        map.put(diff, new PriorityQueue<>(Comparator.comparingInt(a -> mat[a[0]][a[1]])));
                    }
                    map.get(diff).add(new int[] { i, j });
                }
            }

            // 把排序结果回填二维矩阵
            int[][] res = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int diff = i - j;
                    PriorityQueue<int[]> queue = map.get(diff);
                    int[] point = queue.poll();
                    res[i][j] = mat[point[0]][point[1]];
                }
            }
            return res;
        }

    }

}
