package io.github.dunwu.algorithm.queue_and_stack;

import io.github.dunwu.algorithm.queue_and_stack.stack.GenericStack;
import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/implement-queue-using-stacks/">844. 比较含退格的字符串</a>
 * @since 2020-06-09
 */
public class 比较含退格的字符串 {

    public static void main(String[] args) {
        Assertions.assertTrue(backspaceCompare("ab#c", "ad#c"));
        Assertions.assertTrue(backspaceCompare("ab##", "c#d#"));
        Assertions.assertTrue(backspaceCompare("a##c", "#a#c"));
        Assertions.assertFalse(backspaceCompare("a#c", "b"));
    }

    public static boolean backspaceCompare(String S, String T) {
        return getFinalStr(S).equals(getFinalStr(T));
    }

    public static String getFinalStr(String S) {
        GenericStack<Character> stack = new GenericStack<>();
        for (char c : S.toCharArray()) {
            if (c == '#') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (stack.getSize() > 0) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

}
