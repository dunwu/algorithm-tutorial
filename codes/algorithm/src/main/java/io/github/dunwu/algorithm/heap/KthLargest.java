package io.github.dunwu.algorithm.heap;

import java.util.PriorityQueue;

// 703. 数据流中的第K大元素
//
// 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
//
// 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
//
// 示例:
//
// int k = 3;
// int[] arr = [4,5,8,2];
// KthLargest kthLargest = new KthLargest(3, arr);
// kthLargest.add(3);   // returns 4
// kthLargest.add(5);   // returns 5
// kthLargest.add(10);  // returns 5
// kthLargest.add(9);   // returns 8
// kthLargest.add(4);   // returns 8
// 说明:
// 你可以假设 nums 的长度≥ k-1 且k ≥ 1。

public class KthLargest<T extends Comparable<T>> {

    private int size;

    private PriorityQueue<T> queue;

    public KthLargest(int k, T[] nums) {
        size = k;
        queue = new PriorityQueue<>(k);
        for (T num : nums) {
            add(num);
        }
    }

    public T add(T val) {
        if (queue.size() < size) {
            queue.add(val);
        } else if (queue.peek().compareTo(val) < 0) {
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[] { 4, 5, 8, 2 };
        KthLargest<Integer> demo = new KthLargest<>(3, data);
        System.out.println("args = " + demo.add(3));
        System.out.println("args = " + demo.add(5));
        System.out.println("args = " + demo.add(10));
        System.out.println("args = " + demo.add(9));
        System.out.println("args = " + demo.add(4));
    }

}
