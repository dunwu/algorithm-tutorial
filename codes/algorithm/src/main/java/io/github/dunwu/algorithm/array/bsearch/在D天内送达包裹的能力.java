package io.github.dunwu.algorithm.array.bsearch;

import org.junit.jupiter.api.Assertions;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/">1011. 在 D 天内送达包裹的能力</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-08-06
 */
public class 在D天内送达包裹的能力 {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        // Assertions.assertEquals(5, f(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 15));
        // Assertions.assertEquals(3, f(new int[] { 3, 2, 2, 4, 1, 4 }, 6));
        // Assertions.assertEquals(4, f(new int[] { 1, 2, 3, 1, 1 }, 3));

        Assertions.assertEquals(15, shipWithinDays(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 5));
        Assertions.assertEquals(6, shipWithinDays(new int[] { 3, 2, 2, 4, 1, 4 }, 3));
        Assertions.assertEquals(3, shipWithinDays(new int[] { 1, 2, 3, 1, 1 }, 4));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (f(weights, mid) == days) {
                right = mid - 1;
            } else if (f(weights, mid) < days) {
                right = mid - 1;
            } else if (f(weights, mid) > days) {
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
