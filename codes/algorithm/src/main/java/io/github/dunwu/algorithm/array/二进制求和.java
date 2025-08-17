package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/add-binary/">67. 二进制求和</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-01-21
 */
public class 二进制求和 {

    public static void main(String[] args) {
        Assertions.assertEquals("100", addBinary("11", "1"));
        Assertions.assertEquals("10101", addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {

        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;

        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = arrA.length - 1, j = arrB.length - 1;
        while (i >= 0 || j >= 0) {
            int value = carry;
            if (i >= 0) {
                value += arrA[i--] - '0';
            }
            if (j >= 0) {
                value += arrB[j--] - '0';
            }
            carry = value / 2;
            value = value % 2;
            sb.append(value);
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

}
