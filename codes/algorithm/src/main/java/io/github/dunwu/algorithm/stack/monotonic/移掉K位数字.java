package io.github.dunwu.algorithm.stack.monotonic;

import org.junit.jupiter.api.Assertions;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/remove-k-digits/">402. 移掉 K 位数字</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-26
 */
public class 移掉K位数字 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals("1219", s.removeKdigits("1432219", 3));
    }

    static class Solution {

        public String removeKdigits(String num, int k) {
            Stack<Character> stack = new Stack<>();
            for (char c : num.toCharArray()) {
                while (!stack.isEmpty() && stack.peek() > c && k > 0) {
                    stack.pop();
                    k--;
                }
                if (stack.isEmpty() && c == '0') {
                    continue;
                }
                stack.push(c);
            }

            while (k > 0 && !stack.isEmpty()) {
                stack.pop();
                k--;
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.reverse().toString();
        }

    }

}
