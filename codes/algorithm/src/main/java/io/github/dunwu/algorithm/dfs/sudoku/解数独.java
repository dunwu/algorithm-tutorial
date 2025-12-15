package io.github.dunwu.algorithm.dfs.sudoku;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/sudoku-solver/">37. 解数独</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-03
 */
public class 解数独 {

    public static void main(String[] args) {

        char[][] expect = {
            { '5', '3', '4', '6', '7', '8', '9', '1', '2' },
            { '6', '7', '2', '1', '9', '5', '3', '4', '8' },
            { '1', '9', '8', '3', '4', '2', '5', '6', '7' },
            { '8', '5', '9', '7', '6', '1', '4', '2', '3' },
            { '4', '2', '6', '8', '5', '3', '7', '9', '1' },
            { '7', '1', '3', '9', '2', '4', '8', '5', '6' },
            { '9', '6', '1', '5', '3', '7', '2', '8', '4' },
            { '2', '8', '7', '4', '1', '9', '6', '3', '5' },
            { '3', '4', '5', '2', '8', '6', '1', '7', '9' }
        };
        char[][] input = {
            { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
            { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
            { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
            { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
            { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
            { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
            { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
            { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
            { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        char[][] input2 = {
            { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
            { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
            { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
            { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
            { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
            { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
            { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
            { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
            { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        Solution s = new Solution();
        s.solveSudoku(input);
        Assertions.assertArrayEquals(expect, input);

        Solution2 s2 = new Solution2();
        s2.solveSudoku(input2);
        Assertions.assertArrayEquals(expect, input2);
    }

    static class Solution {

        private int n;
        // 标记是否已经找到可行解
        boolean found = false;

        public void solveSudoku(char[][] board) {
            n = board.length;
            backtrack(board, 0);
        }

        // 路径：board 中小于 index 的位置所填的数字
        // 选择列表：数字 1~9
        // 结束条件：整个 board 都填满数字
        void backtrack(char[][] board, int index) {
            if (found) {
                // 已经找到一个可行解，立即结束
                return;
            }

            int[] point = point(index);
            int row = point[0], col = point[1];
            if (index == n * n) {
                // 找到一个可行解，触发 base case
                found = true;
                return;
            }

            if (board[row][col] != '.') {
                // 如果有预设数字，不用我们穷举
                backtrack(board, index + 1);
                return;
            }

            for (char ch = '1'; ch <= '9'; ch++) {
                // 剪枝：如果遇到不合法的数字，就跳过
                if (!isValid(board, row, col, ch)) { continue; }

                // 做选择
                board[row][col] = ch;

                backtrack(board, index + 1);
                if (found) {
                    // 如果找到一个可行解，立即结束
                    // 不要撤销选择，否则 board[i][j] 会被重置为 '.'
                    return;
                }

                // 撤销选择
                board[row][col] = '.';
            }
        }

        // 判断是否可以在 (r, c) 位置放置数字 num
        boolean isValid(char[][] board, int row, int col, char num) {
            for (int i = 0; i < 9; i++) {
                // 判断行是否存在重复
                if (board[row][i] == num) return false;
                // 判断列是否存在重复
                if (board[i][col] == num) return false;
                // 判断 3 x 3 方框是否存在重复
                if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == num) { return false; }
            }
            return true;
        }

        public int index(int x, int y) {
            return x * n + y;
        }

        public int[] point(int index) {
            int x = index / n;
            int y = index % n;
            return new int[] { x, y };
        }

    }

    static class Solution2 {

        private int n;

        // 标记是否已经找到可行解
        private boolean found;

        // 记录每行已经出现的数字
        // 比如 rows[0] = {1, 2, 3} 表示第 0 行已经出现了数字 1, 2, 3
        private final List<Set<Character>> rows;

        // 记录每列已经出现的数字
        private final List<Set<Character>> cols;

        // 记录每个九宫格已经出现的数字
        private final List<Set<Character>> boxes;

        public Solution2() {
            found = false;
            rows = new ArrayList<>(9);
            cols = new ArrayList<>(9);
            boxes = new ArrayList<>(9);
            for (int i = 0; i < 9; i++) {
                rows.add(new HashSet<>());
                cols.add(new HashSet<>());
                boxes.add(new HashSet<>());
            }
        }

        public void solveSudoku(char[][] board) {
            n = board.length;
            // 将预设数字加入集合
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        rows.get(i).add(board[i][j]);
                        cols.get(j).add(board[i][j]);
                        boxes.get(getBoxIndex(i, j)).add(board[i][j]);
                    }
                }
            }
            backtrack(board, 0);
        }

        // 路径：board 中小于 index 的位置所填的数字
        // 选择列表：数字 1~9
        // 结束条件：整个 board 都填满数字
        public void backtrack(char[][] board, int index) {

            // 已经找到一个可行解，立即结束
            if (found) { return; }

            // 找到一个可行解，触发 base case
            if (index == n * n) {
                found = true;
                return;
            }

            int row = index / n;
            int col = index % n;
            // 如果有预设数字，无需穷举
            if (board[row][col] != '.') {
                backtrack(board, index + 1);
                return;
            }

            for (char ch = '1'; ch <= '9'; ch++) {

                // 【剪枝】如果遇到不合法的数字，就跳过
                if (!isValid(row, col, ch)) { continue; }

                // 【选择】把 ch 填入 board[i][j]
                board[row][col] = ch;
                rows.get(row).add(ch);
                cols.get(col).add(ch);
                boxes.get(getBoxIndex(row, col)).add(ch);

                backtrack(board, index + 1);
                if (found) {
                    // 如果找到一个可行解，立即结束
                    // 不要撤销选择，否则 board[i][j] 会被重置为 '.'
                    return;
                }

                // 【取消选择】把 board[i][j] 重置为 '.'
                board[row][col] = '.';
                rows.get(row).remove(ch);
                cols.get(col).remove(ch);
                boxes.get(getBoxIndex(row, col)).remove(ch);
            }
        }

        // 获取 (row, col) 所在的九宫格索引
        public int getBoxIndex(int row, int col) {
            return (row / 3) * 3 + (col / 3);
        }

        // 判断是否可以在 (row, col) 位置放置数字 num
        public boolean isValid(int row, int col, char num) {
            // 现在只需要查询三次哈希表即可
            if (rows.get(row).contains(num)) { return false; }
            if (cols.get(col).contains(num)) { return false; }
            if (boxes.get(getBoxIndex(row, col)).contains(num)) { return false; }
            return true;
        }

    }

}
