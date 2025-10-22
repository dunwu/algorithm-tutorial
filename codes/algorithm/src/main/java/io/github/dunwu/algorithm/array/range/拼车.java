package io.github.dunwu.algorithm.array.range;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/car-pooling/">1094. 屁车</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-17
 */
public class 拼车 {

    public static void main(String[] args) {
        int[][] bookings = { { 2, 1, 5 }, { 3, 3, 7 } };
        Assertions.assertFalse(carPooling(bookings, 4));

        int[][] bookings2 = { { 1, 2, 10 }, { 2, 2, 15 } };
        Assertions.assertTrue(carPooling(bookings2, 5));
    }

    public static boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1001];
        Difference df = new Difference(nums);
        for (int[] trip : trips) {
            // 乘客数量
            int val = trip[0];
            // 第 trip[1] 站乘客上车
            int i = trip[1];
            // 第 trip[2] 站乘客已经下车，
            // 即乘客在车上的区间是 [trip[1], trip[2] - 1]
            int j = trip[2] - 1;
            // 进行区间操作
            df.increase(i, j, val);
        }
        int[] result = df.result();

        // 客车自始至终都不应该超载
        for (int res : result) {
            if (capacity < res) {
                return false;
            }
        }
        return true;
    }

    static class Difference {

        private int[] diff;

        public Difference(int[] nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < diff.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        public void increase(int left, int right, int val) {
            diff[left - 1] += val;
            if (right < diff.length) {
                diff[right] -= val;
            }
        }

        public int[] result() {
            int[] result = new int[diff.length];
            result[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                result[i] = result[i - 1] + diff[i];
            }
            return result;
        }

    }

}
