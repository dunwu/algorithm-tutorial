package io.github.dunwu.algorithm.stack;

import org.junit.jupiter.api.Assertions;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/evaluate-reverse-polish-notation/">150. 逆波兰表达式求值</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 逆波兰表达式求值 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(9, s.evalRPN(new String[] { "2", "1", "+", "3", "*" }));
        Assertions.assertEquals(6, s.evalRPN(new String[] { "4", "13", "5", "/", "+" }));
        Assertions.assertEquals(22,
            s.evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" }));
    }

    static class Solution {

        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for (String token : tokens) {
                if ("+".equals(token)) {
                    Integer numB = stack.pop();
                    Integer numA = stack.pop();
                    stack.push(numA + numB);
                } else if ("-".equals(token)) {
                    Integer numB = stack.pop();
                    Integer numA = stack.pop();
                    stack.push(numA - numB);
                } else if ("*".equals(token)) {
                    Integer numB = stack.pop();
                    Integer numA = stack.pop();
                    stack.push(numA * numB);
                } else if ("/".equals(token)) {
                    Integer numB = stack.pop();
                    Integer numA = stack.pop();
                    stack.push(numA / numB);
                } else {
                    stack.push(Integer.parseInt(token));
                }
            }
            return stack.pop();
        }

    }

}
