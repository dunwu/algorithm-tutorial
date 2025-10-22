package io.github.dunwu.algorithm.queue_and_stack;

import io.github.dunwu.algorithm.queue_and_stack.stack.GenericStack;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/baseball-game/submissions/">682. 棒球比赛</a>
 * @since 2020-06-09
 */
public class 棒球比赛 {

    public static void main(String[] args) {
        System.out.println(calPoints("5", "2", "C", "D", "+"));
        System.out.println(calPoints("5", "-2", "4", "C", "D", "9", "+", "+"));
    }

    public static int calPoints(String... ops) {
        int total = 0;
        GenericStack<Integer> stack = new GenericStack<>();
        for (String s : ops) {
            if (s.equals("+")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int num = num1 + num2;
                stack.push(num2);
                stack.push(num1);
                stack.push(num);
            } else if (s.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (s.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(s));
            }
        }

        while (stack.getSize() != 0) {
            total += stack.pop();
        }

        return total;
    }

}
