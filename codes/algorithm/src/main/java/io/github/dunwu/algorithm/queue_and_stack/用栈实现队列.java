package io.github.dunwu.algorithm.queue_and_stack;

import org.junit.jupiter.api.Assertions;

import java.util.Stack;

/**
 * <a href="https://leetcode-cn.com/problems/implement-queue-using-stacks/">232. 用栈实现队列</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-18
 */
public class 用栈实现队列 {

    public static void main(String[] args) {

        // MyQueue q1 = new MyQueue();
        // q1.push(1); // queue is: [1]
        // q1.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        // Assertions.assertEquals(1, q1.peek());
        // Assertions.assertEquals(1, q1.pop());
        // Assertions.assertFalse(q1.empty());
        // Assertions.assertEquals(2, q1.pop());
        // Assertions.assertTrue(q1.empty());

        MyQueue q2 = new MyQueue();
        q2.push(1);
        q2.push(2);
        Assertions.assertEquals(1, q2.pop());
        q2.push(3);
        q2.push(4);
        Assertions.assertEquals(2, q2.pop());
        Assertions.assertEquals(3, q2.peek());

        MyQueue q3 = new MyQueue();
        int max = 10;
        for (int i = 1; i <= max; i++) {
            q3.push(i);
        }
        for (int i = 1; i <= max; i++) {
            Assertions.assertEquals(i, q3.peek());
            Assertions.assertEquals(i, q3.pop());
        }
    }

    static class MyQueue {

        private Stack<Integer> s1;
        private Stack<Integer> s2;

        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            s1.push(x);
        }

        public int pop() {
            peek();
            Integer top = s2.pop();
            return top == null ? 0 : top;
        }

        public int peek() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.isEmpty() ? 0 : s2.peek();
        }

        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }

    }

}
