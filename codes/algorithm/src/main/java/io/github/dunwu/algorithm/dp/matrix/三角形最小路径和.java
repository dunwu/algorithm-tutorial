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

        // 给定一个三角形 triangle ，找出自顶向下的最小路径和。

        // 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
        // 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
    }

    static class Solution {

        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[][] dp = new int[n][n];
            dp[0][0] = triangle.get(0).get(0);
            for (int i = 1; i < n; ++i) {
                dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
                for (int j = 1; j < i; ++j) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
                dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
            }
            int min = dp[n - 1][0];
            for (int i = 1; i < n; ++i) {
                min = Math.min(min, dp[n - 1][i]);
            }
            return min;
        }

    }

}
