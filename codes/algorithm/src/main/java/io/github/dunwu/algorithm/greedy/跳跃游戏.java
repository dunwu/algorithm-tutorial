package io.github.dunwu.algorithm.greedy;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/jump-game/">55. 跳跃游戏</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-10
 */
public class 跳跃游戏 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(2, s.jump(new int[] { 2, 3, 1, 1, 4 }));
    }

    static class Solution {

        int[] memo;

        public int jump(int[] nums) {
            if (nums.length <= 1) {
                return 0;
            }
            int n = nums.length;
            // 备忘录都初始化为 n，相当于 INT_MAX
            // 因为从 0 跳到 n - 1 最多 n - 1 步
            memo = new int[n];
            Arrays.fill(memo, n);

            return dp(nums, 0);
        }

        int dp(int[] nums, int p) {
            int n = nums.length;
            if (p >= n - 1) {
                return 0;
            }

            int steps = nums[p];
            // 你可以选择跳 1 步，2 步...
            for (int i = 1; i <= steps; i++) {
                // 穷举每一个选择
                // 计算每一个子问题的结果
                int sub = dp(nums, p + i);
                // 取其中最小的作为最终结果
                memo[p] = Math.min(memo[p], sub + 1);
            }
            return memo[p];
        }

    }

}
