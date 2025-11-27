package io.github.dunwu.algorithm.array.two_pointer;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/shift-2d-grid/">1260. 二维网格迁移</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-14
 */
public class 二维网格迁移 {

    public static void main(String[] args) {

        Solution s = new Solution();

        int[][] grid1 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        List<List<Integer>> res1 = s.shiftGrid(grid1, 1);
        Assertions.assertNotNull(res1);
        Assertions.assertArrayEquals(new Integer[] { 9, 1, 2 }, res1.get(0).toArray(new Integer[0]));
        Assertions.assertArrayEquals(new Integer[] { 3, 4, 5 }, res1.get(1).toArray(new Integer[0]));
        Assertions.assertArrayEquals(new Integer[] { 6, 7, 8 }, res1.get(2).toArray(new Integer[0]));

        int[][] grid2 = new int[][] { { 3, 8, 1, 9 }, { 19, 7, 2, 5 }, { 4, 6, 11, 10 }, { 12, 0, 21, 13 } };
        List<List<Integer>> res2 = s.shiftGrid(grid2, 4);
        Assertions.assertNotNull(res2);
        Assertions.assertArrayEquals(new Integer[] { 12, 0, 21, 13 }, res2.get(0).toArray(new Integer[0]));
        Assertions.assertArrayEquals(new Integer[] { 3, 8, 1, 9 }, res2.get(1).toArray(new Integer[0]));
        Assertions.assertArrayEquals(new Integer[] { 19, 7, 2, 5 }, res2.get(2).toArray(new Integer[0]));
        Assertions.assertArrayEquals(new Integer[] { 4, 6, 11, 10 }, res2.get(3).toArray(new Integer[0]));

        int[][] grid3 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        List<List<Integer>> res3 = s.shiftGrid(grid3, 9);
        Assertions.assertNotNull(res3);
        Assertions.assertArrayEquals(new Integer[] { 1, 2, 3 }, res3.get(0).toArray(new Integer[0]));
        Assertions.assertArrayEquals(new Integer[] { 4, 5, 6 }, res3.get(1).toArray(new Integer[0]));
        Assertions.assertArrayEquals(new Integer[] { 7, 8, 9 }, res3.get(2).toArray(new Integer[0]));

        int[][] grid4 = new int[][] { { 1 }, { 2 }, { 3 }, { 4 }, { 7 }, { 6 }, { 5 } };
        List<List<Integer>> res4 = s.shiftGrid(grid4, 23);
        Assertions.assertNotNull(res4);
    }

    static class Solution {

        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            for (int i = 0; i < k; i++) {
                shift(grid);
            }

            int m = grid.length, n = grid[0].length;
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                List<Integer> list = new ArrayList<>();
                res.add(list);
                for (int j = 0; j < n; j++) {
                    list.add(grid[i][j]);
                }
            }
            return res;
        }

        public void shift(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int last = get(grid, m * n - 1);
            for (int i = m * n - 1; i > 0; i--) {
                int prev = get(grid, i - 1);
                set(grid, i, prev);
            }
            set(grid, 0, last);
        }

        public int get(int[][] grid, int index) {
            int n = grid[0].length;
            int i = index / n;
            int j = index % n;
            return grid[i][j];
        }

        public void set(int[][] grid, int index, int val) {
            int n = grid[0].length;
            int i = index / n;
            int j = index % n;
            grid[i][j] = val;
        }

    }

}
