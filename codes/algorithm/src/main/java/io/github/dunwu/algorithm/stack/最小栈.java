package io.github.dunwu.algorithm.stack;

import java.util.LinkedList;

/**
 * @see <a href="https://leetcode-cn.com/problems/min-stack-lcci/">面试题 03.02. 栈的最小值</a>
 */
public class 最小栈 {

    public static void main(String[] args) {
        最小栈 stack = new 最小栈();
        stack.push(9);
        stack.push(2);
        stack.push(5);
        stack.push(6);
        stack.push(3);
        stack.push(1);
        System.out.println("min = " + stack.getMin());
        System.out.println("pop " + stack.pop());
        System.out.println("pop " + stack.pop());
        System.out.println("pop " + stack.pop());
    }

    private final LinkedList<Integer> stack;
    private final LinkedList<Integer> minStack;

    public 最小栈() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        if (!minStack.isEmpty()) {
            Integer first = minStack.getFirst();
            if (x < first) {
                minStack.push(x);
            }
            stack.push(x);
        }
    }

    public int pop() {
        int top = stack.pop();
        int val = minStack.peek() ;
        if (val == val) {
            minStack.pop();
        }
        return val;
    }

    public int top() {
        return stack.getFirst();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        } else {
            return minStack.getFirst();
        }
    }

}
