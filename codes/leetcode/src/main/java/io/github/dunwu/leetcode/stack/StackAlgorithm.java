package io.github.dunwu.leetcode.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-05-13
 */
public class StackAlgorithm {

    /**
     * @see <a href="https://leetcode-cn.com/problems/three-in-one-lcci/solution/">面试题 03.01. 三合一</a>
     */
    public static class TripleInOne {

        int stackSize;
        List<LinkedList<Integer>> stacks;

        public TripleInOne(int stackSize) {
            this.stackSize = stackSize;
            this.stacks = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                LinkedList<Integer> list = new LinkedList<>();
                this.stacks.add(list);
            }
        }

        public void push(int stackNum, int value) {
            LinkedList<Integer> list = stacks.get(stackNum);
            if (list.size() < stackSize) {
                list.addLast(value);
            }
        }

        public int pop(int stackNum) {
            LinkedList<Integer> list = stacks.get(stackNum);
            int value = -1;
            if (list.size() > 0) {
                value = list.getLast();
                list.removeLast();
            }
            return value;
        }

        public int peek(int stackNum) {
            LinkedList<Integer> list = stacks.get(stackNum);
            int value = -1;
            if (list.size() > 0) {
                value = list.getLast();
            }
            return value;
        }

        public boolean isEmpty(int stackNum) {
            LinkedList<Integer> list = stacks.get(stackNum);
            return list.size() <= 0;
        }

    }

    /**
     * @see <a href="https://leetcode-cn.com/problems/min-stack-lcci/">面试题 03.02. 栈的最小值</a>
     */
    public static class MinStack {

        private LinkedList<Integer> data;

        public MinStack() {
            this.data = new LinkedList<>();
        }

        public void push(int x) {
            this.data.push(x);
        }

        public void pop() {
            this.data.pop();
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

    public static class StackOfPlates {

        private int cap;
        private List<LinkedList<Integer>> stackList;

        public StackOfPlates(int cap) {
            this.cap = cap;
            stackList = new ArrayList<>();
        }

        public void push(int val) {
            if (cap <= 0) {
                return;
            }

            if (stackList.isEmpty() || stackList.get(stackList.size() - 1).size() == cap) {
                LinkedList<Integer> stack = new LinkedList<>();
                stack.push(val);
                stackList.add(stack);
                return;
            }

            stackList.get(stackList.size() - 1).push(val);
        }

        public int pop() {
            return popAt(stackList.size() - 1);
        }

        public int popAt(int index) {
            if (index < 0 || index >= stackList.size()) {
                return -1;
            }

            LinkedList<Integer> stack = stackList.get(index);
            if (stack.isEmpty()) {
                return -1;
            }

            int res = stack.pop();

            if (stack.isEmpty()) {
                stackList.remove(index);
            }

            return res;
        }

    }

    /**
     * @see <a href="https://leetcode-cn.com/problems/implement-queue-using-stacks-lcci/">面试题 03.04. 化栈为队</a>
     */
    public static class MyQueue {

        private LinkedList<Integer> stack1;
        private LinkedList<Integer> stack2;

        /** Initialize your data structure here. */
        public MyQueue() {
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
            return stack2.isEmpty() ? -1 : stack2.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (empty()) { return -1; }

            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                return peek();
            } else {
                return stack2.peek();
            }
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }

    }

    /**
     * @see <a href="https://leetcode-cn.com/problems/sort-of-stacks-lcci/">面试题 03.05. 栈排序</a>
     */
    public static class SortedStack {

        public LinkedList<Integer> stack1;
        public LinkedList<Integer> stack2;

        public SortedStack() {
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

}
