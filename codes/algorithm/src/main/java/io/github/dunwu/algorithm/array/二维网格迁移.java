package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-14
 */
public class 二维网格迁移 {
    // 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
    //
    // 每次「迁移」操作将会引发下述活动：
    //
    // 位于 grid[i][j]（j < n - 1）的元素将会移动到 grid[i][j + 1]。
    // 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
    // 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
    // 请你返回 k 次迁移操作后最终得到的 二维网格。

    // 输入：grid = {{1,2,3},{4,5,6},{7,8,9}}, k = 1
    // 输出：{{9,1,2},{3,4,5},{6,7,8}}
    //
    //
    // 输入：grid = {{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}}, k = 4
    // 输出：{{12,0,21,13},{3,8,1,9},{19,7,2,5},{4,6,11,10}}
    //
    // 输入：grid = {{1,2,3},{4,5,6},{7,8,9}}, k = 9
    // 输出：{{1,2,3},{4,5,6},{7,8,9}}

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        int[][] grid1 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        List<List<Integer>> res1 = shiftGrid(grid1, 1);
        Assertions.assertNotNull(res1);
        Assertions.assertArrayEquals(new Integer[] { 9, 1, 2 }, res1.get(0).toArray(new Integer[0]));
        Assertions.assertArrayEquals(new Integer[] { 3, 4, 5 }, res1.get(1).toArray(new Integer[0]));
        Assertions.assertArrayEquals(new Integer[] { 6, 7, 8 }, res1.get(2).toArray(new Integer[0]));

        int[][] grid2 = new int[][] { { 3, 8, 1, 9 }, { 19, 7, 2, 5 }, { 4, 6, 11, 10 }, { 12, 0, 21, 13 } };
        List<List<Integer>> res2 = shiftGrid(grid2, 4);
        Assertions.assertNotNull(res2);
        Assertions.assertArrayEquals(new Integer[] { 12, 0, 21, 13 }, res2.get(0).toArray(new Integer[0]));
        Assertions.assertArrayEquals(new Integer[] { 3, 8, 1, 9 }, res2.get(1).toArray(new Integer[0]));
        Assertions.assertArrayEquals(new Integer[] { 19, 7, 2, 5 }, res2.get(2).toArray(new Integer[0]));
        Assertions.assertArrayEquals(new Integer[] { 4, 6, 11, 10 }, res2.get(3).toArray(new Integer[0]));

        int[][] grid3 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        List<List<Integer>> res3 = shiftGrid(grid3, 9);
        Assertions.assertNotNull(res3);
        Assertions.assertArrayEquals(new Integer[] { 1, 2, 3 }, res3.get(0).toArray(new Integer[0]));
        Assertions.assertArrayEquals(new Integer[] { 4, 5, 6 }, res3.get(1).toArray(new Integer[0]));
        Assertions.assertArrayEquals(new Integer[] { 7, 8, 9 }, res3.get(2).toArray(new Integer[0]));
    }

    /**
     * 低效方法
     */
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int M = grid.length, N = grid[0].length;
        k = k % (M * N);
        List<List<Integer>> listlist = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            shift(grid);
        }
        for (int[] array : grid) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int val : array) {
                list.add(val);
            }
            listlist.add(list);
        }
        return listlist;
    }

    public static void shift(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int[][] shift = new int[M][N];
        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                int val = grid[i][j];
                if (i == M - 1 && j == N - 1) {
                    shift[0][0] = val;
                } else if (j == N - 1) {
                    shift[i + 1][0] = val;
                } else if (j < N - 1) {
                    shift[i][j + 1] = val;
                }
            }
        }
        for (int i = M - 1; i >= 0; i--) {
            System.arraycopy(shift[i], 0, grid[i], 0, N - 1 + 1);
        }
    }

}
