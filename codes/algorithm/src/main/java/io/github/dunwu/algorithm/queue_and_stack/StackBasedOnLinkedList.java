package io.github.dunwu.algorithm.queue_and_stack;

/**
 * 基于链表实现的栈。
 * <p>
 * Author: Zheng
 */
public class StackBasedOnLinkedList {

    public static void main(String[] args) {
        StackBasedOnLinkedList stack = new StackBasedOnLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.printAll();
        System.out.println("pop " + stack.pop());
        System.out.println("pop " + stack.pop());
        System.out.println("pop " + stack.pop());
    }

    private Node top = null;

    public void push(int value) {
        Node node = new Node(value, null);
        if (top == null) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }
    }

    /**
     * 我用-1表示栈中没有数据。
     */
    public int pop() {
        if (top == null) return -1;
        int val = top.data;
        top = top.next;
        return val;
    }

    public void printAll() {
        Node p = top;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node {

        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

    }

}
