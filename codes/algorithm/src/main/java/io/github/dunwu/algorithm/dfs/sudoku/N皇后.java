package io.github.dunwu.algorithm.dfs.sudoku;

import io.github.dunwu.algorithm.util.ArrayUtil;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/n-queens/">51. N 皇后</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-04
 */
public class N皇后 {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> output = s.solveNQueens(4);
        String[][] expect = { { ".Q..", "...Q", "Q...", "..Q." }, { "..Q.", "Q...", "...Q", ".Q.." } };
        Assertions.assertArrayEquals(expect, ArrayUtil.toStringMatrixArray(output));

        List<List<String>> output2 = s.solveNQueens(1);
        String[][] expect2 = { { "Q" } };
        Assertions.assertArrayEquals(expect2, ArrayUtil.toStringMatrixArray(output2));
    }

    static class Solution {

        private List<List<String>> res;

        // 输入棋盘边长 n，返回所有合法的放置
        public List<List<String>> solveNQueens(int n) {
            res = new ArrayList<>();
            // '.' 表示空，'Q' 表示皇后，初始化空棋盘。
            char[] arr = new char[n];
            Arrays.fill(arr, '.');
            String str = new String(arr);
            List<String> board = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                board.add(str);
            }
            backtrack(board, 0);
            return res;
        }

        // 路径：board 中小于 row 的那些行都已经成功放置了皇后
        // 选择列表：第 row 行的所有列都是放置皇后的选择
        // 结束条件：row 超过 board 的最后一行
        public void backtrack(List<String> board, int row) {
            // 触发结束条件
            if (row == board.size()) {
                res.add(new ArrayList<>(board));
                return;
            }

            int n = board.get(row).length();
            for (int col = 0; col < n; col++) {
                // 排除不合法选择
                if (!isValid(board, row, col)) {
                    continue;
                }
                // 做选择
                char[] newRow = board.get(row).toCharArray();
                newRow[col] = 'Q';
                board.set(row, new String(newRow));
                // 进入下一行决策
                backtrack(board, row + 1);
                // 撤销选择
                newRow[col] = '.';
                board.set(row, new String(newRow));
            }
        }

        // 是否可以在 board[row][col] 放置皇后？
        public boolean isValid(List<String> board, int row, int col) {
            int n = board.size();
            // 检查列是否有皇后互相冲突
            for (int i = 0; i < row; i++) {
                if (board.get(i).charAt(col) == 'Q') { return false; }
            }
            // 检查右上方是否有皇后互相冲突
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (board.get(i).charAt(j) == 'Q') { return false; }
            }
            // 检查左上方是否有皇后互相冲突
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board.get(i).charAt(j) == 'Q') { return false; }
            }
            return true;
        }

    }

}
