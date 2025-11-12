package io.github.dunwu.algorithm.dp;

import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-05
 */
public class 乘积最大子数组 {

    public static void main(String[] args) {
        int[] nums = { 2, 3, -2, 4 };
        int[] nums2 = { -2, 0, -1 };
        // Assertions.assertEquals(6, maxProduct(nums));
        Assertions.assertEquals(6, maxProduct2(nums));
        Assertions.assertEquals(0, maxProduct2(nums2));
    }

    public static int maxProduct(int[] nums) {
        return backtrack(nums, 0, 0, 1, 0);
    }

    // 递归 + 回溯 暴力破解
    // 时间复杂度 O(2^N)
    public static int backtrack(int[] nums, int begin, int end, int res, int max) {
        if (end >= nums.length || begin > end) return max;
        res *= nums[end];
        if (res > max) {
            return backtrack(nums, begin, end + 1, res, res);
        } else {
            return backtrack(nums, end + 1, end + 1, 1, max);
        }
    }

    public static int maxProduct2(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int currMax = Math.max(Math.max(nums[i] * max, nums[i] * min), nums[i]);
            int currMin = Math.min(Math.min(nums[i] * max, nums[i] * min), nums[i]);
            res = Math.max(currMax, res);
            max = currMax;
            min = currMin;
        }
        return res;
    }

}
