package io.github.dunwu.algorithm.stack;

import org.junit.jupiter.api.Assertions;

/**
 * @see <a href="https://leetcode-cn.com/problems/valid-parentheses/">20. 有效的括号</a>
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 有效的括号 {

    public static void main(String[] args) {
        Assertions.assertTrue(isValid("()"));
        Assertions.assertTrue(isValid("{[]}"));
        Assertions.assertFalse(isValid("([)]"));
        Assertions.assertFalse(isValid("([)"));
    }

    public static boolean isValid(String s) {
        if (s == null) {
            return true;
        }

        int length = s.length();
        if (length == 0) return true;
        if (length % 2 != 0) return false;

        GenericStack<Character> stack = new GenericStack<>();
        for (char c : s.toCharArray()) {
            Character top = stack.peek();
            if (top == null) {
                stack.push(c);
                continue;
            }

            if (top == '(' && c == ')') {
                stack.pop();
            } else if (top == '[' && c == ']') {
                stack.pop();
            } else if (top == '{' && c == '}') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        if (stack.getSize() == 0) {
            return true;
        }
        return false;
    }

}
