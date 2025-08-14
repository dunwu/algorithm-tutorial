package io.github.dunwu.algorithm.stack;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @see <a href="https://leetcode-cn.com/problems/min-stack-lcci/">面试题 03.02. 栈的最小值</a>
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

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public MinStack() {

        }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty()) {
                minStack.push(val);
            } else {
                Integer lastMin = minStack.peek();
                if (val <= lastMin) {
                    minStack.push(val);
                } else {
                    minStack.push(lastMin);
                }
            }
        }

        public int pop() {
            minStack.pop();
            return stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }

    }

}
