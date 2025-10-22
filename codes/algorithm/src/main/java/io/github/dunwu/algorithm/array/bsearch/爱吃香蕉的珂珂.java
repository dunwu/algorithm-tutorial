package io.github.dunwu.algorithm.array.bsearch;

import org.junit.jupiter.api.Assertions;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

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
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (fun(piles, mid) == h) {
                right = mid - 1;
            } else if (fun(piles, mid) < h) {
                right = mid - 1;
            } else if (fun(piles, mid) > h) {
                left = mid + 1;
            }
        }
        return left;
    }

    public static long fun(int[] piles, int speed) {
        long hour = 0L;
        for (int pile : piles) {
            if (pile <= speed) {
                hour++;
            } else {
                hour += pile / speed;
                if (pile % speed != 0) {
                    hour++;
                }
            }
        }
        return hour;
    }

}
