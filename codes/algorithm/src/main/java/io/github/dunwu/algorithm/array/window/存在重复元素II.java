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
public class 存在重复元素II {

    public static void main(String[] args) {
        Assertions.assertTrue(containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));
        Assertions.assertTrue(containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1));
        Assertions.assertFalse(containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2));
        Assertions.assertTrue(containsNearbyDuplicate(new int[] { 99, 99 }, 2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) return false;
        int left = 0, right = 0;
        Set<Integer> set = new HashSet<>();
        while (right < nums.length) {
            if (!set.add(nums[right])) {
                return true;
            }
            right++;

            if (right - left > k) {
                set.remove(nums[left]);
                left++;
            }
        }
        return false;
    }

    /**
     * 效率为 O(N^2)
     */
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (nums == null || nums.length < 2) return false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && Math.abs(j - i) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

}
