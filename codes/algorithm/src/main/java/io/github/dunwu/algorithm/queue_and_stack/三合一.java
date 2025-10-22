package io.github.dunwu.algorithm.queue_and_stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 三合一 {

    int stackSize;
    List<LinkedList<Integer>> stacks;

    public 三合一(int stackSize) {
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
