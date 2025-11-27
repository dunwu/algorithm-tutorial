package io.github.dunwu.algorithm.design;

import org.junit.jupiter.api.Assertions;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/basic-calculator-ii/">227. 基本计算器 II</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 基本计算器2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(2147483647, s.calculate("2147483647"));
        Assertions.assertEquals(2, s.calculate("1 + 1"));
        Assertions.assertEquals(3, s.calculate("2 - 1 + 2"));
        Assertions.assertEquals(7, s.calculate("3+2*2"));
    }

    static class Solution {

        public int calculate(String s) {
            return calculate(s, 0, s.length() - 1);
        }

        public int calculate(String s, int start, int end) {
            int num = 0;
            char sign = '+';
            Stack<Integer> stack = new Stack<>();
            for (int i = start; i <= end; i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                }
                if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
                    int pre = 0;
                    switch (sign) {
                        case '+':
                            stack.push(num);
                            break;
                        case '-':
                            stack.push(-num);
                            break;
                        case '*':
                            pre = stack.pop();
                            stack.push(pre * num);
                            break;
                        case '/':
                            pre = stack.pop();
                            stack.push(pre / num);
                            break;
                        default:
                            break;
                    }
                    sign = c;
                    num = 0;
                }
            }

            int result = 0;
            while (!stack.isEmpty()) {
                result += stack.pop();
            }
            return result;
        }

    }

}
