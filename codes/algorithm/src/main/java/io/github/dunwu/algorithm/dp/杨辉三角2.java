package io.github.dunwu.algorithm.dp;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/pascals-triangle-ii/">119. 杨辉三角 II</a>
 *
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class 杨辉三角2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new Integer[] { 1, 3, 3, 1 }, s.getRow(3).toArray());
        Assertions.assertArrayEquals(new Integer[] { 1 }, s.getRow(0).toArray());
        Assertions.assertArrayEquals(new Integer[] { 1, 1 }, s.getRow(1).toArray());
    }

    static class Solution {

        public List<Integer> getRow(int rowIndex) {
            int row = rowIndex + 1;
            int[][] matrix = new int[row][row];
            matrix[0][0] = 1;
            List<List<Integer>> res = new ArrayList<>();
            res.add(Collections.singletonList(1));
            for (int i = 1; i < row; i++) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    if (j == 0) {
                        matrix[i][j] = matrix[i - 1][j];
                    } else {
                        matrix[i][j] = matrix[i - 1][j] + matrix[i - 1][j - 1];
                    }
                    list.add(matrix[i][j]);
                }
                res.add(list);
            }
            return res.get(rowIndex);
        }

    }

}
