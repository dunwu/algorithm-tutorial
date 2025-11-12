package io.github.dunwu.algorithm.dfs;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/sudoku-solver/">37. 解数独</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-03
 */
public class 解数独 {

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] input = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
            { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
            { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
            { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
            { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        char[][] expect = new char[][] { { '5', '3', '4', '6', '7', '8', '9', '1', '2' },
            { '6', '7', '2', '1', '9', '5', '3', '4', '8' }, { '1', '9', '8', '3', '4', '2', '5', '6', '7' },
            { '8', '5', '9', '7', '6', '1', '4', '2', '3' }, { '4', '2', '6', '8', '5', '3', '7', '9', '1' },
            { '7', '1', '3', '9', '2', '4', '8', '5', '6' }, { '9', '6', '1', '5', '3', '7', '2', '8', '4' },
            { '2', '8', '7', '4', '1', '9', '6', '3', '5' }, { '3', '4', '5', '2', '8', '6', '1', '7', '9' } };
        s.solveSudoku(input);
        Assertions.assertArrayEquals(expect, input);
    }

    static class Solution {

        boolean found = false;

        public void solveSudoku(char[][] nums) {
            found = false;
            backtrack(nums, 0);
        }

        public void backtrack(char[][] nums, int index) {

            if (found) { return; }

            int m = 9, n = 9;
            int i = index / n, j = index % n;
            if (index == m * n) {
                found = true;
                return;
            }

            if (nums[i][j] != '.') {
                backtrack(nums, index + 1);
                return;
            }

            for (char ch = '1'; ch <= '9'; ch++) {
                // 剪枝：如果遇到不合法的数字，就跳过
                if (!isValid(nums, i, j, ch)) { continue; }

                // 做选择
                nums[i][j] = ch;

                backtrack(nums, index + 1);
                if (found) {
                    // 如果找到一个可行解，立即结束
                    // 不要撤销选择，否则 board[i][j] 会被重置为 '.'
                    return;
                }

                // 撤销选择
                nums[i][j] = '.';
            }
        }

        // 判断是否可以在 (r, c) 位置放置数字 num
        boolean isValid(char[][] board, int row, int column, char num) {
            for (int i = 0; i < 9; i++) {
                // 判断行是否存在重复
                if (board[row][i] == num) return false;
                // 判断列是否存在重复
                if (board[i][column] == num) return false;
                // 判断 3 x 3 方框是否存在重复
                if (board[(row / 3) * 3 + i / 3][(column / 3) * 3 + i % 3] == num) { return false; }
            }
            return true;
        }

    }

}
