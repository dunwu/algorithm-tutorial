package io.github.dunwu.algorithm.queue;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/design-circular-queue/">622. 设计循环队列</a>
 * @since 2020-06-10
 */
public class 设计循环队列 {

    public static void main(String[] args) {
        设计循环队列 queue = new 设计循环队列(3);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.printAll();
        System.out.println("rear: " + queue.Rear());
        System.out.println("full: " + queue.isFull());
        queue.deQueue();
        queue.enQueue(4);
        queue.printAll();
        System.out.println("rear: " + queue.Rear());
    }

    private int[] data;
    private int head;
    // head表示队头下标，tail表示队尾下标
    private int tail;
    private int capacity;

    // 申请一个大小为capacity的数组（由于循环队列会浪费一个空间，所以如果想要存储元素数为capacity，数组维度n=capacity+1）
    public 设计循环队列(int k) {
        this.capacity = k + 1;
        this.data = new int[capacity];
        this.head = 0;
        this.tail = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        this.data[tail] = value;
        tail = (tail + 1) % capacity;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        head = (head + 1) % capacity;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return data[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        int  temp = (tail - 1 + capacity) % capacity;
        return data[temp];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if (head == tail) {
            return true;
        }
        return false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if ((tail + 1) % capacity == head) {
            return true;
        }
        return false;
    }

    public void printAll() {
        if (head == tail) {
            System.out.println("队列已空");
            return;
        }
        for (int i = head; i != tail; ) {
            System.out.print(data[i] + "\t");
            if (i == capacity - 1) {
                i = 0;
            } else {
                i++;
            }
        }
        System.out.println();
    }

}
