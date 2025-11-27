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
        Solution s = new Solution();
        int[][] input = { { 2, 1, 5 }, { 3, 3, 7 } };
        Assertions.assertFalse(s.carPooling(input, 3));
        int[][] input2 = { { 1, 2, 10 }, { 2, 2, 15 } };
        Assertions.assertTrue(s.carPooling(input2, 5));
    }

    static class Solution {

        public boolean carPooling(int[][] trips, int capacity) {
            // 最多有 1000 个车站
            int[] nums = new int[1001];
            // 构造差分解法
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
                df.increment(i, j, val);
            }

            int[] res = df.result();

            // 客车自始至终都不应该超载
            for (int i = 0; i < res.length; i++) {
                if (capacity < res[i]) {
                    return false;
                }
            }
            return true;
        }

        // 差分数组工具类
        static class Difference {

            // 差分数组
            private final int[] diff;

            // 输入一个初始数组，区间操作将在这个数组上进行
            public Difference(int[] nums) {
                assert nums.length > 0;
                diff = new int[nums.length];
                // 根据初始数组构造差分数组
                diff[0] = nums[0];
                for (int i = 1; i < nums.length; i++) {
                    diff[i] = nums[i] - nums[i - 1];
                }
            }

            // 给闭区间 [i, j] 增加 val（可以是负数）
            public void increment(int i, int j, int val) {
                diff[i] += val;
                if (j + 1 < diff.length) {
                    diff[j + 1] -= val;
                }
            }

            // 返回结果数组
            public int[] result() {
                int[] res = new int[diff.length];
                // 根据差分数组构造结果数组
                res[0] = diff[0];
                for (int i = 1; i < diff.length; i++) {
                    res[i] = res[i - 1] + diff[i];
                }
                return res;
            }

        }

    }

}
