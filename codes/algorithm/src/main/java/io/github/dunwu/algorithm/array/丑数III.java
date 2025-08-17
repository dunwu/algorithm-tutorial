package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/ugly-number-ii/">264. 丑数II</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-01-24
 */
public class 丑数III {

    public static void main(String[] args) {
        Assertions.assertEquals(4, nthUglyNumber(3, 2, 3, 5));
        Assertions.assertEquals(6, nthUglyNumber(4, 2, 3, 4));
        Assertions.assertEquals(10, nthUglyNumber(5, 2, 11, 13));
        Assertions.assertEquals(1999999984, nthUglyNumber(1000000000, 2, 217983653, 336916467));
    }

    public static int nthUglyNumber(int n, int a, int b, int c) {
        int p = 1;
        int vA = a, vB = b, vC = c;
        long min = Integer.MAX_VALUE;
        while (p <= n) {
            min = Math.min(vA, Math.min(vB, vC));
            if (min == vA) {
                vA += a;
            }
            if (min == vB) {
                vB += b;
            }
            if (min == vC) {
                vC += c;
            }
            p++;
        }
        return (int) min;
    }

}
