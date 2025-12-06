package io.github.dunwu.algorithm.array.two_pointer;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/add-binary/">67. 二进制求和</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-01-21
 */
public class 二进制求和 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals("100", s.addBinary("11", "1"));
        Assertions.assertEquals("10101", s.addBinary("1010", "1011"));
    }

    static class Solution {

        public String addBinary(String a, String b) {
            int i = a.length() - 1;
            int j = b.length() - 1;
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            while (i >= 0 || j >= 0) {
                int numA = i < 0 ? 0 : a.charAt(i--) - '0';
                int numB = j < 0 ? 0 : b.charAt(j--) - '0';
                int sum = numA + numB + carry;
                if (sum > 1) {
                    carry = 1;
                    sb.append(sum % 2);
                } else {
                    carry = 0;
                    sb.append(sum);
                }
            }
            if (carry > 0) {
                sb.append(carry);
            }
            return sb.reverse().toString();
        }

    }

}
