package io.github.dunwu.algorithm.dp.fib;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/house-robber/">198. 打家劫舍</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-10
 */
public class 打家劫舍 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(4, s.rob(new int[] { 1, 2, 3, 1 }));
        Assertions.assertEquals(12, s.rob(new int[] { 2, 7, 9, 3, 1 }));
        Assertions.assertEquals(1, s.rob(new int[] { 1, 1 }));
    }

    static class Solution {

        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) { return 0; }
            if (nums.length == 1) { return nums[0]; }
            int N = nums.length;
            int first = nums[0], second = Math.max(nums[0], nums[1]);
            for (int i = 2; i < N; i++) {
                int tmp = Math.max(second, first + nums[i]);
                first = second;
                second = tmp;
            }
            return second;
        }

    }

}
