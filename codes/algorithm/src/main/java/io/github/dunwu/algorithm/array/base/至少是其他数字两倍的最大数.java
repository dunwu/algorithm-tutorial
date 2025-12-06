package io.github.dunwu.algorithm.array.base;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/largest-number-at-least-twice-of-others/">747. 至少是其他数字两倍的最大数</a>
 *
 * @author Zhang Peng
 * @since 2018-11-04
 */
public class 至少是其他数字两倍的最大数 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(1, s.dominantIndex(new int[] { 3, 6, 1, 0 }));
        Assertions.assertEquals(-1, s.dominantIndex(new int[] { 1, 2, 3, 4 }));
        Assertions.assertEquals(0, s.dominantIndex(new int[] { 1, 0 }));
    }

    static class Solution {

        public int dominantIndex(int[] nums) {
            int second = -1, max = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[max]) {
                    second = max;
                    max = i;
                } else if (second == -1 || nums[i] > nums[second]) {
                    second = i;
                }
            }
            return nums[max] >= 2 * nums[second] ? max : -1;
        }

    }

}
