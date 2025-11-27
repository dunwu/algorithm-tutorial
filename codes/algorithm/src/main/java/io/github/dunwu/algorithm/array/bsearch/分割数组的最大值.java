package io.github.dunwu.algorithm.array.bsearch;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/split-array-largest-sum/">410. 分割数组的最大值</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-16
 */
public class 分割数组的最大值 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(18, s.splitArray(new int[] { 7, 2, 5, 10, 8 }, 2));
        Assertions.assertEquals(9, s.splitArray(new int[] { 1, 2, 3, 4, 5 }, 2));
        Assertions.assertEquals(4, s.splitArray(new int[] { 1, 4, 4 }, 3));
    }

    static class Solution {

        public int splitArray(int[] nums, int k) {
            int left = 0;
            int right = 1;
            for (int w : nums) {
                left = Math.max(left, w);
                right += w;
            }

            int res = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (f(nums, mid) <= k) {
                    res = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return res;
        }

        public int f(int[] nums, int x) {
            int i = 0;
            int days = 0;
            while (i < nums.length) {
                // 尽可能多装货物
                int cap = x;
                while (i < nums.length) {
                    if (cap < nums[i]) {
                        break;
                    } else {
                        cap -= nums[i];
                    }
                    i++;
                }
                days++;
            }
            return days;
        }

    }

}
