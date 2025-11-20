package io.github.dunwu.algorithm.array.two_pointer;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/">167. 两数之和 II - 输入有序数组</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-05
 */
public class 两数之和2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new int[] { 1, 2 }, s.twoSum(new int[] { 2, 7, 11, 15 }, 9));
        Assertions.assertArrayEquals(new int[] { 1, 3 }, s.twoSum(new int[] { 2, 3, 4 }, 6));
        Assertions.assertArrayEquals(new int[] { 1, 2 }, s.twoSum(new int[] { -1, 0 }, -1));

        Solution2 s2 = new Solution2();
        Assertions.assertArrayEquals(new int[] { 1, 2 }, s2.twoSum(new int[] { 2, 7, 11, 15 }, 9));
        Assertions.assertArrayEquals(new int[] { 1, 3 }, s2.twoSum(new int[] { 2, 3, 4 }, 6));
        Assertions.assertArrayEquals(new int[] { 1, 2 }, s2.twoSum(new int[] { -1, 0 }, -1));
    }

    /**
     * Hash 存值、下标，一次 for 循环，每次判断 map 中是否有值和当前下标的值凑成 target
     */
    static class Solution {

        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                int diff = target - nums[i];
                if (map.containsKey(diff)) {
                    return new int[] { map.get(diff), i + 1 };
                } else {
                    map.put(nums[i], i + 1);
                }
            }
            return new int[0];
        }

    }

    /**
     * 双指针
     */
    static class Solution2 {

        public int[] twoSum(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    return new int[] { left + 1, right + 1 };
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
            return new int[0];
        }

    }

}
