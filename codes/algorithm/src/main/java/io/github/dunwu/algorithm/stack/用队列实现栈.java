package io.github.dunwu.algorithm.stack;

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

        int top = -1;
        Queue<Integer> queue = new LinkedList<>();

        public MyStack() { }

        public void push(int x) {
            top = x;
            queue.offer(x);
        }

        public int pop() {
            int size = queue.size();
            while (size > 2) {
                queue.offer(queue.poll());
                size--;
            }
            // 倒数第 2 个值作为 top
            top = queue.poll();
            queue.offer(top);
            return queue.poll();
        }

        public int top() {
            return top;
        }

        public boolean empty() {
            return queue.isEmpty();
        }

    }

}
