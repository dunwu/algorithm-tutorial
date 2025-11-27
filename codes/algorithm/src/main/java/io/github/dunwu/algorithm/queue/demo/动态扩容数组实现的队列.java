package io.github.dunwu.algorithm.queue.demo;

import java.util.Arrays;

/**
 * Created by wangzheng on 2018/10/9.
 */
public class 动态扩容数组实现的队列 {

    public static void main(String[] args) {
        动态扩容数组实现的队列 queue = new 动态扩容数组实现的队列(3);
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.printAll();
        System.out.println("dequeue " + queue.dequeue());
        queue.printAll();
        System.out.println("dequeue " + queue.dequeue());
        queue.printAll();
    }

    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为capacity的数组
    public 动态扩容数组实现的队列(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // 入队操作，将item放入队尾
    public boolean enqueue(String item) {
        // 队列已满，扩容
        if (tail == n) {
            n = n * 2;
            items = Arrays.copyOf(items, n);
        }

        items[tail] = item;
        tail++;
        return true;
    }

    // 出队
    public String dequeue() {
        // 如果head == tail 表示队列为空
        if (head == tail) return null;
        String val = items[head];
        items = Arrays.copyOfRange(items, 1, tail);
        tail--;
        return val;
    }

    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

}
