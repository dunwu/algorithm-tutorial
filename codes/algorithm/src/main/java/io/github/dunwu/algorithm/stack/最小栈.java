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

    private final LinkedList<Integer> data;

    public 最小栈() {
        this.data = new LinkedList<>();
    }

    public void push(int x) {
        this.data.push(x);
    }

    public int pop() {
        return this.data.pop();
    }

    public int top() {
        return this.data.getFirst();
    }

    public int getMin() {
        int min = data.get(0);
        for (Integer i : data) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

}
