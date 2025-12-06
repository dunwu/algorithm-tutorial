package io.github.dunwu.algorithm.array.base;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/max-consecutive-ones/">485. 最大连续 1 的个数</a>
 *
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class 最大连续1的个数 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(3, s.findMaxConsecutiveOnes(new int[] { 1, 1, 0, 1, 1, 1 }));
        Assertions.assertEquals(2, s.findMaxConsecutiveOnes(new int[] { 1, 0, 1, 1, 0, 1 }));
    }

    static class Solution {

        public int findMaxConsecutiveOnes(int[] nums) {
            int max = 0;
            int cnt = 0;
            for (int num : nums) {
                if (num == 1) {
                    cnt++;
                    max = Math.max(max, cnt);
                } else {
                    cnt = 0;
                }
            }
            return max;
        }

    }

}
