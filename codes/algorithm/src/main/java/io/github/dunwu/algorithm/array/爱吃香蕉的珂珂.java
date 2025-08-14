package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

import java.lang.reflect.InvocationTargetException;

/**
 * <a href="https://leetcode.cn/problems/koko-eating-bananas/">875. 爱吃香蕉的珂珂</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-08-06
 */
public class 爱吃香蕉的珂珂 {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Assertions.assertEquals(4, minEatingSpeed(new int[] { 3, 6, 7, 11 }, 8));
        Assertions.assertEquals(30, minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 5));
        Assertions.assertEquals(23, minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 6));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1000000000 + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(piles, mid) == h) {
                // 搜索左侧边界，则需要收缩右侧边界
                right = mid;
            } else if (f(piles, mid) < h) {
                // 需要让 f(x) 的返回值大一些
                right = mid;
            } else if (f(piles, mid) > h) {
                // 需要让 f(x) 的返回值小一些
                left = mid + 1;
            }
        }
        return left;
    }

    public static long f(int[] arr, int x) {
        long hours = 0;
        for (int j : arr) {
            hours += j / x;
            if (j % x > 0) {
                hours++;
            }
        }
        return hours;
    }

}
