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
            return shipWithinDays(nums, k);
        }

        public int shipWithinDays(int[] weights, int days) {
            int max = 0, sum = 0;
            for (int weight : weights) {
                max = Math.max(max, weight);
                sum += weight;
            }

            int left = max, right = sum;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (f(weights, mid) <= days) {
                    // 需要让 f(x) 的返回值大一些
                    right = mid - 1;
                } else if (f(weights, mid) > days) {
                    // 需要让 f(x) 的返回值小一些
                    left = mid + 1;
                }
            }
            return left;
        }

        // 定义：当运载能力为 x 时，需要 f(x) 天运完所有货物
        // f(x) 随着 x 的增加单调递减
        int f(int[] weights, int x) {
            int days = 0;
            for (int i = 0; i < weights.length; ) {
                // 尽可能多装货物
                int cap = x;
                while (i < weights.length) {
                    if (cap < weights[i]) break;
                    else cap -= weights[i];
                    i++;
                }
                days++;
            }
            return days;
        }

    }

}
