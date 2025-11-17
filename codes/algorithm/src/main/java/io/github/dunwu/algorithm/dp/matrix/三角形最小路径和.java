package io.github.dunwu.algorithm.dp.matrix;

import io.github.dunwu.algorithm.util.ArrayUtil;
import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/triangle/">120. 三角形最小路径和</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-04
 */
public class 三角形最小路径和 {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> input = ArrayUtil.toListList(new int[][] { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } });
        Assertions.assertEquals(11, s.minimumTotal(input));
        List<List<Integer>> input2 = ArrayUtil.toListList(new int[][] { { -10 } });
        Assertions.assertEquals(-10, s.minimumTotal(input2));
    }

    static class Solution {

        public int minimumTotal(List<List<Integer>> triangle) {

            // base case
            if (triangle == null || triangle.size() == 0) { return 0; }
            if (triangle.size() == 1) { return triangle.get(0).get(0); }

            // 状态定义
            int n = triangle.size();
            int[][] dp = new int[n][n];

            // 初始状态
            dp[0][0] = triangle.get(0).get(0);

            // 状态转移方程
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                dp[i][0] = triangle.get(i).get(0) + dp[i - 1][0];
                for (int j = 1; j < i; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
                dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
            }

            for (int j = 0; j < n; j++) {
                min = Math.min(min, dp[n - 1][j]);
            }
            return min;
        }

    }

}
