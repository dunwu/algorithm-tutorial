package io.github.dunwu.algorithm.queue_and_stack.queue;

/**
 * 用数组实现的队列
 * Created by wangzheng on 2018/10/9.
 */
public class 数组实现的队列 {

    public static void main(String[] args) {
        数组实现的队列 queue = new 数组实现的队列(3);
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
    public 数组实现的队列(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // 入队
    public boolean enqueue(String item) {
        // 如果tail == n 表示队列已经满了
        if (tail == n) return false;
        items[tail] = item;
        ++tail;
        return true;
    }

    // 出队
    public String dequeue() {
        // 如果head == tail 表示队列为空
        if (head == tail) return null;
        // 为了让其他语言的同学看的更加明确，把--操作放到单独一行来写了
        String ret = items[head];
        ++head;
        return ret;
    }

    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

}
