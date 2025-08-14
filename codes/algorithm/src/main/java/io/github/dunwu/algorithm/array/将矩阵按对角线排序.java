package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<Integer, List<Integer>> map = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int diff = i - j;
                if (!map.containsKey(diff)) {
                    map.put(diff, new ArrayList<>());
                }
                map.get(diff).add(mat[i][j]);
            }
        }

        map.forEach((diff, list) -> {
            Collections.sort(list);
        });

        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int diff = i - j;
                List<Integer> list = map.get(diff);
                result[i][j] = list.remove(0);
            }
        }
        return result;
    }

}
