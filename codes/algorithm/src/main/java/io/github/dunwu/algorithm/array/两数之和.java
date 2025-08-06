package io.github.dunwu.algorithm.array;

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
        Assertions.assertArrayEquals(new int[] { 0, 1 }, twoSumInSorted(new int[] { 2, 7, 11, 15 }, 9));
        Assertions.assertArrayEquals(new int[] { 1, 2 }, twoSumInSorted(new int[] { 3, 2, 4 }, 6));
        Assertions.assertArrayEquals(new int[] { 0, 1 }, twoSumInSorted(new int[] { 3, 3 }, 6));

        Assertions.assertArrayEquals(new int[] { 0, 1 }, twoSumInSorted2(new int[] { 2, 7, 11, 15 }, 9));
        Assertions.assertArrayEquals(new int[] { 1, 2 }, twoSumInSorted2(new int[] { 3, 2, 4 }, 6));
        Assertions.assertArrayEquals(new int[] { 0, 1 }, twoSumInSorted2(new int[] { 3, 3 }, 6));
    }

    /**
     * 时间复杂度：O(n^2)
     */
    public static int[] twoSumInSorted(int[] nums, int target) {
        for (int left = 0; left < nums.length; left++) {
            for (int right = left + 1; right < nums.length; right++) {
                if (nums[left] + nums[right] == target) {
                    return new int[] { left, right };
                }
            }
        }
        return new int[] {};
    }

    /**
     * 时间复杂度：O(n)
     */
    public static int[] twoSumInSorted2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[] { map.get(diff), i };
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {};
    }

}
