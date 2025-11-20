package io.github.dunwu.algorithm.array.two_pointer;

import org.junit.jupiter.api.Assertions;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/">LCR 179. 查找总价格为目标值的两个商品</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-05
 */
public class 查找总价格为目标值的两个商品 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new int[] { 3, 15 }, s.twoSum(new int[] { 3, 9, 12, 15 }, 18));
        Assertions.assertArrayEquals(new int[] { 27, 34 }, s.twoSum(new int[] { 8, 21, 27, 34, 52, 66 }, 61));
    }

    static class Solution {

        public int[] twoSum(int[] nums, int target) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                int diff = target - num;
                if (set.contains(diff)) {
                    return new int[] { num, diff };
                } else {
                    set.add(num);
                }
            }
            return new int[0];
        }

    }

}
