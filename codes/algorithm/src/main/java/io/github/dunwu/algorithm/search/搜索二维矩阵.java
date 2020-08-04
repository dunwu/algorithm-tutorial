package io.github.dunwu.algorithm.search;

import org.junit.jupiter.api.Assertions;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-13
 */
public class 搜索二维矩阵 {

    public static void main(String[] args) {
        int[][] metrix = {
            { 1, 3, 5, 7 },
            { 10, 11, 16, 20 },
            { 23, 30, 34, 50 }
        };
        Assertions.assertTrue(searchMatrix(metrix, 3));
        Assertions.assertFalse(searchMatrix(metrix, 13));
        // Assertions.assertEquals(1, searchMatrix(metrix, 2));
        // Assertions.assertEquals(4, searchMatrix(metrix, 7));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix.length;
        int columnLen = matrix[0].length;

        // 剪枝
        if (matrix[rowLen - 1][columnLen - 1] < target) {
            return false;
        }

        int rbegin = 0, rend = rowLen - 1;
        while (rbegin < rend) {
            int rmid = rbegin + (rend - rbegin) / 2;
            if (matrix[rmid][columnLen - 1] == target) {
                return true;
            } else if (matrix[rmid][columnLen - 1] < target) {
                rbegin = rmid + 1;
            } else {
                rend = rmid;
            }
        }

        int cbegin = 0, cend = columnLen - 1;
        while (cbegin < cend) {
            int cmid = cbegin + (cend - cbegin) / 2;
            if (matrix[rbegin][cmid] == target) {
                return true;
            } else if (matrix[rbegin][cmid] < target) {
                cbegin = cmid + 1;
            } else {
                cend = cmid;
            }
        }

        return false;
    }

}
