package io.github.dunwu.algorithm.stack;

import org.junit.jupiter.api.Assertions;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/valid-parentheses/">20. 有效的括号</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 有效的括号 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertTrue(s.isValid("()"));
        Assertions.assertTrue(s.isValid("{[]}"));
        Assertions.assertFalse(s.isValid("([)]"));
        Assertions.assertFalse(s.isValid("([)"));
        Assertions.assertFalse(s.isValid("(("));
        Assertions.assertTrue(s.isValid("(())"));
    }

    static class Solution {

        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                switch (c) {
                    case ')':
                        if (stack.isEmpty()) { return false; }
                        if (stack.pop() != '(') { return false; }
                        break;
                    case ']':
                        if (stack.isEmpty()) { return false; }
                        if (stack.pop() != '[') { return false; }
                        break;
                    case '}':
                        if (stack.isEmpty()) { return false; }
                        if (stack.pop() != '{') { return false; }
                        break;
                    default:
                        stack.push(c);
                        break;
                }
            }
            return stack.isEmpty();
        }

    }

}
