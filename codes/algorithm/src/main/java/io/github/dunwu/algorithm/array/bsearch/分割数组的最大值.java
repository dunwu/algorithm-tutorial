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
        Assertions.assertEquals(18, splitArray(new int[] { 7, 2, 5, 10, 8 }, 2));
        Assertions.assertEquals(9, splitArray(new int[] { 1, 2, 3, 4, 5 }, 2));
        Assertions.assertEquals(4, splitArray(new int[] { 1, 4, 4 }, 3));
    }

    public static int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        for (int w : nums) {
            left = Math.max(left, w);
            right += w;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (f(nums, mid) == k) {
                right = mid - 1;
            } else if (f(nums, mid) < k) {
                right = mid - 1;
            } else if (f(nums, mid) > k) {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int f(int[] weights, int x) {
        int days = 0;
        for (int i = 0; i < weights.length; ) {
            int cap = x;
            while (i < weights.length) {
                if (cap < weights[i]) {
                    break;
                } else {
                    cap -= weights[i];
                }
                i++;
            }
            days++;
        }
        return days;
    }

}
