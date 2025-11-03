package io.github.dunwu.algorithm.backtrack;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.List;

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

        public void solveSudoku(char[][] board) {

        }

        public void backtrack(char[][] board, LinkedList<Integer> track, boolean[] used) {

        }

    }

}
