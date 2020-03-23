package io.github.dunwu.leetcode.heap;

import java.util.PriorityQueue;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-03-06
 */
public class KthLeast<T extends Comparable<T>> {

    private int size;

    private PriorityQueue<T> queue;

    public KthLeast(int k, T[] array) {
        this.size = k;
        queue = new PriorityQueue<>(k);
        for (T v : array) {
            add(v);
        }
    }

    public T add(T val) {
        if (queue.size() < size) {
            queue.add(val);
        } else if (queue.peek().compareTo(val) > 0) {
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }

    public T pop() {
        return queue.poll();
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[] { 3, 2, 1 };
        KthLeast<Integer> demo = new KthLeast<>(2, data);
        System.out.println("args = " + demo.pop());
        System.out.println("args = " + demo.pop());
    }

}
