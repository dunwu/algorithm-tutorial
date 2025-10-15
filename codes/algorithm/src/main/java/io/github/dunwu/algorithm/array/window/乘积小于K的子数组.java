package io.github.dunwu.algorithm.array.window;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/subarray-product-less-than-k/">713. 乘积小于 K 的子数组</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-14
 */
public class 乘积小于K的子数组 {

    public static void main(String[] args) {
        Assertions.assertEquals(8, numSubarrayProductLessThanK(new int[] { 10, 5, 2, 6 }, 100));
        Assertions.assertEquals(0, numSubarrayProductLessThanK(new int[] { 1, 2, 3 }, 0));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        // 窗口游标
        int left = 0, right = 0;
        // 窗口乘积
        int multi = 1;
        // 符合要求的结果
        int result = 0;
        while (right < nums.length) {
            // 扩大窗口
            multi *= nums[right++];

            while (multi >= k && left < right) {
                multi = multi / nums[left++];
            }

            result += right - left;
            // System.out.format("left: %d, right: %d\n", left, right);
        }
        return result;
    }

}
