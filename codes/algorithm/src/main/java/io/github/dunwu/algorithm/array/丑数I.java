package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/ugly-number/">263. 丑数</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-01-24
 */
public class 丑数I {

    public static void main(String[] args) {
        Assertions.assertTrue(isUgly(6));
        Assertions.assertTrue(isUgly(1));
        Assertions.assertFalse(isUgly(14));
    }

    public static boolean isUgly(int n) {
        while (n <= 0) return false;
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;
        return n == 1;
    }

}
