package io.github.dunwu.algorithm.array.range;

import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/corporate-flight-bookings/">1109. 航班预订统计</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-17
 */
public class 航班预订统计 {

    public static void main(String[] args) {
        int[][] bookings = { { 1, 2, 10 }, { 2, 3, 20 }, { 2, 5, 25 } };
        Assertions.assertArrayEquals(new int[] { 10, 55, 45, 25, 25 }, corpFlightBookings(bookings, 5));

        int[][] bookings2 = { { 1, 2, 10 }, { 2, 2, 15 } };
        Assertions.assertArrayEquals(new int[] { 10, 25 }, corpFlightBookings(bookings2, 2));
    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] array = new int[n];
        for (int[] order : bookings) {
            int left = order[0], right = order[1], num = order[2];
            array[left - 1] += num;
            if (right < n) {
                array[right] -= num;
            }
            // System.out.println("array: " + JSONUtil.toJsonStr(array));
        }
        int[] result = new int[n];
        result[0] = array[0];
        for (int i = 1; i < n; i++) {
            result[i] = array[i] + result[i - 1];
        }
        // System.out.println("result: " + JSONUtil.toJsonStr(result));
        return result;
    }

}
