package io.github.dunwu.algorithm.queue_and_stack;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode-cn.com/problems/implement-stack-using-queues/">225. 用队列实现栈</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-18
 */
public class 用队列实现栈 {

    public static void main(String[] args) {
        MyStack s1 = new MyStack();
        s1.push(1);
        s1.push(2);
        Assertions.assertEquals(2, s1.top());
        Assertions.assertEquals(2, s1.pop());
        Assertions.assertFalse(s1.empty());

        int max = 10;
        MyStack stack = new MyStack();
        for (int i = 1; i <= max; i++) {
            stack.push(i);
        }
        for (int i = 1; i <= max; i++) {
            Assertions.assertEquals(max - i + 1, stack.top());
            Assertions.assertEquals(max - i + 1, stack.pop());
        }
    }

    static class MyStack {

        private Integer top;
        Queue<Integer> q;

        public MyStack() {
            q = new LinkedList<>();
        }

        public void push(int x) {
            q.offer(x);
            top = x;
        }

        public int pop() {
            int size = q.size();
            for (int i = 1; i < size; i++) {
                Integer val = q.poll();
                q.offer(val);
                top = val;
            }
            return q.poll();
        }

        public int top() {
            return top == null ? 0 : top;
        }

        public boolean empty() {
            return q.isEmpty();
        }

    }

}
