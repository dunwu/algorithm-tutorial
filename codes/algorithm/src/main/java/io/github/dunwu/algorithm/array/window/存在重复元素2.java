package io.github.dunwu.algorithm.array.window;

import org.junit.jupiter.api.Assertions;

import java.util.HashSet;
import java.util.Set;

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
            int left = 0, right = 0;
            Set<Integer> set = new HashSet<>();
            while (right < nums.length) {
                if (set.contains(nums[right])) {
                    return true;
                }
                set.add(nums[right]);
                right++;

                if (right - left > k) {
                    set.remove(nums[left]);
                    left++;
                }
            }
            return false;
        }

    }

}
