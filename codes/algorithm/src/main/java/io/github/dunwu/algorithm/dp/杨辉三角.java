package io.github.dunwu.algorithm.dp;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/pascals-triangle/">118. 杨辉三角</a>
 *
 * @author Zhang Peng
 * @since 2018-11-04
 */
public class 杨辉三角 {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> expect = new ArrayList<>();
        expect.add(Arrays.asList(1));
        expect.add(Arrays.asList(1, 1));
        expect.add(Arrays.asList(1, 2, 1));
        expect.add(Arrays.asList(1, 3, 3, 1));
        expect.add(Arrays.asList(1, 4, 6, 4, 1));
        List<List<Integer>> lists = s.generate(5);
        Assertions.assertArrayEquals(expect.toArray(), lists.toArray());
    }

    static class Solution {

        public List<List<Integer>> generate(int row) {
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
            return res;
        }

    }

}
