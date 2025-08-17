package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/super-ugly-number/">313. 超级丑数</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-01-24
 */
public class 超级丑数 {

    public static void main(String[] args) {
        Assertions.assertEquals(32, nthSuperUglyNumber(12, new int[] { 2, 7, 13, 19 }));
        Assertions.assertEquals(1, nthSuperUglyNumber(1, new int[] { 2, 3, 5 }));
    }

    public static int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] offsets = new int[len];
        long[] values = new long[len];
        long[] ugly = new long[n + 1];
        int u = 1;
        for (int i = 0; i < len; i++) {
            offsets[i] = 1;
            values[i] = 1;
        }
        while (u <= n) {
            long min = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                min = Math.min(values[i], min);
            }
            ugly[u++] = min;

            for (int i = 0; i < len; i++) {
                if (values[i] == min) {
                    values[i] = primes[i] * ugly[offsets[i]];
                    offsets[i] = offsets[i] + 1;
                }
            }
        }
        return (int) ugly[n];
    }

}
