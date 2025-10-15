package io.github.dunwu.algorithm.array.window;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/">1004. 最大连续1的个数 III</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-14
 */
public class 最大连续1的个数III {

    public static void main(String[] args) {
        Assertions.assertEquals(6, longestOnes(new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 2));
        Assertions.assertEquals(10,
            longestOnes(new int[] { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, 3));
    }

    public static int longestOnes(int[] nums, int k) {
        int max = 0;
        int zeroCnt = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            int r = nums[right];
            right++;
            if (r == 0) zeroCnt++;

            while (zeroCnt > k) {
                int l = nums[left];
                left++;
                if (l == 0) zeroCnt--;
            }

            max = Math.max(max, right - left);
        }
        return max;
    }

}
