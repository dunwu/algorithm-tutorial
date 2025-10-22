package io.github.dunwu.algorithm.queue_and_stack;

import io.github.dunwu.algorithm.queue_and_stack.stack.GenericStack;
import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/basic-calculator/">224. 基本计算器</a>
 * @since 2020-06-09
 */
public class 基本计算器 {

    public static void main(String[] args) {
        Assertions.assertEquals(23, calculate("(1+(4+5+2)-3)+(6+8)"));
        Assertions.assertEquals(3, calculate("2-(5-6)"));
        Assertions.assertEquals(12, calculate("1+(4+5+2)"));
        Assertions.assertEquals(2147483647, calculate("2147483647"));
        Assertions.assertEquals(2, calculate("1 + 1"));
        Assertions.assertEquals(3, calculate("2 - 1 + 2"));
    }

    public static int calculate(String s) {
        int sign = 1;
        int current = 0;
        int result = 0;
        GenericStack<Integer> stack = new GenericStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                current = current * 10 + (c - '0');
            } else if (c == '+') {
                // 累加上一个操作数并重置
                result = result + sign * current;
                current = 0;
                // 设置下一个操作数的正负号
                sign = 1;
            } else if (c == '-') {
                // 累加上一个操作数并重置
                result = result + sign * current;
                current = 0;
                // 设置下一个操作数的正负号
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (c == ')') {
                // 累加上一个操作数并重置
                result = result + sign * current;
                current = 0;
                // 依次取出暂存栈中的正负号和操作数
                sign = stack.pop();
                int temp = stack.pop();
                // 累加
                result = temp + sign * result;
            }
        }

        if (current != 0) {
            result = result + sign * current;
        }
        return result;
    }

}
