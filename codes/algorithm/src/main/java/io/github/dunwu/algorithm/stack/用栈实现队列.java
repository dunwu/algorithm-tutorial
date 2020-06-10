package io.github.dunwu.algorithm.stack;

import java.util.LinkedList;

/**
 * @see <a href="https://leetcode-cn.com/problems/implement-queue-using-stacks/">232. 用栈实现队列</a>
 */
public class 用栈实现队列 {

    public static void main(String[] args) {
        用栈实现队列 queue = new 用栈实现队列();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek()); // 返回 1
        System.out.println(queue.pop()); // 返回 1
        System.out.println(queue.empty()); // 返回 false
    }

    private LinkedList<Integer> stack1;
    private LinkedList<Integer> stack2;

    /** Initialize your data structure here. */
    public 用栈实现队列() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stack2.size() > 0) {
            return stack2.peek();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
