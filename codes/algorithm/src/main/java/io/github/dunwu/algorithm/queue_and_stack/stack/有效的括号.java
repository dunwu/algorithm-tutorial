package io.github.dunwu.algorithm.queue_and_stack.stack;

import org.junit.jupiter.api.Assertions;

import java.util.Stack;

/**
 * <a href="https://leetcode-cn.com/problems/valid-parentheses/">20. 有效的括号</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 有效的括号 {

    public static void main(String[] args) {
        Assertions.assertTrue(isValid("()"));
        Assertions.assertTrue(isValid("{[]}"));
        Assertions.assertFalse(isValid("([)]"));
        Assertions.assertFalse(isValid("([)"));
        Assertions.assertFalse(isValid("(("));
        Assertions.assertTrue(isValid("(())"));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() <= 1) { return false; }
        Stack<Character> left = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                // 字符 c 是左括号，入栈
                left.push(c);
            } else {
                // 字符 c 是右括号
                if (!left.isEmpty() && left.peek() == leftChar(c)) {
                    left.pop();
                } else {
                    // 和最近的左括号不匹配
                    return false;
                }
            }
        }
        // 是否还有左括号未匹配
        return left.isEmpty();
    }

    public static char leftChar(char c) {
        if (c == ')') {
            return '(';
        } else if (c == '}') {
            return '{';
        }
        return '[';
    }

}
