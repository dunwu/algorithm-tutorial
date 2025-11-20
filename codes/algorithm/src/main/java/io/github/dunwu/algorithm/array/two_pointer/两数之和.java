package io.github.dunwu.algorithm.array.two_pointer;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/two-sum/">1. 两数之和</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-05
 */
public class 两数之和 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new int[] { 0, 1 }, s.twoSum(new int[] { 2, 7, 11, 15 }, 9));
        Assertions.assertArrayEquals(new int[] { 1, 2 }, s.twoSum(new int[] { 3, 2, 4 }, 6));
        Assertions.assertArrayEquals(new int[] { 0, 1 }, s.twoSum(new int[] { 3, 3 }, 6));

        Solution2 s2 = new Solution2();
        Assertions.assertArrayEquals(new int[] { 0, 1 }, s2.twoSum(new int[] { 2, 7, 11, 15 }, 9));
        Assertions.assertArrayEquals(new int[] { 1, 2 }, s2.twoSum(new int[] { 3, 2, 4 }, 6));
        Assertions.assertArrayEquals(new int[] { 0, 1 }, s2.twoSum(new int[] { 3, 3 }, 6));
    }

    /**
     * 两次 for 循环暴力求解，时间复杂度 o(n^2)
     */
    static class Solution {

        public int[] twoSum(int[] nums, int target) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[] { i, j };
                    }
                }
            }
            return new int[0];
        }

    }

    /**
     * Hash 存值、下标，一次 for 循环，每次判断 map 中是否有值和当前下标的值凑成 target
     */
    static class Solution2 {

        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                int diff = target - nums[i];
                if (map.containsKey(diff)) {
                    return new int[] { map.get(diff), i };
                } else {
                    map.put(nums[i], i);
                }
            }
            return new int[0];
        }

    }

}
