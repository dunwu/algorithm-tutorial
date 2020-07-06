package io.github.dunwu.algorithm.dynamic;

import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/maximum-subarray/">53. 最大子序和</a>
 * @since 2020-07-06
 */
public class 最大子序和 {

    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        Assertions.assertEquals(6, maxSubArray(nums));
        Assertions.assertEquals(-1, maxSubArray(new int[] { -1 }));
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] >= 0 ? dp[i - 1] + nums[i] : nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

}
