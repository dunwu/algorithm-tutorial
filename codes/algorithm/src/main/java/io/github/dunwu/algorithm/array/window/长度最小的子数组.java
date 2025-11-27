package io.github.dunwu.algorithm.array.window;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/">209. 长度最小的子数组</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-15
 */
public class 长度最小的子数组 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(2, s.minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
        Assertions.assertEquals(1, s.minSubArrayLen(4, new int[] { 1, 4, 4 }));
        Assertions.assertEquals(0, s.minSubArrayLen(11, new int[] { 1, 1, 1, 1, 1, 1, 1, 1 }));
    }

    public static class Solution {

        public int minSubArrayLen(int target, int[] nums) {
            int left = 0, right = 0;
            // 维护窗口内元素之和
            int windowSum = 0;
            int res = Integer.MAX_VALUE;

            while (right < nums.length) {
                // 扩大窗口
                windowSum += nums[right];
                right++;
                while (windowSum >= target && left < right) {
                    // 已经达到 target，缩小窗口，同时更新答案
                    res = Math.min(res, right - left);
                    windowSum -= nums[left];
                    left++;
                }
            }
            return res == Integer.MAX_VALUE ? 0 : res;
        }

    }

}
