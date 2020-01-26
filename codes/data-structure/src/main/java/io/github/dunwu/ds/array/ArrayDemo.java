package io.github.dunwu.ds.array;

import java.util.Arrays;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-20
 */
public class ArrayDemo {

    public static int maxSubArray(int[] nums) {
        int len = nums.length;

        int maxSum = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int max = maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 });
        System.out.println("max = " + max);
    }

}
