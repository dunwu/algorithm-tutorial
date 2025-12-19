package io.github.dunwu.algorithm.stack.monotonic;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/car-fleet/">853. 车队</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-26
 */
public class 车位 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(3, s.carFleet(12, new int[] { 10, 8, 0, 5, 3 }, new int[] { 2, 4, 1, 1, 3 }));
        Assertions.assertEquals(1, s.carFleet(10, new int[] { 3 }, new int[] { 3 }));
        Assertions.assertEquals(1, s.carFleet(100, new int[] { 0, 2, 4 }, new int[] { 4, 2, 1 }));
    }

    static class Solution {

        public int carFleet(int target, int[] position, int[] speed) {

            int n = position.length;
            int[][] cars = new int[n][2];
            for (int i = 0; i < n; i++) {
                cars[i][0] = position[i];
                cars[i][1] = speed[i];
            }

            // 按照初始位置，从小到大排序
            Arrays.sort(cars, (int[] a, int[] b) -> {
                return Integer.compare(a[0], b[0]);
            });

            // 计算每辆车到达终点的时间
            double[] times = new double[n];
            for (int i = 0; i < n; i++) {
                int[] car = cars[i];
                times[i] = (double) (target - car[0]) / car[1];
            }

            // 使用单调栈计算车队的数量
            Stack<Double> s = new Stack<>();
            for (double t : times) {
                while (!s.isEmpty() && t >= s.peek()) {
                    s.pop();
                }
                s.push(t);
            }
            return s.size();

            // 避免使用栈模拟，倒序遍历取递增序列就是答案
            // int res = 0;
            // double maxTime = 0;
            // for (int i = n - 1; i >= 0; i--) {
            //     if (time[i] > maxTime) {
            //         maxTime = time[i];
            //         res++;
            //     }
            // }
            // return res;
        }

    }

}
