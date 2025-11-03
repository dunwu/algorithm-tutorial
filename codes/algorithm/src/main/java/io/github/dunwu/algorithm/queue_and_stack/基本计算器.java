package io.github.dunwu.algorithm.queue_and_stack;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <a href="https://leetcode-cn.com/problems/basic-calculator/">224. 基本计算器</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 基本计算器 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(23, s.calculate("(1+(4+5+2)-3)+(6+8)"));
        Assertions.assertEquals(12, s.calculate("1+(4+5+2)"));
        Assertions.assertEquals(2147483647, s.calculate("2147483647"));
        Assertions.assertEquals(2, s.calculate("1 + 1"));
        Assertions.assertEquals(3, s.calculate("2 - 1 + 2"));
    }

    static class Solution {

        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else if (s.charAt(i) == ')') {
                    map.put(stack.pop(), i);
                }
            }
            return calculate(s, 0, s.length() - 1, map);
        }

        public int calculate(String s, int start, int end, Map<Integer, Integer> map) {
            int num = 0;
            char sign = '+';
            Stack<Integer> stack = new Stack<>();
            for (int i = start; i <= end; i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                }
                if (c == '(') {
                    num = calculate(s, i + 1, map.get(i) - 1, map);
                    i = map.get(i);
                }

                if (c == '+' || c == '-' || c == '*' || c == '/' || i == end) {
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
