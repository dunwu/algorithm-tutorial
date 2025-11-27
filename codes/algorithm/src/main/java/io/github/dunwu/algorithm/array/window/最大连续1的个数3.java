package io.github.dunwu.algorithm.array.window;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/">1004. 最大连续1的个数 III</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-14
 */
public class 最大连续1的个数3 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(6, s.longestOnes(new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 2));
        Assertions.assertEquals(10,
            s.longestOnes(new int[] { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, 3));
    }

    static class Solution {

        public int longestOnes(int[] nums, int k) {
            int cnt = 0, len = 0;
            int left = 0, right = 0;
            while (right < nums.length) {
                if (nums[right] == 0) { cnt++; }
                right++;

                while (cnt > k) {
                    if (nums[left] == 0) { cnt--; }
                    left++;
                }
                len = Math.max(len, right - left);
            }
            return len;
        }

    }

}
