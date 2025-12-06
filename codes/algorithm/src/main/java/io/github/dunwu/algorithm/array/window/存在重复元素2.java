package io.github.dunwu.algorithm.array.window;

import org.junit.jupiter.api.Assertions;

import java.util.HashSet;

/**
 * <a href="https://leetcode.cn/problems/contains-duplicate-ii/">219. 存在重复元素 II</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-15
 */
public class 存在重复元素2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertTrue(s.containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));
        Assertions.assertTrue(s.containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1));
        Assertions.assertFalse(s.containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2));
        Assertions.assertTrue(s.containsNearbyDuplicate(new int[] { 99, 99 }, 2));
    }

    static class Solution {

        public boolean containsNearbyDuplicate(int[] nums, int k) {

            // base case
            if (nums == null || nums.length < 2) { return false; }

            int left = 0, right = 0;
            HashSet<Integer> window = new HashSet<>();
            // 滑动窗口算法框架，维护一个大小为 k 的窗口
            while (right < nums.length) {
                // 扩大窗口
                if (window.contains(nums[right])) { return true; }
                window.add(nums[right]);
                right++;

                if (right - left > k) {
                    // 当窗口的大小大于 k 时，缩小窗口
                    window.remove(nums[left]);
                    left++;
                }
            }
            return false;
        }

    }

}
