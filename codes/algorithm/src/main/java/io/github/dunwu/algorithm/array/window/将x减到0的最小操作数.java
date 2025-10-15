package io.github.dunwu.algorithm.array.window;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/">1658. 将 x 减到 0 的最小操作数</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-14
 */
public class 将x减到0的最小操作数 {

    public static void main(String[] args) {
        Assertions.assertEquals(2, minOperations(new int[] { 1, 1, 4, 2, 3 }, 5));
        Assertions.assertEquals(-1, minOperations(new int[] { 5, 6, 7, 8, 9 }, 4));
        Assertions.assertEquals(5, minOperations(new int[] { 3, 2, 20, 1, 1, 3 }, 10));
    }

    public static int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum - x;
        int windowSum = 0;
        int maxLen = Integer.MIN_VALUE;
        int left = 0, right = 0;

        while (right < nums.length) {
            windowSum += nums[right];
            right++;

            while (windowSum > target && left < right) {
                windowSum -= nums[left];
                left++;
            }

            if (windowSum == target) {
                maxLen = Math.max(maxLen, right - left);
            }
        }
        return maxLen == Integer.MIN_VALUE ? -1 : nums.length - maxLen;
    }

}
