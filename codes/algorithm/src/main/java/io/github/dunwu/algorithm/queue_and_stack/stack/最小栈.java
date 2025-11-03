package io.github.dunwu.algorithm.queue_and_stack.stack;

import org.junit.jupiter.api.Assertions;

import java.util.Stack;

/**
 * <a href="https://leetcode-cn.com/problems/min-stack-lcci/">面试题 03.02. 栈的最小值</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-20
 */
public class 最小栈 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assertions.assertEquals(-3, minStack.getMin());
        minStack.pop();
        Assertions.assertEquals(0, minStack.top());
        Assertions.assertEquals(-2, minStack.getMin());
    }

    static class MinStack {

        // 记录栈中的所有元素
        Stack<Integer> stack;
        // 阶段性记录栈中的最小元素
        Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val < minStack.peek()) {
                minStack.push(val);
            } else {
                minStack.push(minStack.peek());
            }
        }

        public void pop() {
            minStack.pop();
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }

    }

}
