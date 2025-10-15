package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/sort-the-matrix-diagonally/">1329. 将矩阵按对角线排序</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-08-06
 */
public class 将矩阵按对角线排序 {

    public static void main(String[] args) {
        int[][] input1 = { { 3, 3, 1, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 2 } };
        int[][] expected1 = { { 1, 1, 1, 1 }, { 1, 2, 2, 2 }, { 1, 2, 3, 3 } };
        int[][] output1 = diagonalSort(input1);
        Assertions.assertArrayEquals(expected1, output1);

        int[][] input2 = { { 11, 25, 66, 1, 69, 7 }, { 23, 55, 17, 45, 15, 52 }, { 75, 31, 36, 44, 58, 8 },
            { 22, 27, 33, 25, 68, 4 }, { 84, 28, 14, 11, 5, 50 } };
        int[][] expected2 = { { 5, 17, 4, 1, 52, 7 }, { 11, 11, 25, 45, 8, 69 }, { 14, 23, 25, 44, 58, 15 },
            { 22, 27, 31, 36, 50, 66 }, { 84, 28, 75, 33, 55, 68 } };
        int[][] output2 = diagonalSort(input2);
        Assertions.assertArrayEquals(expected2, output2);
    }

    public static int[][] diagonalSort(int[][] mat) {
        int R = mat.length, C = mat[0].length;

        // 存储所有对角线的元素列表
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 横纵坐标之差可以作为一条对角线的 ID
                int diff = i - j;
                map.putIfAbsent(diff, new PriorityQueue<>((a, b) -> a - b));
                map.get(diff).offer(mat[i][j]);
            }
        }

        // 把排序结果回填二维矩阵
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                PriorityQueue<Integer> pq = map.get(i - j);
                mat[i][j] = pq.poll();
            }
        }

        return mat;
    }

}
