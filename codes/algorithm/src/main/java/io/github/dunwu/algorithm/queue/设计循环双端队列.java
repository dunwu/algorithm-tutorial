package io.github.dunwu.algorithm.queue;

/**
 * <a href="https://leetcode-cn.com/problems/design-circular-deque/">641. 设计循环双端队列</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-10
 */
public class 设计循环双端队列 {

    public static void main(String[] args) {
        设计循环双端队列 queue = new 设计循环双端队列(3);
        queue.insertFront(1);
        queue.insertFront(2);
        queue.insertFront(3);
        queue.insertFront(4);
        queue.printAll();
        queue.deleteFront();
        queue.printAll();
        queue.deleteFront();
        queue.printAll();
        queue.deleteFront();
        queue.printAll();

        queue.insertLast(1);
        queue.insertLast(2);
        queue.insertLast(3);
        queue.insertLast(4);
        queue.printAll();
        queue.deleteLast();
        queue.printAll();
        // System.out.println("rear: " + queue.Rear());
        // System.out.println("full: " + queue.isFull());
        // queue.deQueue();
        // queue.enQueue(4);
        // queue.printAll();
        // System.out.println("rear: " + queue.Rear());
    }

    private int[] data;
    private int head;
    // head表示队头下标，tail表示队尾下标
    private int tail;
    private int capacity;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public 设计循环双端队列(int k) {
        this.capacity = k + 1;
        this.data = new int[this.capacity];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        head = (head - 1 + capacity) % capacity;
        data[head] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        this.data[tail] = value;
        tail = (tail + 1) % capacity;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        head = (head + 1) % capacity;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        tail = (tail - 1 + capacity) % capacity;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }

        return data[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }

        int temp = (tail - 1 + capacity) % capacity;
        return data[temp];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if (head == tail) {
            return true;
        }
        return false;
    }

    /** Checks whether the circular deque is full or not. */
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
