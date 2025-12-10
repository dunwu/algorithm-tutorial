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
        Solution s = new Solution();
        Assertions.assertEquals(2, s.minOperations(new int[] { 1, 1, 4, 2, 3 }, 5));
        Assertions.assertEquals(-1, s.minOperations(new int[] { 5, 6, 7, 8, 9 }, 4));
        Assertions.assertEquals(5, s.minOperations(new int[] { 3, 2, 20, 1, 1, 3 }, 10));
        Assertions.assertEquals(16, s.minOperations(new int[] { 8828, 9581, 49, 9818, 9974, 9869, 9991,
            10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309 }, 134365));
    }

    static class Solution {

        // 【思路】
        // 从边缘删除掉和为 x 的元素，那剩下来的是什么？剩下来的是不是就是 nums 中的一个子数组？
        // 让你尽可能少地从边缘删除元素说明什么？是不是就是说剩下来的这个子数组大小尽可能的大？
        // 所以，这道题等价于让你寻找 nums 中元素和为 sum(nums) - x 的最长子数组。

        // 1、当窗口内元素之和小于目标和 target 时，扩大窗口，让窗口内元素和增加。
        // 2、当窗口内元素之和大于目标和 target 时，缩小窗口，让窗口内元素和减小。
        // 3、当窗口内元素之和等于目标和 target 时，找到一个符合条件的子数组，我们想找的是最长的子数组长度。
        public int minOperations(int[] nums, int x) {
            int n = nums.length, sum = 0;
            for (int num : nums) { sum += num; }
            // 滑动窗口需要寻找的子数组目标和
            int target = sum - x;

            int left = 0, right = 0;
            // 记录窗口内所有元素和
            int windowSum = 0;
            // 记录目标子数组的最大长度
            int maxLen = Integer.MIN_VALUE;
            // 开始执行滑动窗口框架
            while (right < nums.length) {
                // 扩大窗口
                windowSum += nums[right];
                right++;

                while (windowSum > target && left < right) {
                    // 缩小窗口
                    windowSum -= nums[left];
                    left++;
                }
                // 寻找目标子数组
                if (windowSum == target) {
                    maxLen = Math.max(maxLen, right - left);
                }
            }
            // 目标子数组的最大长度可以推导出需要删除的字符数量
            return maxLen == Integer.MIN_VALUE ? -1 : n - maxLen;
        }

    }

}
