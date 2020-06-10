package io.github.dunwu.algorithm.stack;

import java.util.LinkedList;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-18
 */
public class 最小栈2 {

    // 数据栈
    private LinkedList<Integer> data;

    // 辅助栈
    private LinkedList<Integer> helper;

    /**
     * initialize your data structure here.
     */
    public 最小栈2() {
        data = new LinkedList<>();
        helper = new LinkedList<>();
    }

    // 思路 1：数据栈和辅助栈在任何时候都同步
    public void push(int x) {
        // 数据栈和辅助栈一定会增加元素
        data.push(x);
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.push(x);
        } else {
            helper.push(helper.peek());
        }
    }

    public void pop() {
        // 两个栈都得 pop
        if (!data.isEmpty()) {
            helper.pop();
            data.pop();
        }
    }

    public int top() {
        if (!data.isEmpty()) {
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public int getMin() {
        if (!helper.isEmpty()) {
            return helper.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

}
