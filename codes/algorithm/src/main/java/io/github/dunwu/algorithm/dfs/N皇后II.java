package io.github.dunwu.algorithm.dfs;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/n-queens-ii/">52. N皇后II</a>
 * @since 2020-07-04
 */
public class N皇后II {

    int[] cols;
    int[] first;
    int[] second;
    int[] queens;
    List<List<String>> output = new ArrayList<>();

    public static void main(String[] args) {
        N皇后II demo = new N皇后II();
        int result = demo.totalNQueens(4);
        Assertions.assertEquals(2, result);
    }

    public int totalNQueens(int n) {
        List<List<String>> lists = solveNQueens(n);
        return lists.size();
    }

    public List<List<String>> solveNQueens(int n) {
        queens = new int[n];
        cols = new int[n];
        first = new int[2 * n];
        second = new int[2 * n];
        backtrack(n, 0);
        return output;
    }

    public void backtrack(int n, int row) {
        if (row >= n) { return; }
        for (int col = 0; col < n; col++) {
            if (cols[col] == 1 || first[row + col] == 1 || second[row - col + n - 1] == 1) { continue;}

            queens[row] = col;
            cols[col] = 1;
            first[row + col] = 1;
            second[row - col + n - 1] = 1;

            backtrack(n, row + 1);
            if (row == n - 1) {
                output.add(addSolution(n));
            }

            queens[row] = 0;
            cols[col] = 0;
            first[row + col] = 0;
            second[row - col + n - 1] = 0;
        }
    }

    public List<String> addSolution(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (i == queens[j]) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            res.add(sb.toString());
        }
        return res;
    }

}
