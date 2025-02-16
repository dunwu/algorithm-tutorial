package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/ugly-number-ii/description/">264. 丑数II</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-01-24
 */
public class 丑数II {

    public static void main(String[] args) {
        Assertions.assertEquals(12, nthUglyNumber(10));
        Assertions.assertEquals(1, nthUglyNumber(1));
    }

    public static int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }

        // 可以理解为三个指向有序链表头结点的指针
        int p2 = 1, p3 = 1, p5 = 1;
        // 可以理解为三个有序链表的头节点的值
        int product2 = 1, product3 = 1, product5 = 1;
        // 可以理解为最终合并的有序链表（结果链表）
        int[] ugly = new int[n + 1];
        // 可以理解为结果链表上的指针
        int u = 1;

        while (u <= n) {
            int min = Math.min(product2, Math.min(product3, product5));
            ugly[u++] = min;
            if (min == product2) {
                product2 = 2 * ugly[p2];
                p2++;
            }
            if (min == product3) {
                product3 = 3 * ugly[p3];
                p3++;
            }
            if (min == product5) {
                product5 = 5 * ugly[p5];
                p5++;
            }
        }
        return ugly[n];
    }

}
