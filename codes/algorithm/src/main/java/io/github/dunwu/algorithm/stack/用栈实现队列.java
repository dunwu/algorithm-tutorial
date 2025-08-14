package io.github.dunwu.algorithm.stack;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

/**
 * <a href="https://leetcode-cn.com/problems/implement-queue-using-stacks/">232. 用栈实现队列</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-18
 */
public class 用栈实现队列 {

    public static void main(String[] args) {
        MyStack queue = new MyStack();
        int max = 10;
        for (int i = 1; i <= max; i++) {
            queue.push(i);
        }
        for (int i = 1; i <= max; i++) {
            Assertions.assertEquals(i, queue.peek());
            Assertions.assertEquals(i, queue.pop());
        }
    }

    static class MyStack {

        private LinkedList<Integer> s1 = new LinkedList<>();
        private LinkedList<Integer> s2 = new LinkedList<>();

        public void push(int x) {
            s1.push(x);
        }

        public int pop() {
            peek();
            return s2.pop();
        }

        public int peek() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }

        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }

    }

}
