package io.github.dunwu.algorithm.greedy;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/maximum-subarray/">53. 最大子数组和</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-10
 */
public class 跳跃游戏2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertTrue(s.canJump(new int[] { 2, 3, 1, 1, 4 }));
    }

    static class Solution {

        public boolean canJump(int[] nums) {
            int farthest = 0;
            for (int i = 0; i < nums.length; i++) {
                farthest = Math.max(farthest, i + nums[i]);
                if (farthest <= i) return false;
            }
            return farthest >= nums.length - 1;
        }

    }

}
