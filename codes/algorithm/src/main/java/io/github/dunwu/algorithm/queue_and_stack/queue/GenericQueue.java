package io.github.dunwu.algorithm.queue_and_stack.queue;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-10
 */
public class GenericQueue<T> {

    // 队列的队首和队尾
    private Node<T> head = null;
    private Node<T> tail = null;

    // 入队
    public void enqueue(T value) {
        if (head == null) {
            tail = new Node<T>(value, null);
            head = tail;
        } else {
            tail.next = new Node<T>(value, null);
            tail = tail.next;
        }
    }

    // 出队
    public T dequeue() {
        if (head == null) {
            return null;
        }

        T val = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return val;
    }

    public void printAll() {
        Node<T> p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node<T> {

        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

    }

}
