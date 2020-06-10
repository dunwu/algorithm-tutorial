package io.github.dunwu.algorithm.queue;

/**
 * 基于链表实现的队列
 * <p>
 * Author: Zheng
 */
public class 链表实现的队列 {

    public static void main(String[] args) {
        链表实现的队列 queue = new 链表实现的队列();
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

    // 队列的队首和队尾
    private Node head = null;
    private Node tail = null;

    // 入队
    public void enqueue(String value) {
        if (head == null) {
            tail = new Node(value, null);
            head = tail;
        } else {
            tail.next = new Node(value, null);
            tail = tail.next;
        }
    }

    // 出队
    public String dequeue() {
        if (head == null) {
            return null;
        }

        String val = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return val;
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node {

        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }

    }

}
