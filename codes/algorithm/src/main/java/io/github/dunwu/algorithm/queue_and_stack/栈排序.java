package io.github.dunwu.algorithm.queue_and_stack;

import java.util.LinkedList;

/**
 * @see <a href="https://leetcode-cn.com/problems/sort-of-stacks-lcci/">面试题 03.05. 栈排序</a>
 */
public class 栈排序 {

    public static void main(String[] args) {
        栈排序 demo = new 栈排序();
        demo.push(1);
        System.out.println(demo.stack1);
        demo.push(2);
        System.out.println(demo.stack1);
    }

    public LinkedList<Integer> stack1;
    public LinkedList<Integer> stack2;

    public 栈排序() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int val) {
        if (isEmpty()) {
            stack1.push(val);
            return;
        }

        if (!stack1.isEmpty()) {
            move(val);
        }

        stack1.push(val);
        while (!stack2.isEmpty()) {
            Integer top = stack2.pop();
            stack1.push(top);
        }
    }

    private void move(int val) {
        if (stack1.isEmpty()) {
            return;
        }

        int top = peek();
        if (top < val) {
            stack2.push(stack1.pop());
            move(val);
        }
    }

    public int pop() {
        if (stack1.isEmpty()) {
            return -1;
        }
        return stack1.pop();
    }

    public int peek() {
        if (stack1.isEmpty()) {
            return -1;
        }
        return stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
