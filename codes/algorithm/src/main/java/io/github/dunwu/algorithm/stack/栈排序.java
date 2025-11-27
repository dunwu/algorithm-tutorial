package io.github.dunwu.algorithm.stack;

import org.junit.jupiter.api.Assertions;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/sort-of-stacks-lcci/">面试题 03.05. 栈排序</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-26
 */
public class 栈排序 {

    public static void main(String[] args) {
        SortedStack s = new SortedStack();
        s.push(1);
        s.push(2);
        Assertions.assertEquals(1, s.peek());
        s.pop();
        Assertions.assertEquals(2, s.peek());

        SortedStack s2 = new SortedStack();
        s2.pop();
        s2.pop();
        s2.push(1);
        s2.pop();
        Assertions.assertTrue(s2.isEmpty());
    }

    static class SortedStack {

        private Stack<Integer> s;
        private Stack<Integer> t;

        public SortedStack() {
            s = new Stack<>();
            t = new Stack<>();
        }

        public void push(int val) {
            if (s.isEmpty()) {
                s.push(val);
                return;
            }
            while (!s.isEmpty() && s.peek() < val) {
                t.push(s.pop());
            }
            s.push(val);
            while (!t.isEmpty()) {
                s.push(t.pop());
            }
        }

        public void pop() {
            if (!s.isEmpty()) {
                s.pop();
            }
        }

        public int peek() {
            return s.isEmpty() ? -1 : s.peek();
        }

        public boolean isEmpty() {
            return s.isEmpty();
        }

    }

}
