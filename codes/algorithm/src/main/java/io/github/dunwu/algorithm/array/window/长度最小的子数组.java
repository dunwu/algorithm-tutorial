package io.github.dunwu.algorithm.array.window;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/">209. 长度最小的子数组</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-15
 */
public class 长度最小的子数组 {

    public static void main(String[] args) {
        Assertions.assertEquals(2, minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
        Assertions.assertEquals(1, minSubArrayLen(4, new int[] { 1, 4, 4 }));
        Assertions.assertEquals(0, minSubArrayLen(11, new int[] { 1, 1, 1, 1, 1, 1, 1, 1 }));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        // System.out.println("================================");
        int sum = 0;
        int minSize = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while (right < nums.length) {

            // sum 小于 target 扩大窗口
            sum += nums[right++];

            // sum 大于等于 target 扩大窗口
            while (sum >= target) {
                minSize = Math.min(minSize, right - left);
                // System.out.format("left: %d, right: %d, minSize: %d, sum: %d\n",
                //     left, right, minSize, sum);

                sum -= nums[left];
                left++;
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }

}
